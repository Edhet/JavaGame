package Control;

import Battle.Enemy;
import Battle.Hero;

public final class SingletonGameController {
    private static SingletonGameController instance;

    private Hero player;
    private Enemy enemy;

    public static SingletonGameController getInstance() {
        if (instance == null)
            instance = new SingletonGameController();
        return instance;
    }

    private SingletonGameController() {
        player = CharacterSelection.selectCharacter();
    }
}
