package entity;

public class PurchaseUtils<T extends AbstractPriceable, N extends Number> {
    private final Purchase<T, N> purchase;

    public PurchaseUtils(){
        purchase = null;
    }

    public PurchaseUtils(Purchase<T, N> purchase) {
        this.purchase = purchase;
    }

    public Purchase<T, N> getPurchase() {
        return purchase;
    }

    public void printPurchase() {
        System.out.println(purchase.getCost() + ";" + purchase.getItem() + ";" + purchase.getQuantity());
    }

    public void printCost() {
        Euro cost = purchase.getCost();
        System.out.println("cost = " + cost + " Euro");
    }

    public void printCostDiff(Purchase<? extends AbstractPriceable, ? extends Number> p) {
        String prefix = "";
        Euro costDiff = new Euro();
        int result = purchase.getCost().compareTo(p.getCost());

        if (result > 0){
            prefix = "POSITIVE ";
            costDiff = purchase.getCost().subtract(p.getCost());
        }
        if (result < 0){
            prefix = "NEGATIVE ";
            costDiff = p.getCost().subtract(purchase.getCost());
        }
        System.out.println("diff is " + prefix + costDiff + "Euro");
    }

    public void printSameCost(Purchase<? extends AbstractPriceable, ? extends Number>... purchases) {
        boolean isSameCost = false;

        for (Purchase<? extends AbstractPriceable, ? extends Number> p : purchases) {
            if (purchase.getCost().equals(p.getCost())) {
                isSameCost = true;
                break;
            }
        }
        System.out.println("Is same cost: " + isSameCost);
    }
}