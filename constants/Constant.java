package constants;

import entity.Purchase;

public class Constant {
    public static final String SEPARATOR = ";";
    public static final String SPACE = "=>";
    public static final String EQUAL = " = ";
    public static final String FRACTIONAL_NUMBER_FORMAT = "%d.%02d";
    public static final String FILE_NOT_FOUND = "Input file is not found";
    public static final String PRICE_PURCHASES = "pricePurchases";
    public static final String THE_TOTAL_COST_OF = "The total cost of ";
    public static final String THE_FIRST_WEEKDAYS = "The first weekdays: ";
    public static final String THE_LAST_WEEKDAYS = "The last weekdays: ";
    public static final String SHOPPING_BY_DAY = "Shopping by day ";
    public static final String BREAD_WITH_PRICE_155 = "bread with price 1,55 euro: ";
    public static final String BREAD_WITH_PRICE_170 = "bread with price 1,70 euro: ";
    public static final String ELEMENT_NOT_FOUND = "Element not found!";
    public static final String FIRST_MAP_BEFORE_CHANGES = "firstPurchaseMap before changes: ";
    public static final String FIRST_MAP_AFTER_CHANGES = "firstPurchaseMap after changes: ";
    public static final String LAST_MAP_BEFORE_CHANGES = "lastPurchaseMap before changes: ";
    public static final String LAST_MAP_AFTER_CHANGES = "lastPurchaseMap after changes: ";
    public static final String DAYS_PURCHASE_MAP_BEFORE_CHANGES = "daysPurchaseMap before changes: ";
    public static final String DAYS_PURCHASE_MAP_AFTER_CHANGES = "daysPurchaseMap after changes: ";

    public static final String LINE_SEPARATOR = "__________________________________________________________________________";
    public static final int NAME_FIELD = 0;
    public static final int PRICE_FIELD = 1;
    public static final int NUMBER_FIELD = 2;
    public static final int PURCHASE_FIELDS_NUMBER = Purchase.class.getDeclaredFields().length;
    public static final int DIVISOR = 100;
    public static final int DISCOUNT_FIELD = 3;
}
