package entity;

public abstract class AbstractPurchase implements Comparable<AbstractPurchase> {
    private final Product product;
    private final int numberOfUnits;

    public AbstractPurchase() {
        this.product = new Product();
        this.numberOfUnits = 0;
    }

    public AbstractPurchase(Product product, int numberOfUnits) {
        this.product = product;
        this.numberOfUnits = numberOfUnits;
    }

    public Product getProduct() {
        return product;
    }


    public int getNumberOfUnits() {
        return numberOfUnits;
    }


    public abstract Euro getFinalCost(Euro baseCost);

    public Euro getCost() {
        Euro baseCost = product.getPrice().multiply(numberOfUnits);
        Euro finalCost = getFinalCost(baseCost);
        return finalCost.round(Euro.RoundMethod.FLOOR, 2);
    }

    @Override
    public String toString() {
        return String.format("%s;%s", fieldsToString(), getCost());
    }

    protected String fieldsToString(){
        return  getClass().getSimpleName() + ";" + product.getName() + ";" + product.getPrice() + ";" + numberOfUnits;
    }
    @Override
    public int compareTo(AbstractPurchase purchase) {
            return 0 - getCost().compareTo(purchase.getCost());
        }

    public boolean equals(AbstractPurchase purchase) {
        return getCost().equals(purchase.getCost());
    }
}

