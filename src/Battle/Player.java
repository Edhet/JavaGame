package Battle;

import Extra.Utils;

import java.util.List;

public interface Player {
    void equipItem(EquipableItems item) throws IllegalStateException;

    boolean hasItem(EquipableItems item);

    List<EquipableItems> getEquipableItems();

    void addItem(ConsumableItems item, Integer amount);

    void useItem(ConsumableItems item) throws IllegalStateException;

    boolean hasItem(ConsumableItems item);

    List<ConsumableItems> getConsumableItems();
}
