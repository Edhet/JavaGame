package Battle;

import Extra.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Person implements Fighter {
    protected String name, story;
    protected Integer sanity;
    protected Attributes attributes;
    protected List<Abilities> abilities;

    public Person(String name, String story, int sanity, int strengh, int resistence, int agility, List<Abilities> abilities) throws IllegalArgumentException {
        setName(name);
        setStory(story);
        setSanity(sanity);
        this.attributes = new Attributes(strengh, resistence, agility);
        this.abilities = (abilities == null) ? new ArrayList<>() : abilities;
    }

    // TODO: aprimorar a forma como os atributos interagem com o ataque
    @Override
    public void useAbility(Abilities ability, Person target) throws IllegalStateException {
        if (!hasAbility(ability))
            throw new IllegalStateException("Person doesn't have the "+ability.name()+" ability");

        int damage = (ability.DAMAGE + this.attributes.getStrengh()) - target.attributes.getResistence();
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

    public String getStory() {
        return story;
    }

    public Person setStory(String story) throws IllegalArgumentException {
        if (story.isEmpty())
            throw new IllegalArgumentException("Story is empty");
        this.story = story;
        return this;
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
