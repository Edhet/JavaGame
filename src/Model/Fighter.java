package Model;

import Model.Constants.Abilities;

import java.util.List;

public interface Fighter {
    void addAbility(Abilities ability) throws IllegalStateException;

    Attack useAbility(Abilities ability, Person target) throws IllegalStateException;

    boolean hasAbility(Abilities ability);

    List<Abilities> getAbilities();
}
