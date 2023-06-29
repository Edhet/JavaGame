package Battle;

import java.util.List;
public interface Fighter {
    void addAbility(Abilities ability) throws IllegalStateException;

    void useAbility(Abilities ability, Person target) throws IllegalStateException;

    default boolean hasAbility(Abilities ability, List<Abilities> abilitiesList) {
        for (Abilities listedAbility : abilitiesList)
            if (listedAbility.equals(ability))
                return true;
        return false;
    }
}
