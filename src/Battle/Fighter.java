package Battle;

import Extra.Utils;

import java.util.List;
public interface Fighter {
    void addAbility(Abilities ability) throws IllegalStateException;

    void useAbility(Abilities ability, Person target) throws IllegalStateException;

    default boolean hasAbility(Abilities ability, List<Abilities> abilitiesList) {
        return Utils.getFromList(ability, abilitiesList).isPresent();
    }
}
