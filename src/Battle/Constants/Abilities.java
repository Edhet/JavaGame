package Battle.Constants;

public enum Abilities {
    ATTACK("Ataque Básico", "Apenas um ataque básico.", 1, 0),
    PUNCH("Soco Reforçado", "Uma mistura de técnica e destreza.", 2, 0),
    GRACE("Graça dos Doom", "Capacidade de controlar orbes energizadas. Há um desgaste mental nas manipulações, ocasionando perda de sanidade.", 2, 1),
    EGO("Ego", "Um sentimento selado capaz de aniquilar seus inimigos e, à medida em que o poder é utilizado, perde-se sanidade.", 2, 1),

    MALICIOUSATTACK("Ataque Malicioso", "Um ataque causado apenas por seres cruéis.", 1, 1),
    BADHEALING("Cicatrização Cruel", "Um miasma escuro capaz de curar monstros terríveis", 0, -3),
    SHOUT("Grito", "Thorffy utiliza de seus gritos para aterrorizar seus inimigos.", 2, 2),
    FEAR("Medo", "Zigg encontra os medos mais profundos de suas vítimas para fazê-las se renderem.", 3, 3),
    MANIPULATION("Manipulação", "Lorde Graf utiliza de manipulações para acabar com seus oponentes.", 4, 4);

    public final String NAME, DESCRIPTION;
    public final Integer DAMAGE, COST;

    Abilities(String name, String description, Integer damage, Integer cost) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.DAMAGE = damage;
        this.COST = cost;
    }
}
