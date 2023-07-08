package Battle;

import Battle.Constants.Characters;

import java.util.ArrayList;
import java.util.Arrays;

public final class PersonFactory {
    private PersonFactory() {
    }

    public static <T extends Person> T createPerson(Characters character) {
        if (character.IS_PLAYABLE)
            return (T) createHeroCharacter(character);
        else
            return (T) createEnemyCharacter(character);
    }

    private static Hero createHeroCharacter(Characters character) {
        return new Hero(
                character.NAME,
                character.STORY,
                character.SANITY,
                new Attributes(character.STRENTGH, character.RESISTENCE, character.AGILITY),
                new ArrayList<>(Arrays.stream(character.ABILITIES).toList()),
                new ArrayList<>(),
                new ArrayList<>()
        );
    }

    private static Enemy createEnemyCharacter(Characters character) {
        return new Enemy(
                character.NAME,
                character.STORY,
                character.SANITY,
                new Attributes(character.STRENTGH, character.RESISTENCE, character.AGILITY),
                new ArrayList<>(Arrays.stream(character.ABILITIES).toList())
        );
    }
}
