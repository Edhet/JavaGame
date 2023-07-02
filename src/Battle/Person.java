package Battle;

import Battle.Constants.Abilities;
import Extra.Utils;

import java.util.List;

public abstract class Person implements Fighter {
    protected String name, story;
    protected Integer sanity;
    protected Attributes attributes;
    protected List<Abilities> abilities;

    public Person(String name, String story, int sanity, Attributes attributes, List<Abilities> abilities) throws IllegalArgumentException {
        setName(name);
        setStory(story);
        setSanity(sanity);
        this.attributes = attributes;
        this.abilities = abilities;
    }

    // TODO: aprimorar a forma como os atributos interagem com o ataque
    @Override
    public void useAbility(Abilities ability, Person target) throws IllegalStateException {
        if (!hasAbility(ability))
            throw new IllegalStateException("Person doesn't have the " + ability.name() + " ability");

        int damage = Utils.lowerBound(ability.DAMAGE + this.attributes.getStrengh() - target.attributes.getResistence(), 0);
        target.changeSanity(-damage);
        this.sanity -= ability.COST;
    }

    @Override
    public void addAbility(Abilities ability) throws IllegalStateException {
        if (hasAbility(ability))
            throw new IllegalStateException("Person already has " + ability.name() + " ability");
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

    public boolean isAlive() {
        return sanity != 0;
    }

    public Integer getSanity() {
        return sanity;
    }

    public void setSanity(int sanity) {
        this.sanity = Utils.lowerBound(sanity,  0);
    }

    public void changeSanity(int amount) {
        setSanity(this.sanity += amount);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name.isEmpty())
            throw new IllegalArgumentException("Name is empty");
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) throws IllegalArgumentException {
        if (story.isEmpty())
            throw new IllegalArgumentException("Story is empty");
        this.story = story;
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
