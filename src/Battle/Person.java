package Battle;

import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Fighter {
    protected String name;
    protected Integer sanity;
    protected Integer strengh, resistence, agility;
    protected List<Abilities> abilities;

    public Person(String name, Integer sanity, Integer strengh, Integer resistence, Integer agility) throws IllegalArgumentException {
        setName(name);
        setSanity(sanity);
        setStrengh(strengh);
        setResistence(resistence);
        setAgility(agility);
        abilities = new ArrayList<>();
    }

    // TODO: aprimorar a forma como os atributos interagem com o ataque
    @Override
    public void useAbility(Abilities ability, Person target) throws IllegalStateException {
        if (!hasAbility(ability, this.abilities))
            throw new IllegalStateException("Person doesn't have the "+ability.name()+" ability");

        int damage = (ability.DAMAGE + this.strengh) - target.getResistence();
        target.reduceSanity(damage);
        this.sanity -= ability.COST;
    }

    @Override
    public void addAbility(Abilities ability) throws IllegalStateException {
        if (hasAbility(ability, this.abilities))
            throw new IllegalStateException("Person already has "+ability.name()+" ability");
        this.abilities.add(ability);
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public Integer getSanity() {
        return sanity;
    }

    public Person setSanity(Integer sanity) throws IllegalArgumentException  {
        if (sanity < 0)
            throw new IllegalArgumentException("Sanity is bellow zero");
        this.sanity = sanity;
        return this;
    }

    public void reduceSanity(int amount) throws IllegalStateException {
        if (this.sanity <= 0)
            throw new IllegalStateException("Sanity is bellow/equal to zero");
        this.sanity -= amount;
    }

    public void increaseSanity(int amount) {
        this.sanity += amount;
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

    public Person setStrengh(Integer strengh) throws IllegalArgumentException  {
        if (strengh < 0)
            throw new IllegalArgumentException("Strengh is bellow zero");
        this.strengh = strengh;
        return this;
    }

    public Integer getResistence() {
        return resistence;
    }

    public Person setResistence(Integer resistence) throws IllegalArgumentException  {
        if (resistence < 0)
            throw new IllegalArgumentException("Resistence is bellow zero");
        this.resistence = resistence;
        return this;
    }

    public Integer getAgility() {
        return agility;
    }

    public Person setAgility(Integer agility) throws IllegalArgumentException {
        if (agility < 0)
            throw new IllegalArgumentException("Agility is bellow zero");
        this.agility = agility;
        return this;
    }
}
