package Battle;

public enum EquipableItems {
    SHIELD("Escudo", "", 2, Attributes.RESISTENCE);

    public final String NAME, DESCRIPTION;
    public final Integer MODIFIER;
    public final Attributes ATTRIBUTE;

    EquipableItems(String name, String description, Integer modifier, Attributes attribute) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.MODIFIER = modifier;
        this.ATTRIBUTE = attribute;
    }
}
