package entity;

public class DiscountedPurchase extends AbstractPurchase {
    private Euro discountPerUnit;

    public DiscountedPurchase() {
    }

    public DiscountedPurchase(Product product, int numberOfUnits, Euro discountPerUnit) {
        super(product, numberOfUnits);
        this.discountPerUnit = discountPerUnit;
    }

    public Euro getDiscountPerUnit() {
        return discountPerUnit;
    }

    public void setDiscountPerUnit(Euro discountPerUnit) {
        this.discountPerUnit = discountPerUnit;
    }

    public Euro getFinalCost(Euro baseCost) {
        Euro priceToSubtract = discountPerUnit.multiply(getNumberOfUnits());
        return baseCost.subtract(priceToSubtract);
    }
}
