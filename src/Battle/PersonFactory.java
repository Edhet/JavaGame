package Battle;

import java.util.ArrayList;
import java.util.Arrays;

public final class PersonFactory {
    private PersonFactory() {
    }

    public static Person createPerson(Characters character) {
        if (character.IS_PLAYABLE)
            return createPlayableCharacter(character);
        else
            return null; //TODO: Factory para inimigos
    }

    private static Playable createPlayableCharacter(Characters character) {
        return new Playable(
                character.NAME,
                character.STORY,
                character.SANITY,
                new Attributes(character.STRENTGH, character.RESISTENCE, character.AGILITY),
                new ArrayList<>(Arrays.stream(character.ABILITIES).toList()),
                new ArrayList<>(Arrays.stream(character.CONSUMABLE_ITEMS).toList()),
                new ArrayList<>(Arrays.stream(character.EQUIPABLE_ITEMS).toList())
        );
    }
}
