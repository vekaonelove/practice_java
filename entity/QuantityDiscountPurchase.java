package entity;

public class QuantityDiscountPurchase extends AbstractPurchase {
    private static final int NUMBER_FOR_DISCOUNT = 5;
    private double discountRate;

    public QuantityDiscountPurchase() {
    }

    public QuantityDiscountPurchase(Product product, int numberOfUnits, double discountRate) {
        super(product, numberOfUnits);
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }


    @Override
    public Euro getFinalCost(Euro baseCost) {
        if (getNumberOfUnits() > NUMBER_FOR_DISCOUNT) {
            baseCost.mul(1 - (discountRate / 100.0), Euro.RoundMethod.ROUND, 0);
        }
        return baseCost;
    }
}

