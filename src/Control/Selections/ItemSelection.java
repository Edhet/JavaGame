package Control.Selections;

import Control.InputController;
import Model.Constants.ConsumableItems;
import Model.Constants.EquipableItems;
import Model.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ItemSelection {
    private static final List<ConsumableItems> SELECTABLE_CONSUMABLE_ITEMS = new ArrayList<>(Arrays.stream(ConsumableItems.values())
            .filter(item -> !item.equals(ConsumableItems.EMPTYBOX))
            .toList()
    );

    private static final List<EquipableItems> SELECTABLE_EQUIPABLE_ITEMS = new ArrayList<>(Arrays.stream(EquipableItems.values()).toList());

    private ItemSelection() {
    }

    public static EquipableItems selectEquipableItem(Hero player) {
        SELECTABLE_EQUIPABLE_ITEMS.removeIf(player::hasItem);
        printEquipableItemsOptions();
        return SELECTABLE_EQUIPABLE_ITEMS.get(
                InputController.selectValidIndex(SELECTABLE_EQUIPABLE_ITEMS, null)
        );
    }

    private static void printEquipableItemsOptions() {
        int index = 0;
        for (EquipableItems item : ItemSelection.SELECTABLE_EQUIPABLE_ITEMS) {
            System.out.printf("%d\t%s (%s) Efeitos do Item: [%s]\n", index, item, item.DESCRIPTION, item.MODIFIERS);
            index++;
        }
    }

    public static ConsumableItems selectConsumableItem() {
        printConsumableItemsOptions();
        return SELECTABLE_CONSUMABLE_ITEMS.get(
                InputController.selectValidIndex(SELECTABLE_CONSUMABLE_ITEMS, null)
        );
    }

    private static void printConsumableItemsOptions() {
        int index = 0;
        for (ConsumableItems item : ItemSelection.SELECTABLE_CONSUMABLE_ITEMS) {
            System.out.printf("%d\t%s (%s) Ganho de Sanidade: %d\n", index, item, item.DESCRIPTION, item.EFFECT);
            index++;
        }
    }
}
