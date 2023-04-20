import task.Purchase;
import task.WeekDay;
import task.Financial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        System.out.println(Purchase.NAME + " " + Purchase.PRICE);
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int purchasesNumber = sc.nextInt();

            if (purchasesNumber < 0 || purchasesNumber > 9) {
                throw new RuntimeException("Incorrect number at the first line");
            }

            Purchase[] purchases = new Purchase[purchasesNumber];

            /*** Initialize  array by the file  ***/
            for (int i = 0; i < purchasesNumber; i++) {
                double x = sc.nextDouble();
                int k = sc.nextInt();
                purchases[i] = new Purchase(i, x, k);
            }

            /*** Initialize this array by the file data ***/
            for (Purchase purchase : purchases) {
                System.out.println(purchase.toString());
            }

            /*** Calculate the average cost of all purchases (3 digits after the point) ***/

            long totalCost = 0;
            for (int i = 0; i < purchasesNumber; i++) {
                totalCost += purchases[i].getCost();
            }


            try {
                double averageCost = totalCost / purchasesNumber;
                System.out.printf("Average cost: %d.%03d%n", averageCost);
            } catch (Exception e) {
                //todo: printout error about division by zero
            }

            /*** Calculate the total cost of all purchases on Monday ***/
            long totalMondaysCost = 0;
            for (int i = 0; i < purchasesNumber; i++) {
                if (purchases[i].getWeekDay() == WeekDay.MONDAY) {
                    totalMondaysCost += purchases[i].getCost();
                }
            }

            System.out.printf("Total cost on Mondays: %s%n", totalMondaysCost);

            /*** Calculate the day with the maximum purchase cost ***/
            Map<WeekDay, Long> purchasesCostByDays = new HashMap<>();
            for ( Purchase purchase : purchases) {
                if()
                long cost = purchasesCostByDays.
                purchasesCostByDays.
            }
            /*** Sort the array by the field number in the ascending order by the method sort of the class Arrays. ***/
            /*double totalCost = 0;
            int totalCostMonday = 0;
            int maxCost = 0;
            WeekDay maxCostDay = null;
            double meanCost = 0.0;*/

            /*for (int i=0;i<purchasesNumber;i++){
                totalCost += purchases[i].getCost();
            }
            int meanCost = (totalCost/purchasesNumber)*/

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }


    }
}