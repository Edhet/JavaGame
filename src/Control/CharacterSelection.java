package Control;

import Model.Constants.Characters;
import Model.Hero;
import Model.PersonFactory;

import java.util.*;

public final class CharacterSelection {
    private static final Map<String, Characters> SELECTABLE_PLAYABLE_CHARACTERS = new HashMap<>(Map.of(
            "ARIA", Characters.ARIA,
            "DAMIEN", Characters.DAMIEN
    ));

    private CharacterSelection() {
    }

    public static Hero selectCharacter() {
        printOptions();
        Characters selected = SELECTABLE_PLAYABLE_CHARACTERS.get(
                InputController.getValidInput(SELECTABLE_PLAYABLE_CHARACTERS.keySet().stream().toList(), null)
        );
        return PersonFactory.createPerson(selected);
    }

    private static void printOptions() {
        System.out.println("Digite o primeiro nome do personagem para escolhê-lo");
        for (Characters character : SELECTABLE_PLAYABLE_CHARACTERS.values()) {
            System.out.printf("""
                    Nome: %s
                    História: %s
                    Força: %d   	Resistência: %d     	Agilidade: %d
                    Abilidades: %s
                    """, character.NAME, character.STORY, character.STRENTGH, character.RESISTENCE, character.AGILITY,
                    Arrays.stream(character.ABILITIES).map(abilities -> abilities.NAME).toList()
            );
            System.out.println();
        }
    }
}
