package Battle;

public enum Abilities {
    ATTACK("Ataque Básico", "Apenas um ataque básico, o que você esperava?", 1, 0);
    ATTACK("Graça dos Doom", "Aria é capaz de controlar orbes energizadas. Como seu poder está diretamente ligado ao estado de sua mente, há um desgaste mental, ocasionando em perda de sanidade.", 2, 1); 
    ATTACK("EGO", "Damien é capaz de controlar EGO, um sentimento selado capaz de aniquilar seus inimigos e, à medida em que utiliza de seu poder, perde sanidade.", 2, 1); 
    
    public final String NAME, DESCRIPTION;
    public final Integer DAMAGE, COST;

    Abilities(String name, String description, Integer damage, Integer cost) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.DAMAGE = damage;
        this.COST = cost;
    }
}
