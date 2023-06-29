package Battle;

import Extra.Utils;

import java.util.List;

public interface Player {
    void equipItem(EquipableItems item) throws IllegalStateException;

    default boolean hasItem(EquipableItems item, List<EquipableItems> equipableItemsList) {
        return Utils.getFromList(item, equipableItemsList).isPresent();
    }

    void addItem(ConsumableItems item, Integer amount);

    void useItem(ConsumableItems item) throws IllegalStateException;

    default boolean hasItem(ConsumableItems item, List<ConsumableItems> consumableItemsList) {
        return Utils.getFromList(item, consumableItemsList).isPresent();
    }
}
