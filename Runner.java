import entity.*;

public class Runner {
    public static void main(String[] args) {

        //1. Create p1 instance - the purchase of 20 packages of milk with the price 1.70 Euro.
        Purchase<Product, Integer> p1 = new Purchase<>(new Product("Milk", new Euro(1, 70)), 20);
        PurchaseUtils<Product, Integer> pu1 = new PurchaseUtils<>(p1);

        //2. Output p1 and its cost with the PurchaseUtils instance pu1.
        pu1.printPurchase();
        pu1.printCost();

        //3. Create p2 instance - the purchase of 12.5 kg of sugar with the price 3.00 Euro.
        Purchase<Product, Double> p2 = new Purchase<>(new Product("Sugar", new Euro(300)), 12.5);
        PurchaseUtils<Product, Double> pu2 = new PurchaseUtils<>(p2);

        //4. Output the cost of p2 and the cost difference of p2 and p1.
        pu2.printCost();
        pu2.printCostDiff(p1);

        //5. Create p3 instance - the purchase of 60 kg of sugar with the price 2.80 Euro and the price discount 0.10 Euro.
        Purchase<DiscountProduct, Integer> p3 = new Purchase<>(new DiscountProduct("Sugar", new Euro(2, 80), new Euro(0, 10)), 60);

        //6. Without a link to a Purchase instance, i.e. with the help of an anonymous object,  create the PurchaseUtils instance pu4 for the gym workout for 2.25 months with the total cost 75.60 Euro and 5 participants.
        PurchaseUtils<Service, Double> pu4 = new PurchaseUtils<>(new Purchase<>(new Service("Gym", new Euro(75, 60), 5), 2.25));

        //7. Get the Service instance from the last purchase and output it.
        Service service = pu4.getPurchase().getItem();
        System.out.println(service);

        //8. Output the cost of the last purchase with a PurchaseUtils instance.
        pu4.printCost();

        //9. Using a PurchaseUtils instance, output whether someone of p1, p3 or the last purchase has the same cost as the p2 purchase.
        pu1.printSameCost(p1, p3, pu2.getPurchase());
    }
}
