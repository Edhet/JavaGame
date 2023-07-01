package Battle;

import Extra.Utils;

public class Attributes {
    private final int MIN_ATTRIBUTE_VAL = 0, MAX_ATTRIBUTE_VAL = 10;
    private Integer strengh, resistence, agility;

    public Attributes(Integer strengh, Integer resistence, Integer agility) {
        setStrengh(strengh);
        setResistence(resistence);
        setAgility(agility);
    }

    public void applyItemEffect(EquipableItems item) {
        setStrengh(this.strengh + item.MODIFIERS.getStrengh());
        setResistence(this.resistence + item.MODIFIERS.getResistence());
        setAgility(this.agility += item.MODIFIERS.getAgility());
    }

    public Integer getStrengh() {
        return strengh;
    }

    public void setStrengh(int strengh) {
        this.strengh = Utils.clamp(strengh,  MIN_ATTRIBUTE_VAL, MAX_ATTRIBUTE_VAL);
    }

    public Integer getResistence() {
        return resistence;
    }

    public void setResistence(int resistence) {
        this.resistence = Utils.clamp(resistence, MIN_ATTRIBUTE_VAL, MAX_ATTRIBUTE_VAL);
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = Utils.clamp(agility, MIN_ATTRIBUTE_VAL, MAX_ATTRIBUTE_VAL);
    }
}
