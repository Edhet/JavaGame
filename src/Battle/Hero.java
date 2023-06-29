package Battle;

import Extra.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Hero extends Person implements Player {
    protected List<ConsumableItems> consumableItems;
    protected List<EquipableItems> equipableItems;

    public Hero(String name, Integer sanity, Integer strengh, Integer resistence, Integer agility) throws IllegalArgumentException {
        super(name, sanity, strengh, resistence, agility);
        consumableItems  = new ArrayList<>();
        equipableItems = new ArrayList<>();
    }

    @Override
    public void equipItem(EquipableItems item) throws IllegalStateException {
        if (hasItem(item, this.equipableItems))
            throw new IllegalStateException("Hero already has "+item.name()+" equiped");
        this.equipableItems.add(item);
    }

    @Override
    public void addItem(ConsumableItems item, Integer amount) {
        Optional<ConsumableItems> optionalItem = Utils.getFromList(item, this.consumableItems);
        if (optionalItem.isEmpty())
            consumableItems.add(item);
        else
            optionalItem.get().addItem(amount);
    }

    @Override
    public void useItem(ConsumableItems item) throws IllegalStateException {
        Optional<ConsumableItems> optionalItem = Utils.getFromList(item, this.consumableItems);
        if (optionalItem.isEmpty())
            throw new IllegalStateException("There is no such item on hero inventory");
        optionalItem.get().consumeItem();
    }
}
