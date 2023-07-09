package Control;

import Battle.Constants.ConsumableItems;
import Battle.Constants.EquipableItems;
import Battle.Hero;

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
        printItemsOptions(SELECTABLE_EQUIPABLE_ITEMS);
        return SELECTABLE_EQUIPABLE_ITEMS.get(
                InputController.selectValidIndex(SELECTABLE_EQUIPABLE_ITEMS, null)
        );
    }

    public static ConsumableItems selectConsumableItem() {
        printItemsOptions(SELECTABLE_CONSUMABLE_ITEMS);
        return SELECTABLE_CONSUMABLE_ITEMS.get(
                InputController.selectValidIndex(SELECTABLE_CONSUMABLE_ITEMS, null)
        );
    }

    private static void printItemsOptions(List<?> itemList) {
        System.out.println("Selecione um item para sua próxima batalha...");
        int index = 0;
        for (Object item : itemList) {
            System.out.printf("%d\t%s\n", index, item);
            index++;
        }
    }

}
