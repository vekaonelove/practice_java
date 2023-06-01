package entity;

public class Purchase<T extends AbstractPriceable, N extends Number>{

    private final T item;
    private final N quantity;

    public Purchase(T item, N quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public T getItem() {
        return item;
    }

    public N getQuantity() {
        return quantity;
    }

    public Euro getCost() {
        return item.getPrice().mul(quantity.doubleValue(), RoundMethod.ROUND, 0);
    }

    @Override
    public String toString() {
        return item + ";" + quantity;
    }
}
