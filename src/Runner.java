import entity.Euro;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;



public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);

            Purchase[] purchases = new Purchase[6];

            Euro maxPurchaseCost = new Euro(0);
            Purchase purchaseWithMaxCost = new Purchase();

            boolean allPurchasesEqualFlag = true;
            purchases[0] = PurchasesFactory.getPurchaseFromFactory(sc);
            System.out.println(purchases[0]);




            for (int i = 1; i < 6; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);
                System.out.println(purchases[i]);

                if (purchases[i].getCost().compareTo(maxPurchaseCost) > 0){
                    maxPurchaseCost = purchases[i].getCost();
                    purchaseWithMaxCost = purchases[i];
                }

                if (!purchases[i-1].equals(purchases[i])){
                    allPurchasesEqualFlag = false;
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