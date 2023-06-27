package Battle;

public class ConsumableItem extends Item{
    private Integer amount;

    public ConsumableItem(String name, String description, Integer effect, Integer amount) throws IllegalArgumentException {
        super(name, description, effect);
        setAmount(amount);
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) throws IllegalArgumentException {
        if (amount < 0)
            throw new IllegalArgumentException("Item amount is bellow zero");
        this.amount = amount;
    }

    public void reduceAmount(int amount) throws IllegalStateException {
        if (this.amount <= 0)
            throw new IllegalStateException("Item amount is bellow/equal to zero");
        this.amount -= amount;
    }

    public void increaseAmount(int amount) {
        this.amount += amount;
    }
}
