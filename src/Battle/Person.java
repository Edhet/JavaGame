package Battle;

import Extra.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Fighter {
    protected final int MIN_ATTRIBUTE_VAL = 0, MAX_ATTRIBUTE_VAL = 10;
    protected String name;
    protected Integer sanity;
    protected Integer strengh, resistence, agility;
    protected List<Abilities> abilities;

    public Person(String name, int sanity, int strengh, int resistence, int agility, List<Abilities> abilities) throws IllegalArgumentException {
        setName(name);
        setSanity(sanity);
        setStrengh(strengh);
        setResistence(resistence);
        setAgility(agility);
        this.abilities = (abilities == null) ? new ArrayList<>() : abilities;
    }

    // TODO: aprimorar a forma como os atributos interagem com o ataque
    @Override
    public void useAbility(Abilities ability, Person target) throws IllegalStateException {
        if (!hasAbility(ability))
            throw new IllegalStateException("Person doesn't have the "+ability.name()+" ability");

        int damage = (ability.DAMAGE + this.strengh) - target.getResistence();
        target.changeSanity(-damage);
        this.sanity -= ability.COST;
    }

    @Override
    public void addAbility(Abilities ability) throws IllegalStateException {
        if (hasAbility(ability))
            throw new IllegalStateException("Person already has "+ability.name()+" ability");
        this.abilities.add(ability);
    }

    @Override
    public boolean hasAbility(Abilities ability) {
        return Utils.isOnList(ability, this.abilities);
    }

    @Override
    public List<Abilities> getAbilities() {
        return abilities;
    }

    public Integer getSanity() {
        return sanity;
    }

    public Person setSanity(int sanity) throws IllegalArgumentException  {
        if (sanity < 0)
            throw new IllegalArgumentException("Sanity is bellow zero");
        this.sanity = sanity;
        return this;
    }

    public void changeSanity(int amount) throws IllegalStateException {
        this.sanity += amount;
        if (this.sanity < 0)
            throw new IllegalStateException("Sanity is bellow zero");
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) throws IllegalArgumentException {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name is empty");
        this.name = name;
        return this;
    }

    public Integer getStrengh() {
        return strengh;
    }

    public Person setStrengh(int strengh) {
        this.strengh = Utils.clamp(strengh,  MIN_ATTRIBUTE_VAL, MAX_ATTRIBUTE_VAL);
        return this;
    }

    public Integer getResistence() {
        return resistence;
    }

    public Person setResistence(int resistence) {
        this.resistence = Utils.clamp(resistence, MIN_ATTRIBUTE_VAL, MAX_ATTRIBUTE_VAL);
        return this;
    }

    public Integer getAgility() {
        return agility;
    }

    public Person setAgility(int agility) {
        this.agility = Utils.clamp(agility, MIN_ATTRIBUTE_VAL, MAX_ATTRIBUTE_VAL);
        return this;
    }
}
