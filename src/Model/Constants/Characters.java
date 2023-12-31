package Model.Constants;

public enum Characters {

    ARIA(true,
            "Aria Doom", """
            Aria D. era filha única de uma das famílias mais renomadas de Ezus. Desde pequena, Aria fora educada com muitas expectativas,
            e todos que não possuíssem o sangue dos Doom, eram tratados como inferiores. Aria não era capaz de reconhecer as diferenças e sempre
            buscava uma forma de vangloriar a si mesma. Sua mãe havia morrido em seu parto, então sempre viveu às sombras de seu pai, cujo
            ensinamentos transformaram a doce garota em uma narcisista completa. A paz que Aria conhecia fora brutalmente interrompida quando um
            evento trágico ocorreu, a família Doom fora acusada de ser discípula do Lorde Graf, um ser demoníaco capaz de transferir parte de
            sua energia aos seus adeptos, chamados Bestas Maculadas. Aria conseguiu escapar, mas sua família não, a qual foi condenada à morte.""",
            10,
            2, 1, 4,
            new Abilities[]{Abilities.ATTACK, Abilities.PUNCH, Abilities.GRACE}
    ),

    DAMIEN(true, "Damien", """
            Damien era um Rejeitado, cidadão da parte oculta da civilização de Ezus. Por ser descendente de um dos 21 Generais
            da Fome, Damien não era capaz de viver uma vida tranquila. Seus pais foram sentenciados à morte pela falsa acusação de serem
            Bestas Maculadas e foram mortos quando Damien tinha 12 anos. Essa terrível perda marcou profundamente sua alma e fez com que
            Damien desistisse de sua própria felicidade e odiasse profundamente a sociedade de Ezus. Guiado por um desígnio inabalável,
            Damien conheceu o Eremita da Loucura, um sábio capaz de oferecer ao indivíduo a possibilidade de controlar o Ego, e, confiante
            de suas escolhas, aceitou a oferta sem relutâncias.""",
            10,
            2, 2, 3,
            new Abilities[]{Abilities.ATTACK, Abilities.PUNCH, Abilities.EGO}
    ),

    THORFFY(false, "Thorffy, o Guardião de Sétiah", "\nVocê deve derrotar Thorffy por meio de um confronto direto para conseguir avançar e entrar\n" +
            "na Torre de Lorde Graf.\n",
            10,
            2, 3, 1,
            new Abilities[]{Abilities.ATTACK, Abilities.MALICIOUSATTACK, Abilities.BADHEALING, Abilities.SHOUT}

    ),

    ZIGG(false, "Zigg, o Lacaio de Graf", "\nPara você chegar à sala de Lorde Graf, primeiro deve derrotar o seu criado mais leal, Zigg.\n",
            12,
            3, 3, 4,
            new Abilities[]{Abilities.ATTACK, Abilities.MALICIOUSATTACK, Abilities.BADHEALING, Abilities.FEAR}

    ),

    LORDGRAF(false, "Lorde Graf", "\nVocê precisa colocar um fim à tirania de Lorde Graf, logo deve aniquilar o seu arqui-inimigo.\n",
            15,
            6, 6, 6,
            new Abilities[]{Abilities.ATTACK, Abilities.MALICIOUSATTACK, Abilities.BADHEALING, Abilities.MANIPULATION}
    );

    public final boolean IS_PLAYABLE;
    public final String NAME, STORY;
    public final int SANITY, STRENTGH, RESISTENCE, AGILITY;
    public final Abilities[] ABILITIES;

    Characters(boolean isPlayable, String name, String story, int sanity, int strengh, int resistence, int agility, Abilities[] abilities) {
        this.IS_PLAYABLE = isPlayable;
        this.NAME = name;
        this.STORY = story;
        this.SANITY = sanity;
        this.STRENTGH = strengh;
        this.RESISTENCE = resistence;
        this.AGILITY = agility;
        this.ABILITIES = abilities;
    }
}
