package Lab3Fedorenko;

import javax.swing.table.AbstractTableModel;
import java.text.NumberFormat;
import java.util.Locale;


import javax.swing.table.AbstractTableModel;


public class GornerTableModel extends AbstractTableModel {
        private Double[] coefficients;

      //  private String[] str_value;

        private int length;
        private Double from;
        private Double to;
        private Double step;
        private double result[] = new double[1];

        public GornerTableModel(Double from, Double to, Double step, Double[] coefficients)
        {
                this.from = from;
                this.to = to;
                this.step = step;
                this.coefficients = coefficients;
        }
        public Double getFrom()
        {
                return from;
        }
        public Double getTo()
        {
                return to;
        }
        public Double getStep()
        {
                return step;
        }
        public int getColumnCount()
        {
                return 3;
        }
        public int getRowCount()
        {
                // Вычислить количество точек между началом и концом отрезка исходя из шага табулирования
                return new Double(Math.ceil((to-from)/step)).intValue()+1;
        }
        public Object getValueAt(int row, int col)
        {
                double x = from + step * row;
                switch (col)
                {
                        case 0:
                                return x;
                        case 1:
                        {
                                result[0] = 0.0;
                                for (int i = 0; i < coefficients.length; i++)
                                {
                                        result[0] += Math.pow(x, coefficients.length - 1 - i) * coefficients[i];
                                }
                                return result[0];
                        }
                        default:
                        {

                                result[0] = 0.0;
                                for (int i = 0; i < coefficients.length; i++)
                                        result[0] += Math.pow(x, coefficients.length - 1 - i) * coefficients[i];
                                String number = NumberFormat.getNumberInstance(new Locale("us")).format(result[0]);
                               // str_value[0] =  NumberFormat.getNumberInstance(new Locale("us")).format(result[0]);
                                length = number.length();
                                if(number.charAt(0) == number.charAt(length - 1) && length != 1){
                                        return true;
                                }
                                else
                                        return false;


                        }
                }
        }

        public String getColumnName(int col)
        {
                switch (col)
                {
                        case 0:
                                return "Значение X";
                        case 1:
                                return "Значение многочлена";
                        default:
                                return "Краевая симметрия";
                }
        }
        // необходимо предоставить сведения о типе данных в столбцах, в противном случае они будут отображены как строки
        public Class<?> getColumnClass(int col)
        {
                switch (col)
                {
                        case 2:
                                return Boolean.class;
                        default:
                                return Double.class;
                }
        }
}