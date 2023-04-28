import task.Purchase;
import task.WeekDay;
import task.Financial;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("src/in.txt"))) {
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();

            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            /*** Fill this array by the file data ***/
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                int numberOfUnits = sc.nextInt();
                double discountPercent = sc.nextDouble();
                int dayOfWeek = sc.nextInt();
                purchases[i] = new Purchase(numberOfUnits, discountPercent, dayOfWeek);
            }

            /*** Output this array ***/
            printPurchaseArray(purchases);

            /*** Calculate the average cost of all purchases (3 digits after the point); Calculate the total cost of all purchases on Monday; Calculate the day with the maximum purchase cost ***/
            long totalCost = 0;
            long totalMondaysCost = 0;
            long maxCost = 0;
            double meanCost = 0.0;
            WeekDay maxCostDay = null;

            for (Purchase purchase : purchases) {
                long cost = purchase.getCost();
                totalCost += cost;

                if (purchase.getWeekDay() == WeekDay.MONDAY) {
                    totalMondaysCost += cost;
                }

                if (purchase.getCost() > maxCost){
                    maxCost = cost;
                    maxCostDay = purchase.getWeekDay();
                }

            }

            if(purchases.length > 0) {
                meanCost = ((double) totalCost) / purchases.length;
            }

            System.out.format("\nAverage cost: %.3f", meanCost); //4.1

            System.out.println("\nTotal cost on Mondays: " + Financial.getValueInEuro(totalMondaysCost)); //4.2

            System.out.println("\nThe day with the maximum purchase cost: " + maxCostDay + "\n"); //4.3



            /*** Sort the array by the field number in the ascending order by the method sort of the class Arrays. ***/
            Arrays.sort(purchases);
            printPurchaseArray(purchases);


            /*** Purchase with number of units = 5 from the file ***/
            int index = Arrays.binarySearch(purchases, new Purchase(5, 0, 0));
            if (index < 0) {
                System.out.println("No such element in the array");
            }
            else{
                System.out.println("\nPurchase with number of units = 5:\n" + purchases[index]);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }

    private static void printPurchaseArray(Purchase[] purchases){
        System.out.println(Purchase.NAME + " " + Purchase.PRICE); //constants
        for (Purchase purchase : purchases) {
            System.out.println(purchase); //array content
        }
    }
}