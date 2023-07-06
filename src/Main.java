import Battle.Attack;
import Battle.Constants.Abilities;
import Battle.Constants.Characters;
import Battle.Enemy;
import Battle.PersonFactory;
import Battle.Playable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Playable player = (Playable) PersonFactory.createPerson(Characters.ARIA);
        Enemy enemy = (Enemy) PersonFactory.createPerson(Characters.LORDGRAF);

        System.out.println("imigo "+enemy.getSanity());
        System.out.println("eu "+player.getSanity());
        enemy.calculateStance(player);
        Abilities enemyAttack = enemy.chooseAbility();
        System.out.println("Imigo usou: "+enemyAttack.NAME);
        System.out.println((enemy.useAbility(enemyAttack, player).equals(Attack.HIT)) ? "Acertou" : "Errou");
        System.out.println("eu "+player.getSanity());
        System.out.println("imigo "+enemy.getSanity());
    }
}