package firstlabFed;
import java.util.Objects;

public class Coffee extends Food {
    private String Aroma = "";
    private static int saturatedCoffeeAmount = 0;
    private static int bitterCoffeeAmount = 0;
    private static int orientalCoffeeAmount = 0;
    static final String Saturated = "saturated";
    static final String Bitter = "bitter";
    static final String Oriental = "oriental";

    public Coffee(String aroma) throws InvalidColorException {
        this.Aroma = aroma;
        this.name = "Coffee";
        switch (aroma) {
            case "saturated":
                this.calories = 40;
                ++saturatedCoffeeAmount;
                break;
            case "bitter":
                this.calories = 50;
                ++bitterCoffeeAmount;
                break;
            case "oriental":
                this.calories = 60;
                ++orientalCoffeeAmount;
                break;
            default:
                throw new InvalidColorException("Invalid Coffee aroma");
        }

    }

    public int Amount() {
        int var10000;
        switch (this.Aroma) {
            case "saturated":
                var10000 = saturatedCoffeeAmount;
                break;
            case "bitter":
                var10000 = bitterCoffeeAmount;
                break;
            case "oriental":
                var10000 = orientalCoffeeAmount;
                break;
            default:
                var10000 = 0;
        }

        return var10000;
    }

    public String toString() {
        return "Coffee{ aroma='" + this.Aroma + "', calories=" + this.calories + "}";
    }

    public void consume() {
        System.out.println(this.Aroma + " " + this.name + " calories - " + this.calories + " has been eaten.");
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.Aroma});
    }

    public int calculateCalories() {
        return this.calories;
    }
}
