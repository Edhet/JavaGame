package Battle;

public interface Player {
    void equipItem(EquipableItems item) throws IllegalStateException;

    void addItem(ConsumableItems item) throws IllegalStateException;

    void useItem(ConsumableItems item) throws IllegalStateException;

    boolean hasItem(EquipableItems item);

    boolean hasItem(ConsumableItems item);
}
