package entity;

public class TransportPurchase extends AbstractPurchase {
    private Euro transportExpenses;

    public TransportPurchase() {
    }

    public TransportPurchase(Product product, int numberOfUnits, Euro transportExpenses) {
        super(product, numberOfUnits);
        this.transportExpenses = transportExpenses;
    }

    public Euro getTransportExpenses() {
        return transportExpenses;
    }

    public void setTransportExpenses(Euro transportExpenses) {
        this.transportExpenses = transportExpenses;
    }

    @Override
    public Euro getCost() {
        Euro unitCost = product.getPrice();
        Euro totalCost = new Euro(unitCost.getValue() * numberOfUnits);
        return new Euro(totalCost.getValue() + transportExpenses.getValue());
    }
}
