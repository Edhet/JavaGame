package Control.Selections;

import Control.InputController;
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
        printAbilities(player.getAbilities());
        return player.getAbilities().get(InputController.selectValidIndex(player.getAbilities(), null));
    }


    private static void printAbilities(List<Abilities> list) {
        int index = 0;
        for (Abilities ability : list) {
            System.out.printf("%d\t%s (%s) Dano: %d Custo: %d\n", index, ability, ability.DESCRIPTION, ability.DAMAGE, ability.COST);
            index++;
        }
    }

    public static ConsumableItems chooseItem(Hero player) {
        printItems(player.getConsumableItems());
        return player.getConsumableItems().get(InputController.selectValidIndex(player.getConsumableItems(), null));
    }

    private static void printItems(List<ConsumableItems> list) {
        int index = 0;
        for (ConsumableItems item : list) {
            System.out.printf("%d\t%s (%s) Mudança de Sanidade: %s [%d]\n", index, item, item.DESCRIPTION, (item.EFFECT == null) ? "Aleatório" : item.EFFECT, item.getAmount());
            index++;
        }
    }

    public static void printPersonInformation(Hero player, Enemy enemy) {
        System.out.printf("""
                Inimigo: %s \tSanidade: %d
                %s
                
                """, enemy.getName(), enemy.getSanity(), enemy.getAttributes()
        );
        System.out.printf("""
                %s \tSanidade: %d
                %s
                Habilidades: %s
                Equipamentos: %s
                Items: %s
                
                """, player.getName(), player.getSanity(), player.getAttributes(),
                player.getAbilities().stream().map(ability -> ability.NAME).toList(),
                player.getEquipableItems().stream().map(item -> item.NAME).toList(),
                player.getConsumableItems().stream().map(items -> items.NAME).toList()
        );
    }
}
