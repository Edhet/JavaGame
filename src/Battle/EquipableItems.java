package Battle;

public enum EquipableItems {
    SHIELD("Escudo", "", new Attributes(0, 2, 0));

    public final String NAME, DESCRIPTION;
    public final Attributes MODIFIERS;

    EquipableItems(String name, String description, Attributes modifiers) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.MODIFIERS = modifiers;
    }
}
