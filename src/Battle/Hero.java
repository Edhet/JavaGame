package Battle;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Person implements Player {
    protected List<Item> consumableItems;
    protected List<EquipableItems> equipableItems;

    public Hero(String name, Integer sanity, Integer strengh, Integer resistence, Integer agility) throws IllegalArgumentException {
        super(name, sanity, strengh, resistence, agility);
        consumableItems  = new ArrayList<>();
        equipableItems = new ArrayList<>();
    }
}
