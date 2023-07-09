package Control;

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
            startBattle(enemy);
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
            case HABI -> player.useAbility(ActionSelection.chooseAbility(player), enemy);
            case ITEM -> player.useItem(ActionSelection.chooseItem(player));
            case INFO -> ActionSelection.printPersonInformation(player, enemy);
        }
        return action;
    }

    private void enemyTurn() {
        this.enemy.calculateStance(player);
        Abilities chosenAbility = enemy.chooseAbility();
        System.out.println(enemy.getName() + " usou " + chosenAbility);
        this.enemy.useAbility(chosenAbility, player);
    }
}
