package Battle;

public class EquipableItem extends Item {
    public final Attributes ATTRIBUTE;

    public EquipableItem(String name, String description, Integer effect, Attributes ATTRIBUTE) {
        super(name, description, effect);
        this.ATTRIBUTE = ATTRIBUTE;
    }
}
