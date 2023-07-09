import Control.SingletonGameController;

public class Main {
    public static void main(String[] args) {
        SingletonGameController gameController = SingletonGameController.getInstance();
        gameController.startGame();
    }
}