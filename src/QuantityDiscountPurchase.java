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
        return String.format("%s;%s;%s;%d;%s;%s", getClass().getSimpleName(), getName(), getEuro(), getNumberOfUnits(),
                discountRate, getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        QuantityDiscountPurchase that = (QuantityDiscountPurchase) o;

        return Double.compare(that.discountRate, discountRate) == 0;
    }

}