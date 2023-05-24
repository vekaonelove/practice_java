package entity;

public class QuantityDiscountPurchase extends AbstractPurchase {
    private static final int DISCOUNT_THRESHOLD = 5;
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
    public Euro getCost() {
        Euro unitCost = product.getPrice();
        Euro totalCost = new Euro(unitCost.getValue() * numberOfUnits);
        if (numberOfUnits > DISCOUNT_THRESHOLD) {
            Euro discountAmount = new Euro(totalCost.getValue() * discountRate);
            totalCost = new Euro(totalCost.getValue()- discountAmount.getValue());
        }
        return totalCost;
    }
}
