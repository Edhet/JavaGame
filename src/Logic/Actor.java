package Logic;

public interface Actor {
    boolean attack(Entity foe) throws IllegalStateException;
    boolean useItem(Item item) throws IllegalStateException;

}
