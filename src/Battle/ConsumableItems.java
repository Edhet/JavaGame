package Battle;

public enum ConsumableItems {
    POTION("Pocao de Sanidade", 2, 4);

    public final String NAME;
    public final Integer EFFECT;
    private Integer amount;

    ConsumableItems(String name, Integer effect, Integer amount) {
        this.NAME = name;
        this.EFFECT = effect;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void consumeItem() throws IllegalStateException {
        if (this.amount <= 0)
            throw new IllegalStateException(this.NAME +" amount is below/equal to zero");
        this.amount--;
    }

    public ConsumableItems setAmount(Integer amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount is bellow zero");
        this.amount = amount;
        return this;
    }
}
