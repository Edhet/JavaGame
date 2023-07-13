package Model.Constants;

public enum Abilities {
    ATTACK("Ataque Básico", "Apenas um ataque básico.", 1, 0),
    PUNCH("Soco Reforçado", "Uma mistura de técnica e destreza.", 2, 1),
    GRACE("Graça dos Doom", "Capacidade de controlar orbes energizadas. Há um desgaste mental nas manipulações, ocasionando perda de sanidade.", 4, 2),
    EGO("Ego", "Um sentimento selado capaz de aniquilar seus inimigos e, à medida em que o poder é utilizado, perde-se sanidade.", 4, 2),

    MALICIOUSATTACK("Ataque Malicioso", "Um ataque causado apenas por seres cruéis.", 2, 0),
    BADHEALING("Cicatrização Cruel", "Um miasma escuro capaz de curar monstros terríveis", 0, -3),

    SHOUT("Grito", "Thorffy utiliza de seus gritos para aterrorizar seus inimigos.", 3, 2),
    FEAR("Medo", "Zigg encontra os medos mais profundos de suas vítimas para fazê-las se renderem.", 4, 3),
    MANIPULATION("Manipulação", "Lorde Graf utiliza de manipulações para acabar com seus oponentes.", 6, 4);

    public final String NAME, DESCRIPTION;
    public final Integer DAMAGE, COST;

    Abilities(String name, String description, Integer damage, Integer cost) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.DAMAGE = damage;
        this.COST = cost;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
