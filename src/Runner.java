import entity.Euro;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;



public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = 6;

            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            Euro maxPurchaseCost = new Euro(0);
            Purchase purchaseWithMaxCost = new Purchase();

            boolean allPurchasesEqualFlag = true;

            for (int i = 0;i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);

                if (purchases[i].getCost().compareTo(maxPurchaseCost) > 0){
                    maxPurchaseCost = purchases[i].getCost();
                    purchaseWithMaxCost = purchases[i];
                }

                if (allPurchasesEqualFlag){
                    allPurchasesEqualFlag = purchases[i].equals(purchases[0]);
                }
            }
            System.out.println("\nPurchase with max cost is: " + purchaseWithMaxCost);
            System.out.println("\nAll purchases are equal: " + allPurchasesEqualFlag);

        }

        catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }


    }
}