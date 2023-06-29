package Battle;

import java.util.List;

public interface Player {
    void equipItem(EquipableItems item) throws IllegalStateException;

    default boolean hasItem(EquipableItems item, List<EquipableItems> equipableItemsList) {
        for (EquipableItems listedItem : equipableItemsList)
            if (listedItem.equals(item))
                return true;
        return false;
    }

    void addItem(ConsumableItems item) throws IllegalStateException;

    void useItem(ConsumableItems item) throws IllegalStateException;

    default boolean hasItem(ConsumableItems item, List<ConsumableItems> consumableItemsList) {
        for (ConsumableItems listedItem : consumableItemsList)
            if (listedItem.equals(item))
                return true;
        return false;
    }
}
