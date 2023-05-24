import entity.*;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Product product = new Product("Product 1", new Euro(10.00));

        AbstractPurchase[] purchases = new AbstractPurchase { new DiscountedPurchase(product, 3, new Euro(2.00)),
                new DiscountedPurchase(product, 4, new Euro(3.00)), new QuantityDiscountPurchase(product, 2, 0.1),
                new QuantityDiscountPurchase(product, 5, 0.2),
                new TransportPurchase(product, 3, new Euro(5.00)),
                new TransportPurchase(product, 2, new Euro(7.00))}

        System.out.println("Array:");
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }

        Arrays.sort(purchases);

        System.out.println("\nArray after sorting:");
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }

        double minCost = purchases[purchases.length - 1].getCost().getValue();
        System.out.println("\nMinimum cost = " + minCost);

        int searchIndex = search(purchases, new Euro(5.00));
        if (searchIndex != -1) {
            System.out.println("\nFound purchase at index " + searchIndex + ": " + purchases[searchIndex]);
        } else {
            System.out.println("\nFailed to find purchase with cost 5.00 Euro.");
        }
    }

    private static int search(AbstractPurchase[] purchases, Euro targetCost) {
        int index = Arrays.binarySearch(purchases, targetCost, new Comparator<AbstractPurchase>() {
            @Override
            public int compare(AbstractPurchase p1, AbstractPurchase p2) {
                double cost1 = p1.getCost().getPrice();
                double cost2 = p2.getCost().getPrice();
                return Double.compare(cost1, cost2);
            }
        });
        return index >= 0 ? index : -1;
    }
}
