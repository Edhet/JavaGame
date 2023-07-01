package Battle;

public enum Characters {
    ARIA(true,
            "Aria Doom", "story",
            10,
            1, 1, 1,
            new Abilities[]{Abilities.ATTACK},
            new ConsumableItems[]{},
            new EquipableItems[]{}
    );

    final boolean IS_PLAYABLE;
    final String NAME, STORY;
    final int SANITY, STRENTGH, RESISTENCE, AGILITY;
    final Abilities[] ABILITIES;
    final ConsumableItems[] CONSUMABLE_ITEMS;
    final EquipableItems[] EQUIPABLE_ITEMS;

    Characters(boolean isPlayable, String name, String story, int sanity, int strengh, int resistence, int agility, Abilities[] abilities, ConsumableItems[] consumableItems, EquipableItems[] equipableItems) {
        this.IS_PLAYABLE = isPlayable;
        this.NAME = name;
        this.STORY = story;
        this.SANITY = sanity;
        this.STRENTGH = strengh;
        this.RESISTENCE = resistence;
        this.AGILITY = agility;
        this.ABILITIES = abilities;
        this.CONSUMABLE_ITEMS = consumableItems;
        this.EQUIPABLE_ITEMS = equipableItems;
    }
}
