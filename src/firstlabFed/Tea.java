package firstlabFed;

import java.util.Objects;

public class Tea extends Food {
    private String color = "";
    private static int blackTeaAmount = 0;
    private static int greenTeaAmount = 0;
    private static int blueTeaAmount = 0;
    static final String Black = "Black";
    static final String Green = "Green";
    static final String Blue = "Blue";

    public Tea(String color) throws InvalidColorException {
        this.color = color;
        this.name = "Tea";
        switch (color) {
            case "Black":
                this.calories = 10;
                ++blackTeaAmount;
                break;
            case "Green":
                this.calories = 10;
                ++greenTeaAmount;
                break;
            case "Blue":
                this.calories = 10;
                ++blueTeaAmount;
                break;
            default:
                throw new InvalidColorException("Invalid tea color");
        }

    }

    public int Amount() {
        int var10000;
        switch (this.color) {
            case "Black":
                var10000 = blackTeaAmount;
                break;
            case "Green":
                var10000 = greenTeaAmount;
                break;
            case "Blue":
                var10000 = blueTeaAmount;
                break;
            default:
                var10000 = 0;
        }

        return var10000;
    }

    public String toString() {
        return "Tea{color='" + this.color + "', calories=" + this.calories + "}";
    }

    public void consume() {
        System.out.println(this.color + " " + this.name + " calories - " + this.calories + " has been eaten.");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Tea tea = (Tea)o;
            return Objects.equals(this.color, tea.color);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.color});
    }

    public int calculateCalories() {
        return this.calories;
    }
}

