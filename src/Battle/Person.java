package Battle;

import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Actor {
    protected String name;
    protected Integer sanity;
    protected Integer strengh, resistence, agility;

    protected List<Ability> abilities;
    protected List<Item> consumableItems;
    protected List<Item> equipableItems;

    public Person(String name, Integer sanity, Integer strengh, Integer resistence, Integer agility) throws IllegalArgumentException {
        setName(name);
        setSanity(sanity);
        setStrengh(strengh);
        setResistence(resistence);
        setAgility(agility);
        abilities = new ArrayList<>();
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) throws IllegalArgumentException {
        if (abilities == null)
            throw new IllegalArgumentException("Abilities list is null");
        this.abilities = abilities;
    }

//    public void setItems(List<Item> items) {
//        if (items == null)
//            throw new IllegalArgumentException("Items list is null");
//        this.items = items;
//    }

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
