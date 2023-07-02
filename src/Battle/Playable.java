package Battle;

import Extra.Utils;

import java.util.List;
import java.util.Optional;

public class Playable extends Person implements Inventory {
    protected List<ConsumableItems> consumableItems;
    protected List<EquipableItems> equipableItems;

    public Playable(String name, String story, Integer sanity, Attributes attributes, List<Abilities> abilities, List<ConsumableItems> consumableItems, List<EquipableItems> equipableItems) throws IllegalArgumentException {
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
    public void addItem(ConsumableItems item, Integer amount) {
        Optional<ConsumableItems> optionalItem = Utils.getFromList(item, this.consumableItems);
        if (optionalItem.isEmpty())
            consumableItems.add(item);
        else
            optionalItem.get().addItem(amount);
    }

    // TODO: Checar se o efeito do item e nulo e adicionar uma regra especifica para ele (efeito aleatorio por exemplo)
    @Override
    public void useItem(ConsumableItems item) throws IllegalStateException {
        Optional<ConsumableItems> optionalItem = Utils.getFromList(item, this.consumableItems);
        if (optionalItem.isEmpty())
            throw new IllegalStateException("There is no such item on hero inventory");

        if (item.EFFECT != null)
            changeSanity(item.EFFECT);
        optionalItem.get().consumeItem();
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
