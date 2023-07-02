package Battle;

public enum Abilities {
    ATTACK("Ataque Básico", "Apenas um ataque básico.", 1, 0),
    GRACE("Graça dos Doom", "Capacidade de controlar orbes energizadas. Esse poder está diretamente ligado ao estado de sua mente, há um desgaste mental, ocasionando perda de sanidade.", 2, 1),
    EGO("Ego", "Um sentimento selado capaz de aniquilar seus inimigos e, à medida em que o poder é utilizado, perde-se sanidade.", 2, 1);
    
    public final String NAME, DESCRIPTION;
    public final Integer DAMAGE, COST;

    Abilities(String name, String description, Integer damage, Integer cost) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.DAMAGE = damage;
        this.COST = cost;
    }
}
