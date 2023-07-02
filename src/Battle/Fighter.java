package Battle;

import Battle.Constants.Abilities;

import java.util.List;

public interface Fighter {
    void addAbility(Abilities ability) throws IllegalStateException;

    void useAbility(Abilities ability, Person target) throws IllegalStateException;

    boolean hasAbility(Abilities ability);

    List<Abilities> getAbilities();
}
