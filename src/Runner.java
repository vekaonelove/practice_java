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
            final int PURCHASES_NUMBER = sc.nextInt();

            if (PURCHASES_NUMBER < 0 || PURCHASES_NUMBER > 9) {
                throw new RuntimeException("Incorrect number at the first line");
            }

            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            /*** Initialize  array by the file  ***/
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                int numberOfUnits = sc.nextInt();
                double discountPercent = sc.nextDouble();
                int dayOfWeek = sc.nextInt();
                purchases[i] = new Purchase(numberOfUnits, discountPercent, dayOfWeek);
            }

            /*** Initialize this array by the file data ***/
            for (Purchase purchase : purchases) {
                System.out.println(purchase.toString());
            }

            /*** Calculate the average cost of all purchases (3 digits after the point) ***/
            int totalPurchasesNumber = 0;
            long totalCost = 0;
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                totalCost += purchases[i].getCost();
                totalPurchasesNumber += purchases[i].getNumber();
            }


            double averageCost = (double) totalCost / totalPurchasesNumber;
            System.out.format("\nAverage cost: %.3f", averageCost);


            /*** Calculate the total cost of all purchases on Monday ***/
            long totalMondaysCost = 0;
            for (Purchase purchase : purchases) {
                if (purchase.getWeekDay() == WeekDay.MONDAY) {
                    totalMondaysCost += purchase.getCost();
                }
            }

            System.out.println("\nTotal cost on Mondays: " + Financial.getValueInEuro(totalMondaysCost));

            /*** Calculate the day with the maximum purchase cost ***/
            long[] purchasesCosts = new long[PURCHASES_NUMBER];
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                purchasesCosts[i] = purchases[i].getCost();
            }

            int maxIndex = 0;
            long max = purchasesCosts[0];
            for (int i = 1; i < PURCHASES_NUMBER; i++) {
                if (purchasesCosts[i] > max) {
                    max = purchasesCosts[i];
                    maxIndex = i;
                }
            }
            System.out.println("\nThe day with the maximum purchase cost: " + purchases[maxIndex].getWeekDay() + "\n");

            /*** Sort the array by the field number in the ascending order by the method sort of the class Arrays. ***/

            Arrays.sort(purchases);
            for (Purchase purchase : purchases) {
                System.out.println(purchase);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }



        /*** Purchase with number of units = 5 from all files ***/
        String[] filesArray = new String[]{"src/in.txt", "src/in1.txt", "src/in2.txt", "src/in3.txt", "src/in4.txt", "src/in5.txt", "src/in6.txt"};

        for (int i = 0; i < filesArray.length; i++) {
            try (Scanner sc = new Scanner(new FileReader(filesArray[i]))) {
                sc.useLocale(Locale.ENGLISH);
                final int PURCHASES_NUMBER = sc.nextInt();

                if (PURCHASES_NUMBER < 0 || PURCHASES_NUMBER > 9) {
                    throw new RuntimeException("Incorrect number at the first line");
                }

                Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

                for (int j = 0; j < PURCHASES_NUMBER; j++) {
                    int numberOfUnits = sc.nextInt();
                    double discountPercent = sc.nextDouble();
                    int dayOfWeek = sc.nextInt();
                    purchases[j] = new Purchase(numberOfUnits, discountPercent, dayOfWeek);
                }

                Arrays.sort(purchases);

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
    }
}