package Battle;

import Battle.Constants.Abilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Person {

    enum Stance {BOLD, CAUTELOUS}

    private List<Abilities> costlessAttacks, costfullAttacks;
    private Stance actionStance;

    Enemy(String name, String story, int sanity, Attributes attributes, List<Abilities> abilities) throws IllegalArgumentException {
        super(name, story, sanity, attributes, abilities);
        actionStance = Stance.CAUTELOUS;
        separateAbilityTypes();
    }

    private void separateAbilityTypes() {
        this.costlessAttacks = new ArrayList<>();
        this.costfullAttacks = new ArrayList<>();

        for (Abilities ability : this.abilities) {
            if (ability.COST <= 0)
                costlessAttacks.add(ability);
            else
                costfullAttacks.add(ability);
        }
    }

    public void calculateStance(Person enemy) {
        final int BIG_IMPACT = 4, MEDIUM_IMPACT = 2, SMALL_IMPACT = 1;

        int boldnessValue = 0;

        boldnessValue += (this.sanity > 5) ? MEDIUM_IMPACT : -BIG_IMPACT;
        boldnessValue += (this.attributes.getAgility() > 5) ? BIG_IMPACT : -SMALL_IMPACT;
        boldnessValue += (this.attributes.getResistence() > 3) ? SMALL_IMPACT : -MEDIUM_IMPACT;
        boldnessValue += (this.attributes.getStrengh() > 5) ? BIG_IMPACT : -SMALL_IMPACT;

        boldnessValue += (enemy.sanity < 5) ? MEDIUM_IMPACT : -BIG_IMPACT;
        boldnessValue += (enemy.attributes.getAgility() < 5) ? BIG_IMPACT : -SMALL_IMPACT;
        boldnessValue += (enemy.attributes.getResistence() < 3) ? SMALL_IMPACT : -MEDIUM_IMPACT;
        boldnessValue += (enemy.attributes.getStrengh() < 5) ? BIG_IMPACT : -SMALL_IMPACT;

        this.actionStance = (boldnessValue > 0) ? Stance.BOLD : Stance.CAUTELOUS;
    }

    public Abilities chooseAbility() {
        Abilities chosen = null;
        Random random = new Random();
        switch (actionStance) {
            case BOLD -> chosen = costfullAttacks.get(random.nextInt(0, costfullAttacks.size()));
            case CAUTELOUS -> chosen = costlessAttacks.get(random.nextInt(0, costlessAttacks.size()));
        }
        return chosen;
    }

}
