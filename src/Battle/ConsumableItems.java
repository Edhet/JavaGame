package Battle;

public enum ConsumableItems {
    POTION("Poção de Sanidade", "Uma poção produzida diretamente da Fonte de Ezus, conhecida por produzir as melhores poções do mundo.", 2, 5),
    SONG("Canto de Zeru", "Uma canção escrita por Zeru, famoso poeta da era da Grande Fome, capaz de aumentar, uma única vez, a sanidade do personagem.", 4, 1),
    RING("Apogeu Anelar", "Um anel brilhante forjado de um material suspeito e não reconhecido capaz de aumentar a sanidade do personagem.", 2, 1),
    EMPTYBOX("Caixa Vazia", "Embora seja uma caixa e esteja vazia, há a possibilidade de aumentar a sanidade ou diminuir a sanidade.", null, 100);

    public final String NAME, DESCRIPTION;
    public final Integer EFFECT;
    private Integer amount;

    ConsumableItems(String name, String description, Integer effect, Integer amount) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.EFFECT = effect;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void addItem(Integer amount) throws IllegalStateException {
        this.amount += amount;
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
