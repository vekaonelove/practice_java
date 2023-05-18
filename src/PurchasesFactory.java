import java.util.*;

public class PurchasesFactory {
    private enum PurchaseKind {
        Purchase, DiscountPurchase, QuantityDiscountPurchase;
    }



    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        switch(kind) {
            case Purchase :
                return new Purchase(sc);

            case DiscountPurchase:
                return new DiscountPurchase(sc);

            case QuantityDiscountPurchase:
                return new QuantityDiscountPurchase(sc);

            default :
                throw new IllegalArgumentException();
        }
    }



}