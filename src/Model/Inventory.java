package Model;

import Model.Constants.ConsumableItems;
import Model.Constants.EquipableItems;

import java.util.List;

public interface Inventory {
    void equipItem(EquipableItems item) throws IllegalStateException;

    boolean hasItem(EquipableItems item);

    List<EquipableItems> getEquipableItems();

    void addItem(ConsumableItems item);

    void useItem(ConsumableItems item) throws IllegalStateException;

    boolean hasItem(ConsumableItems item);

    List<ConsumableItems> getConsumableItems();
}
