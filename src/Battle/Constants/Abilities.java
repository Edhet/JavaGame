package Battle.Constants;

public enum Abilities {
    ATTACK("Ataque Básico", "Apenas um ataque básico.", 1, 0),
    GRACE("Graça dos Doom", "Capacidade de controlar orbes energizadas. Há um desgaste mental nas manipulações, ocasionando perda de sanidade.", 2, 1),
    EGO("Ego", "Um sentimento selado capaz de aniquilar seus inimigos e, à medida em que o poder é utilizado, perde-se sanidade.", 2, 1),
    SHOUT("Thorffy, o Guardião de Sétiah", "Thorffy utiliza de seus gritos para aterrorizar seus inimigos.", 2, 2),
    FEAR("Zigg, o Lacaio de Graf", "Zigg encontra os medos mais profundos de suas vítimas para fazê-las se renderem.", 3, 3),
    MANIPULATION("Lorde Graf", "Lorde Graf utiliza de manipulações para acabar com seus oponentes.", 4, 4);

    public final String NAME, DESCRIPTION;
    public final Integer DAMAGE, COST;

    Abilities(String name, String description, Integer damage, Integer cost) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.DAMAGE = damage;
        this.COST = cost;
    }
}
