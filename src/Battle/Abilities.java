package Battle;

public enum Abilities {
    ATTACK("Ataque", "", 2, 0);

    public final String NAME, DESCRIPTION;
    public final Integer DAMAGE, COST;

    Abilities(String name, String description, Integer damage, Integer cost) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.DAMAGE = damage;
        this.COST = cost;
    }
}
