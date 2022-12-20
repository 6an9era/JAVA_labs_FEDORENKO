package firstlabFed;
import java.util.Objects;

public class Beef extends Food {
    private String preparedness = "";
    private static int RareBeefAmount = 0;
    private static int MediumBeefAmount = 0;
    private static int WellDoneBeefAmount = 0;
    static final String Rare = "Rare";
    static final String Medium = "Medium";
    static final String WellDone = "WellDone";

    public Beef(String preparedness) throws InvalidPreparednessException {
        this.preparedness = preparedness;
        this.name = "Beef";
        switch (preparedness) {
            case "Rare":
                this.calories = 100;
                ++RareBeefAmount;
                break;
            case "Medium":
                this.calories = 200;
                ++MediumBeefAmount;
                break;
            case "WellDone":
                this.calories = 300;
                ++WellDoneBeefAmount;
                break;
            default:
                throw new InvalidPreparednessException("Invalid cake preparedness");
        }

    }

    public int Amount() {
        int var10000;
        switch (this.preparedness) {
            case "Rare":
                var10000 = RareBeefAmount;
                break;
            case "Medium":
                var10000 = MediumBeefAmount;
                break;
            case "WellDone":
                var10000 = WellDoneBeefAmount;
                break;
            default:
                var10000 = 0;
        }

        return var10000;
    }

    public String toString() {
        return "Cake{preparedness='" + this.preparedness + "', calories=" + this.calories + "}";
    }

    public void consume() {
        System.out.println(this.preparedness + " " + this.name + " calories - " + this.calories + " has been eaten.");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Beef beef = (Beef)o;
            return Objects.equals(this.preparedness, beef.preparedness);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.preparedness});
    }

    public int calculateCalories() {
        return this.calories;
    }
}

