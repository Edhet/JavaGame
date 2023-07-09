package Control;

import Extra.Utils;
import Model.Constants.Abilities;
import Model.Constants.ConsumableItems;
import Model.Enemy;
import Model.Hero;

import java.util.Arrays;
import java.util.List;

public final class ActionSelection {
    private ActionSelection() {
    }

    public static PossibleAction chooseAction() {
        List<String> options = Arrays.stream(PossibleAction.values()).map(Enum::name).toList();
        System.out.println(options);
        return PossibleAction.valueOf(InputController.getValidInput(options, null));
    }

    public static Abilities chooseAbility(Hero player) {
        Utils.printListWithIndex(player.getAbilities());
        return player.getAbilities().get(InputController.selectValidIndex(player.getAbilities(), null));
    }


    public static ConsumableItems chooseItem(Hero player) {
        Utils.printListWithIndex(player.getConsumableItems());
        return player.getConsumableItems().get(InputController.selectValidIndex(player.getConsumableItems(), null));
    }

    public static void printPersonInformation(Hero player, Enemy enemy) {
        System.out.printf("""
                Inimigo: %s \tSanidade: %d
                %s
                
                """, enemy.getName(), enemy.getSanity(), enemy.getAttributes()
        );
        System.out.println();
        System.out.printf("""
                %s \tSanidade: %d
                %s
                Abilidades: %s
                Equipamentos: %s
                Items: %s
                """, player.getName(), player.getSanity(), player.getAttributes(),
                player.getAbilities().stream().map(ability -> ability.NAME).toList(),
                player.getEquipableItems().stream().map(item -> item.NAME).toList(),
                player.getConsumableItems().stream().map(items -> items.NAME).toList()
        );
        System.out.println();
    }
}
