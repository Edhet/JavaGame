package Control;

import Model.Constants.ConsumableItems;
import Model.Enemy;
import Model.Hero;

public final class SingletonGameController {
    private static SingletonGameController instance;

    private Hero player;
    private Enemy enemy;

    public static SingletonGameController getInstance() {
        if (instance == null)
            instance = new SingletonGameController();
        return instance;
    }

    // TODO: fazer uma classe para controlar a loja, controlar a luta e controlar/qual inimigo e controlar as historias
    private SingletonGameController() {
        player = CharacterSelection.selectCharacter();
        player.addItem(ConsumableItems.EMPTYBOX);


    }
}
