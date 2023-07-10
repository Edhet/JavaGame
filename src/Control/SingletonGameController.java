package Control;

import Control.Selections.ActionSelection;
import Control.Selections.CharacterSelection;
import Control.Selections.ItemSelection;
import Control.Selections.PossibleAction;
import Model.Attack;
import Model.Constants.Abilities;
import Model.Constants.Characters;
import Model.Constants.ConsumableItems;
import Model.Enemy;
import Model.Hero;
import Model.PersonFactory;

public final class SingletonGameController {
    private static SingletonGameController instance;

    private final Characters[] BATTLE_SEQUENCE = {Characters.THORFFY, Characters.ZIGG, Characters.LORDGRAF};
    private Hero player;
    private Enemy enemy;

    public static SingletonGameController getInstance() {
        if (instance == null)
            instance = new SingletonGameController();
        return instance;
    }

    private SingletonGameController() {
        player = CharacterSelection.selectCharacter();
        player.addItem(ConsumableItems.EMPTYBOX);
    }

    public void startGame() {
        for (Characters enemy : BATTLE_SEQUENCE) {
            showStore();
            boolean wonBattle = startBattle(enemy);

            if (!wonBattle) {
                System.out.println("Sua sanidade extinguiu-se à própria natureza inóspita. Os inimigos percebem tal fraqueza e utilizam dela para te controlar. Você não\n" +
                        "foi capaz de mudar a dura e triste realidade.");
                break;
            }
            System.out.println("Vitória!");
        }
    }

    private void showStore() {
        System.out.println("Selecione um item para sua próxima batalha...");
        player.equipItem(ItemSelection.selectEquipableItem(player));
        player.addItem(ItemSelection.selectConsumableItem());
    }

    private boolean startBattle(Characters enemy) {
        this.enemy = PersonFactory.createPerson(enemy);
        System.out.println(enemy.STORY);
        while (this.enemy.isAlive() && player.isAlive()) {
            printBattleStatus();
            if (playerTurn(player, this.enemy) != PossibleAction.INFO)
                enemyTurn();
        }
        return player.isAlive();
    }

    private void printBattleStatus() {
        System.out.printf("""
                        %s \tSanidade: %d
                        %s \tSanidade: %d
                        """,
                player.getName(), player.getSanity(),
                enemy.getName(), enemy.getSanity()
        );
    }

    private PossibleAction playerTurn(Hero player, Enemy enemy) {
        PossibleAction action = ActionSelection.chooseAction();
        switch (action) {
            case HABI -> printAttackResult(player.useAbility(ActionSelection.chooseAbility(player), enemy));
            case ITEM -> {
                try {
                    player.useItem(ActionSelection.chooseItem(player));
                } catch (IllegalStateException e) {
                    System.out.println("Você não possui nenhuma quantidade desse item");
                    action = playerTurn(player, enemy);
                }
            }
            case INFO -> ActionSelection.printPersonInformation(player, enemy);
        }
        return action;
    }

    private void enemyTurn() {
        this.enemy.calculateStance(player);
        Abilities chosenAbility = enemy.chooseAbility();
        System.out.println(enemy.getName() + " usou " + chosenAbility);
        printAttackResult(this.enemy.useAbility(chosenAbility, player));
    }

    private void printAttackResult(Attack result) {
        System.out.println((result == Attack.HIT) ? "Acertou ataque" : "Errou ataque");
    }
}
