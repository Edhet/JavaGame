package Control;

import Battle.Constants.ConsumableItems;
import Battle.Constants.EquipableItems;
import Battle.Hero;

import java.util.Arrays;
import java.util.List;

public final class ItemSelection {
    private static final List<ConsumableItems> SELECTABLE_CONSUMABLE_ITEMS = Arrays.stream(ConsumableItems.values()).toList();

    private static final List<EquipableItems> SELECTABLE_EQUIPABLE_ITEMS = Arrays.stream(EquipableItems.values()).toList();

    private ItemSelection() {
    }

    public static EquipableItems selectEquipableItem(Hero player) {
        printEquipableItemsOptions();
        return SELECTABLE_EQUIPABLE_ITEMS.get(
                InputController.selectValidIndex(SELECTABLE_EQUIPABLE_ITEMS, null)
        );
    }

    private static void printEquipableItemsOptions() {
        int index = 0;
        for (EquipableItems item : SELECTABLE_EQUIPABLE_ITEMS) {
            System.out.printf("%d\t%s\n", index, item.NAME);
            index++;
        }
    }

}
