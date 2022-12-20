package firstlabFed;

import java.util.Arrays;

import java.util.*;


public class MainApplication {


    public static void main(String[] args) {

        boolean cals = Arrays.stream(args).anyMatch("-calories"::equals);
        try {

            Food[] food = new Food[15];

            food[0] = new Potato(Potato.Fried);
            food[1] = new Potato(Potato.Fries);
            food[2] = new Potato(Potato.Boiled);
            food[3] = new Tea(Tea.Black);
            food[4] = new Tea(Tea.Green);
            food[5] = new Tea(Tea.Blue);
            food[6] = new Beef(Beef.Rare);
            food[7] = new Beef(Beef.Medium);
            food[8] = new Beef(Beef.WellDone);
            food[9] = new Milk(Milk.Fat1point5);
            food[10] = new Milk(Milk.Fat2point5);
            food[11] = new Milk(Milk.Fat5);
            food[12] = new Coffee(Coffee.Saturated);
            food[13] = new Coffee(Coffee.Bitter);
            food[14] = new Coffee(Coffee.Oriental);



            Arrays.sort(food, (Food x, Food y) -> {
                return y.calculateCalories() - x.calculateCalories();
            });

            int sumCalories = 0;
            for (int i = 0; i < 15; i++) {
                int curCalories = food[i].calculateCalories();
                food[i].consume();
                sumCalories += curCalories;
            }
            if (cals){
                System.out.printf("Sum of calories: " + sumCalories);
            }

        } catch (Exception e) {
            e.getMessage();
        }

    }

}