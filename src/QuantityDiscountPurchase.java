import entity.Euro;
import java.util.Scanner;

public class QuantityDiscountPurchase extends Purchase{
    private static final int NUMBER_OF_UNITS = 10;
    private double discountRate;

    public QuantityDiscountPurchase() {
        super();
        this.discountRate = 0;
    }

    public QuantityDiscountPurchase(String productName, Euro price, int units, double discountRate) {
        super(productName, price, units);
        this.discountRate = discountRate;
    }

    public QuantityDiscountPurchase(Scanner scanner) {
        super(scanner);
        this.discountRate = scanner.nextDouble();
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public Euro getCost() {
        Euro totalCost = super.getCost();
        if (getNumberOfUnits() > NUMBER_OF_UNITS) {
            totalCost.multiply(1 - (discountRate / 100.0));
        }
        return totalCost;
    }

    @Override
    public String toString() {
        return String.format("%s;%s", fieldsToString(), getCost());
    }

    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discountRate;
    }
}