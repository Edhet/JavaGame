package Battle;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {
    protected String name;
    protected Integer sanity;
    protected Integer strengh, resistence, agility;

    protected List<Action> actions;

    public Entity(String name, Integer sanity, Integer strengh, Integer resistence, Integer agility) throws IllegalArgumentException {
        setName(name);
        setSanity(sanity);
        setStrengh(strengh);
        setResistence(resistence);
        setAgility(agility);
        actions = new ArrayList<>();
    }

    public Integer getSanity() {
        return sanity;
    }

    public Entity setSanity(Integer sanity) throws IllegalArgumentException  {
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

    public Entity setName(String name) throws IllegalArgumentException {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name is empty");
        this.name = name;
        return this;
    }

    public Integer getStrengh() {
        return strengh;
    }

    public Entity setStrengh(Integer strengh) throws IllegalArgumentException  {
        if (strengh < 0)
            throw new IllegalArgumentException("Strengh is bellow zero");
        this.strengh = strengh;
        return this;
    }

    public Integer getResistence() {
        return resistence;
    }

    public Entity setResistence(Integer resistence) throws IllegalArgumentException  {
        if (resistence < 0)
            throw new IllegalArgumentException("Resistence is bellow zero");
        this.resistence = resistence;
        return this;
    }

    public Integer getAgility() {
        return agility;
    }

    public Entity setAgility(Integer agility) throws IllegalArgumentException {
        if (agility < 0)
            throw new IllegalArgumentException("Agility is bellow zero");
        this.agility = agility;
        return this;
    }
}
