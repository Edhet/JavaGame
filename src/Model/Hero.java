package Model;

import Model.Constants.Abilities;
import Model.Constants.ConsumableItems;
import Model.Constants.EquipableItems;
import Extra.Utils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class Hero extends Person implements Inventory {
    protected List<ConsumableItems> consumableItems;
    protected List<EquipableItems> equipableItems;

    Hero(String name, String story, Integer sanity, Attributes attributes, List<Abilities> abilities, List<ConsumableItems> consumableItems, List<EquipableItems> equipableItems) throws IllegalArgumentException {
        super(name, story, sanity, attributes, abilities);
        this.consumableItems  = consumableItems;
        this.equipableItems = equipableItems;
    }

    @Override
    public void equipItem(EquipableItems item) throws IllegalStateException {
        if (hasItem(item))
            throw new IllegalStateException("Player already has "+item.name()+" equiped");

        this.equipableItems.add(item);
        this.attributes.applyItemEffect(item);
    }

    @Override
    public boolean hasItem(EquipableItems item) {
        return Utils.isOnList(item, this.equipableItems);
    }

    @Override
    public List<EquipableItems> getEquipableItems() {
        return equipableItems;
    }

    @Override
    public void addItem(ConsumableItems item) {
        Optional<ConsumableItems> optionalItem = Utils.getFromList(item, this.consumableItems);
        if (optionalItem.isEmpty())
            consumableItems.add(item);
        else
            optionalItem.get().addItem();
    }

    @Override
    public void useItem(ConsumableItems item) throws IllegalStateException {
        Optional<ConsumableItems> optionalItem = Utils.getFromList(item, this.consumableItems);
        if (optionalItem.isEmpty())
            throw new IllegalStateException("There is no such item on hero inventory");

        optionalItem.get().consumeItem();
        changeSanity(Objects.requireNonNullElseGet(item.EFFECT, () -> new Random().nextInt(-5, 5)));
    }

    @Override
    public boolean hasItem(ConsumableItems item) {
        return Utils.isOnList(item, consumableItems);
    }

    @Override
    public List<ConsumableItems> getConsumableItems() {
        return consumableItems;
    }
}
