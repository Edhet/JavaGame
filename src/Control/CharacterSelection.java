package Control;

import Battle.Constants.Characters;
import Battle.Hero;
import Battle.PersonFactory;

import java.util.*;

public final class CharacterSelection {
    public static final Map<String, Characters> SELECTABLE_PLAYABLE_CHARACTERS = new HashMap<>(Map.of(
            "ARIA", Characters.ARIA,
            "DAMIEN", Characters.DAMIEN
    ));

    private CharacterSelection() {
    }

    public static Hero selectCharacter() {
        printOption();
        Characters selected = SELECTABLE_PLAYABLE_CHARACTERS.get(
                InputController.getValidInput(SELECTABLE_PLAYABLE_CHARACTERS.keySet().stream().toList(), null)
        );
        return PersonFactory.createPerson(selected);
    }

    private static void printOption() {
        for (Characters character : SELECTABLE_PLAYABLE_CHARACTERS.values()) {
            System.out.printf("""
                    Nome: %s
                    História: %s
                    Força: %d   	Resistência: %d     	Agilidade: %d
                    Abilidades:
                    """, character.NAME, character.STORY, character.STRENTGH, character.RESISTENCE, character.AGILITY
            );
            System.out.println(Arrays.stream(character.ABILITIES).map(abilities -> abilities.NAME).toList());
            System.out.println();
        }
    }
}
