package Model;

import Model.Constants.Abilities;

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

    public void calculateStance(Person player) {
        final int BIG_IMPACT = 4, MEDIUM_IMPACT = 2, SMALL_IMPACT = 1;

        int boldnessValue = 0;

        boldnessValue += (this.sanity > 5) ? MEDIUM_IMPACT : -BIG_IMPACT;
        boldnessValue += (player.sanity < 5) ? SMALL_IMPACT : -BIG_IMPACT;
        boldnessValue += (this.attributes.getAgility() > player.attributes.getAgility()) ? BIG_IMPACT : -SMALL_IMPACT;
        boldnessValue += (this.attributes.getResistence() > player.attributes.getResistence()) ? SMALL_IMPACT : -MEDIUM_IMPACT;
        boldnessValue += (this.attributes.getStrengh() > player.attributes.getStrengh()) ? BIG_IMPACT : -SMALL_IMPACT;

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
