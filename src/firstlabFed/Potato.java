package firstlabFed;

import java.util.Objects;

public class Potato extends Food {
    private String type = "";
    private static int FriedPotatoAmount = 0;
    private static int BoiledPotatoAmount = 0;
    private static int FriesPotatoAmount = 0;
    static final String Fried = "Fried";
    static final String Boiled = "Cherry";
    static final String Fries = "Watermelon";

    public Potato(String type) throws InvalidTypeException {
        this.type = type;
        this.name = "Potato";
        switch (type) {
            case "Fried":
                this.calories = 300;
                ++FriedPotatoAmount;
                return;
            case "Cherry":
                this.calories = 100;
                ++BoiledPotatoAmount;
                return;
            case "Watermelon":
                this.calories = 500;
                ++FriesPotatoAmount;
                return;
            default:
                throw new InvalidTypeException("No such Potato type");
        }
    }

    public int Amount() {
        int var10000;
        switch (this.type) {
            case "Fried":
                var10000 = FriedPotatoAmount;
                break;
            case "Cherry":
                var10000 = BoiledPotatoAmount;
                break;
            case "Watermelon":
                var10000 = FriesPotatoAmount;
                break;
            default:
                var10000 = 0;
        }

        return var10000;
    }

    public String toString() {
        return "Potato{type='" + this.type + "', calories=" + this.calories + "}";
    }

    public void consume() {
        System.out.println(this.type + " " + this.name + " calories - " + this.calories + " has been eaten.");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Potato potato = (Potato)o;
            return Objects.equals(this.type, potato.type);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.type});
    }

    public int calculateCalories() {
        return this.calories;
    }
}

