package firstlabFed;

import java.util.Objects;

public class Milk extends Food {
    private String Fatness = "";
    private static int Fat1point5Amount = 0;
    private static int Fat2point5Amount = 0;
    private static int Fat5Amount = 0;
    static final String Fat1point5 = "Fat1.5";
    static final String Fat2point5 = "Fat2.5";
    static final String Fat5 = "Fat5";

    public Milk(String Fatness) throws InvalidColorException {
        this.Fatness = Fatness;
        this.name = "Milk";
        switch (Fatness) {
            case "Fat1.5":
                this.calories = 100;
                ++Fat1point5Amount;
                break;
            case "Fat2.5":
                this.calories = 175;
                ++Fat2point5Amount;
                break;
            case "Fat5":
                this.calories = 400;
                ++Fat5Amount;
                break;
            default:
                throw new InvalidColorException("Invalid Milk Fatness");
        }

    }

    public int Amount() {
        int var10000;
        switch (this.Fatness) {
            case "Fat1.5":
                var10000 = Fat1point5Amount;
                break;
            case "Fat2.5":
                var10000 = Fat2point5Amount;
                break;
            case "Fat5":
                var10000 = Fat5Amount;
                break;
            default:
                var10000 = 0;
        }

        return var10000;
    }

    public String toString() {
        return "Milk{ Fatness='" + this.Fatness + "', calories=" + this.calories + "}";
    }

    public void consume() {
        System.out.println(this.Fatness + " " + this.name + " calories - " + this.calories + " has been eaten.");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Milk milk = (Milk)o;
            return Objects.equals(this.Fatness, milk.Fatness);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.Fatness});
    }

    public int calculateCalories() {
        return this.calories;
    }
}

