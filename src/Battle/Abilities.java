package Battle;

public enum Abilities {
    ATTACK("Ataque Básico", "Apenas um ataque básico.", 1, 0),
    GRACE("Graça dos Doom", "Capacidade de controlar orbes energizadas. Há um desgaste mental nas manipulações, ocasionando perda de sanidade.", 2, 1),
    EGO("Ego", "Um sentimento selado capaz de aniquilar seus inimigos e à medida em que o poder é utilizado, perde-se sanidade.", 2, 1),
    OBSTACLE1("Thorffy, o Guardião de Sétiah", "Thorffy utiliza de seus gritos para aterrorizar seus inimigos. Toda vez que grita, seu alvo acaba perdendo sanidade.", 2, 2),
    OBSTACLE2("Zigg, o Lacaio de Graf", "Zigg encontra os medos mais profundos de suas vítimas para fazê-las se renderem. Para cada ataque de Zigg, seu alvo acaba perdendo sanidade.", 3, 3),
    OBSTACLE3("Lorde Graf", "Lorde Graf utiliza de manipulações para acabar com seus oponentes. Cada ataque mental seu diminui a sanidade de seu alvo.", 4, 4);

    public final String NAME, DESCRIPTION;
    public final Integer DAMAGE, COST;

    Abilities(String name, String description, Integer damage, Integer cost) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.DAMAGE = damage;
        this.COST = cost;
    }
}
