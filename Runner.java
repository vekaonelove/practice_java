import entity.*;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        final Product product = new Product("Milk", new Euro(500));

        AbstractPurchase[] purchases = new AbstractPurchase[]{
                new DiscountedPurchase(product, 1, new Euro(0)),
                new DiscountedPurchase(product, 4, new Euro(1)),
                new QuantityDiscountPurchase(product, 2, 0.1),
                new QuantityDiscountPurchase(product, 10, 0.2),
                new TransportPurchase(product, 3, new Euro(555)),
                new TransportPurchase(product, 2, new Euro(764))};

        print(purchases);

        Arrays.sort(purchases);

        print(purchases);

        Euro minCost = purchases[purchases.length - 1].getCost();
        System.out.println("\nMinimum cost = " + minCost);

        int searchIndex = search(purchases);
        if (searchIndex > -1) {
            System.out.println("\nFound purchase at index " + searchIndex + ": " + purchases[searchIndex]);
        } else {
            System.out.println("\nFailed to find purchase with cost 5.00 Euro.");
        }

    }

    private static void print(AbstractPurchase[] purchases) {
        System.out.println("\nArray:");
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }
    }

    private static int search(AbstractPurchase[] purchases) {
        final Product product = new Product("Milk", new Euro(500));
        AbstractPurchase discountedPurchase = new TransportPurchase(product, 1, new Euro(0));

        int searchIndex = Arrays.binarySearch(purchases, discountedPurchase);
        return searchIndex;
    }
}
