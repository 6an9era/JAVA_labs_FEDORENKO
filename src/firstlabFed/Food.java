package firstlabFed;

public abstract class Food implements Nutritious, Consumable {
    protected int calories = 0;
    protected String name = "";

    public Food() {
    }
}
