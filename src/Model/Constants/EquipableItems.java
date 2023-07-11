package Model.Constants;

import Model.Attributes;

public enum EquipableItems {
    ARMOR("Armadura Brilhante", "Uma ótima opção para se proteger de intensos ataques.", new Attributes(0, 2, 0)),
    BOOT("Bota de Velocidade", "Uma bota capaz de te tornar... mais rápido?", new Attributes(0, 1, 2)),
    GLOVE("Luvas Brancas", "Quando vestida, torna seu usuário mais forte magicamente.", new Attributes(2, 1, 0)),
    SHIELD("Escudo Reforçado", "Um escudo duas vezes melhor!", new Attributes(1, 2, 0)),
    THORN("Capacete Espinhoso", "Dê cabeçadas para machucar seus oponentes.", new Attributes(1, 1, 0));

    public final String NAME, DESCRIPTION;
    public final Attributes MODIFIERS;

    EquipableItems(String name, String description, Attributes modifiers) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.MODIFIERS = modifiers;
    }


    @Override
    public String toString() {
        return NAME;
    }
}
