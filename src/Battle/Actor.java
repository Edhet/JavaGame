package Battle;

public interface Actor {
    boolean attack(Ability ability, Person foe) throws IllegalStateException;
    boolean useItem(Item item) throws IllegalStateException;

}
