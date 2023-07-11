package Model.Constants;

public enum ConsumableItems {
    POTION("Poção de Sanidade", "Poções produzidas diretamente da Fonte de Ezus, conhecida por produzir as melhores poções do mundo.", 3, 3, 2),
    SONG("Canto de Zeru", "Uma canção escrita por Zeru, famoso poeta da era da Grande Fome, capaz de aumentar, uma única vez, a sanidade do personagem.", 8, 1, 1),
    RING("Apogeu Anelar", "Um anel brilhante forjado de um material suspeito e não reconhecido capaz de aumentar a sanidade do personagem.", 5, 2, 2),
    EMPTYBOX("Caixa Vazia", "Embora seja uma caixa e esteja vazia, há a possibilidade de aumentar a sanidade ou diminuir a sanidade.", null, 0, 100);

    public final String NAME, DESCRIPTION;
    public final Integer EFFECT;
    private final Integer DEFAULT_ADD_AMOUNT;

    private Integer amount;

    ConsumableItems(String name, String description, Integer effect, Integer defaultAddAmount, Integer amount) {
        this.NAME = name;
        this.DESCRIPTION = description;
        this.EFFECT = effect;
        this.DEFAULT_ADD_AMOUNT = defaultAddAmount;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void addItem() throws IllegalStateException {
        this.amount += DEFAULT_ADD_AMOUNT;
    }

    public void consumeItem() throws IllegalStateException {
        if (this.amount <= 0)
            throw new IllegalStateException(this.NAME + " amount is below/equal to zero");
        this.amount--;
    }

    public ConsumableItems setAmount(Integer amount) throws IllegalArgumentException {
        if (amount < 0)
            throw new IllegalArgumentException("Amount is bellow zero");
        this.amount = amount;
        return this;
    }


    @Override
    public String toString() {
        return NAME;
    }
}
