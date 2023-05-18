import java.util.*;

public class PurchasesFactory {
    private enum PurchaseKind {
        PURCHASE {
            Purchase getPurchase(Scanner sc) {
                return new Purchase(sc);
            }
        },
        DISCOUNT_PURCHASE {
            DiscountPurchase getPurchase(Scanner sc) {
                return new DiscountPurchase(sc);
            }
        },
        QUANTITY_DISCOUNT_PURCHASE {
                QuantityDiscountPurchase getPurchase(Scanner sc) {
                    return new QuantityDiscountPurchase(sc);
                }
        };
        abstract Purchase getPurchase(Scanner sc);
    }
    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        return PurchaseKind.valueOf(id).getPurchase(sc);
    }
}