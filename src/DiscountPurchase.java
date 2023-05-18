import entity.Euro;

import java.util.Objects;
import java.util.Scanner;

public class DiscountPurchase extends Purchase{
    private Euro discount;

    public DiscountPurchase() {
        super();
        this.discount = new Euro();
    }

    public DiscountPurchase(String name, Euro euro, int numberOfUnits, Euro discount) {
        super(name, euro, numberOfUnits);
        this.discount = discount;
    }

    public DiscountPurchase(Scanner sc) {
        super(sc);
        this.discount = new Euro(sc.nextInt());
    }

    public void setDiscount(Euro discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("%s;%s",fieldsToString(), getCost());
    }

    protected String fieldsToString() {
        return  super.fieldsToString() + ";" + discount;
    }
    @Override
    public Euro getCost(){
        Euro euroForCalculation = new Euro(getEuro());
        return euroForCalculation.subtract(discount).multiply(getNumberOfUnits());
    }


}
