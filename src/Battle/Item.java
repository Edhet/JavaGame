package Battle;

public abstract class Item {
    protected final String name, description;
    protected final Integer effect;

    public Item(String name, String description, Integer effect) {
        this.name = name;
        this.description = description;
        this.effect = effect;
    }
}
