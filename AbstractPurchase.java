package entity;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private Product product;
    private int numberOfUnits;

    public AbstractPurchase() {
    }

    public AbstractPurchase(Product product, int numberOfUnits) {
        this.product = product;
        this.numberOfUnits = numberOfUnits;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public abstract Euro getCost(){
        return product.getPrice().multiply(numberOfUnits);
    };

    @Override
    public String toString() {
        return getClass().getSimpleName() + ";" + product + ";" + getCost();
    }

    @Override
    public int compareTo(AbstractPurchase purchase) {
        return purchase.getCost().getValue() - getCost().getValue();
    }
}
