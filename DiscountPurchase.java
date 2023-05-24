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

    @Override
    public Euro getCost() {
        Euro unitCost = product.getPrice();
        Euro discountedCost = new Euro(unitCost.getValue() - discountPerUnit.getValue());
        return new Euro(discountedCost.getValue() * numberOfUnits);
    }
}