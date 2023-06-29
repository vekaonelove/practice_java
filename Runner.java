import entity.*;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import static constants.Constant.*;

public class Runner {
    public static void main(String[] args) {
        final String FILENAME = "in.csv";
        try (Scanner sc = new Scanner(new FileReader(FILENAME))) {
            Map<Purchase, WeekDay> firstPurchasesMap = new HashMap<>();
            Map<Purchase, WeekDay> lastPurchasesMap = new HashMap<>();
            Map<WeekDay, List<Purchase>> dayPurchasesMap = new EnumMap<>(WeekDay.class);

            List<PricePurchase> priceDiscountPurchases = new ArrayList<>();

            while (sc.hasNext()) {
                String line = sc.nextLine();
                Purchase purchase = PurchasesFactory.getPurchase(line);
                WeekDay weekday = WeekDay.valueOf(sc.nextLine());

                lastPurchasesMap.put(purchase, weekday); // 1
                if (!firstPurchasesMap.containsKey(purchase)) {
                    firstPurchasesMap.put(purchase, weekday); // 3
                }

                List<Purchase> purchaseList = dayPurchasesMap.get(weekday); //12
                if (purchaseList == null) {
                    purchaseList = new ArrayList<>();
                }
                purchaseList.add(purchase);
                dayPurchasesMap.put(weekday, purchaseList);
                if (purchase instanceof PricePurchase) {
                    priceDiscountPurchases.add(new PricePurchase(line.split(SEPARATOR))); // 10
                }
            }

            printMap(firstPurchasesMap, FIRST_MAP_BEFORE_CHANGES); // 2
            printMap(lastPurchasesMap, LAST_MAP_BEFORE_CHANGES); // 4

            //5
            final Purchase PURCHASE_BREAD_155 = new Purchase("bread",new Euro(155),0);
            findAndShow(firstPurchasesMap, PURCHASE_BREAD_155, THE_FIRST_WEEKDAYS + BREAD_WITH_PRICE_155);
            findAndShow(lastPurchasesMap, PURCHASE_BREAD_155, THE_LAST_WEEKDAYS + BREAD_WITH_PRICE_170);

            //6
            final Purchase PURCHASE_BREAD_170 = new Purchase("bread",new Euro(170),0);
            findAndShow(firstPurchasesMap, PURCHASE_BREAD_170, THE_FIRST_WEEKDAYS + BREAD_WITH_PRICE_170);

            //7
            removeEntries(firstPurchasesMap, new EntryChecker<Purchase, WeekDay>() {
                @Override
                public boolean check(Entry<Purchase, WeekDay> entry){
                    return (entry.getKey().getName().equals("meat"));
            }
            });

            //8
            removeEntries(lastPurchasesMap, new EntryChecker<Purchase, WeekDay>() {
                @Override
                public boolean check(Entry<Purchase, WeekDay> entry){
                    return (entry.getValue().equals(WeekDay.FRIDAY));
                }
            });

            //9
            printMap(firstPurchasesMap, FIRST_MAP_AFTER_CHANGES);
            printMap(lastPurchasesMap, LAST_MAP_AFTER_CHANGES);

            //11
            System.out.println(THE_TOTAL_COST_OF + PRICE_PURCHASES + EQUAL + getTotalCost(priceDiscountPurchases));

            //13
            printMap(dayPurchasesMap, DAYS_PURCHASE_MAP_BEFORE_CHANGES);

            //14
            for (WeekDay weekDay: WeekDay.values()){
                System.out.println(THE_TOTAL_COST_OF + weekDay + EQUAL + getTotalCost(dayPurchasesMap.get(weekDay)));
            }

            //15
            findAndShow(dayPurchasesMap, WeekDay.MONDAY, SHOPPING_BY_DAY + WeekDay.MONDAY + SPACE);

            //16
            removeEntries(dayPurchasesMap, new EntryChecker<WeekDay, List<Purchase>>() {
            @Override
                public boolean check(Entry<WeekDay, List<Purchase>> entry){
                boolean isTrue = false;
                for(Purchase purchase: entry.getValue()){
                    if (purchase.getName().equals("milk")){
                        isTrue = true;
                        break;
                    }
                }
                return isTrue;
            }
            });


            //17
            printMap(dayPurchasesMap, DAYS_PURCHASE_MAP_AFTER_CHANGES);
        } catch (FileNotFoundException e){
            System.err.println(FILE_NOT_FOUND);
        }
    }

        private static Euro getTotalCost(List<? extends Purchase> purchases){
        Euro cost = new Euro();
        if (purchases != null){
        for (Purchase purchase: purchases){
            cost = cost.add(purchase.getCost());
            }
        }
        return cost;
    }

    private static <K, V> void printMap(Map<K, V> map, String message) {
        System.out.println(message);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + SPACE + entry.getValue().toString());
        }
        System.out.println(LINE_SEPARATOR);
    }

    private static <K, V> void findAndShow(Map<K, V> map, K key, String header) {
        V value = map.get(key);
        if (value == null) {
            System.out.println(ELEMENT_NOT_FOUND);
        } else {
            System.out.println(header + value.toString());
        }
    }

    private static <K, V> void removeEntries(Map<K, V> map, EntryChecker<K, V> checker) {
        for (Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
             iterator.hasNext();) {
            if (checker.check(iterator.next())) {
                iterator.remove();
            }
        }
    }
}