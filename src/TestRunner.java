import org.junit.jupiter.api.Test;
import entity.Euro;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class TestRunner {
    @Test
    void verifyEuro() {
        Euro euro1 = new Euro(100);
        Assert.assertEquals(new Euro(1, 0), euro1);

        Euro euro2 = new Euro(euro1);
        Assert.assertEquals(new Euro(100), euro2);
    }

    @Test
    void verifyEuroAdd() {
        Euro euro1 = new Euro(100);
        euro1.add(new Euro(400));
        Assert.assertEquals(new Euro(500), euro1);
    }

    @Test
    void verifyEuroSubtract() {
        Euro euro1 = new Euro(100);
        euro1.subtract(new Euro(50));
        Assert.assertEquals(new Euro(50), euro1);
    }

    @Test
    void verifyEuroMultiplyInt() {
        Euro euro1 = new Euro(345);
        euro1.multiply(2);
        Assert.assertEquals(new Euro(690), euro1);
    }

    @Test
    void verifyEuroMultiplyDouble() {
        Euro euro1 = new Euro(100);
        euro1.multiply(2.5);
        Assert.assertEquals(new Euro(250), euro1);
    }
    @Test
    void verifyEuroMulDoubleWithRound() {
        Euro euro1 = new Euro(100);
        euro1.mul(2.55, Euro.RoundMethod.CEIL,1);
        Assert.assertEquals(new Euro(260), euro1);
    }

    @Test
    void verifyPurchaseOrdinary() {
        Purchase purchase = new Purchase("Cake", new Euro(500), 6);
        Assert.assertEquals("Cake", purchase.getName());
        Assert.assertEquals(new Euro(5, 0), purchase.getEuro());
        Assert.assertEquals(6, purchase.getNumberOfUnits());
        ;
        Assert.assertEquals(new Euro(3000), purchase.getCost());
    }

    @Test
    void verifyDiscountPurchase() {
        DiscountPurchase purchase = new DiscountPurchase("Cake", new Euro(500), 6, new Euro(50));
        Assert.assertEquals("Cake", purchase.getName());
        Assert.assertEquals(new Euro(5, 0), purchase.getEuro());
        Assert.assertEquals(6, purchase.getNumberOfUnits());
        ;
        Assert.assertEquals(new Euro(2700), purchase.getCost());
    }

    @Test
    void verifyQuantityDiscountPurchase() {
        QuantityDiscountPurchase purchase = new QuantityDiscountPurchase("Cake", new Euro(500), 60, 70);
        Assert.assertEquals("Cake", purchase.getName());
        Assert.assertEquals(new Euro(5, 0), purchase.getEuro());
        Assert.assertEquals(60, purchase.getNumberOfUnits());
        ;
        Assert.assertEquals(new Euro(9000), purchase.getCost());
    }

    @Test
    void verifyGetCostPurchase() {
        Purchase purchase1 = new Purchase("Water", new Euro(200), 1);
        Assert.assertEquals(new Euro(200), purchase1.getCost());

        Purchase purchase2 = new Purchase("Milk", new Euro(400), 6);
        Assert.assertEquals(new Euro(2400), purchase2.getCost());

    }

    @Test
    void verifyGetCostDiscountPurchase() {
        DiscountPurchase purchase1 = new DiscountPurchase("Water", new Euro(200), 1, new Euro(150));
        Assert.assertEquals(new Euro(50), purchase1.getCost());
        Assert.assertEquals(new Euro(200), purchase1.getEuro());

        DiscountPurchase purchase2 = new DiscountPurchase("Milk", new Euro(400), 6, new Euro(1));
        Assert.assertEquals(new Euro(2394), purchase2.getCost());
        Assert.assertEquals(new Euro(400), purchase2.getEuro());

    }

    @Test
    void verifyGetCostQuantityDiscountPurchase() {
        QuantityDiscountPurchase purchase1 = new QuantityDiscountPurchase("Water", new Euro(200), 1, 0);
        Assert.assertEquals(new Euro(200), purchase1.getCost());

        QuantityDiscountPurchase purchase2 = new QuantityDiscountPurchase("Milk", new Euro(400), 11, 100);
        Assert.assertEquals(new Euro(0), purchase2.getCost());
    }

    @Test
    void verifyEqualsPurchase() {
        Purchase purchase1 = new Purchase("Water", new Euro(200), 1);
        Purchase purchase2 = new Purchase("Milk", new Euro(400), 11);
        Purchase purchase3 = new Purchase("Water", new Euro(200), 1);

        Assert.assertEquals(false, purchase2.equals(purchase1));
        Assert.assertEquals(true, purchase3.equals(purchase1));
        Assert.assertEquals(false, purchase2.equals(purchase3));
    }

    @Test
    void verifyEqualsDiscountPurchase() {
        DiscountPurchase purchase1 = new DiscountPurchase("Water", new Euro(200), 5, new Euro(3));
        DiscountPurchase purchase2 = new DiscountPurchase("Milk", new Euro(400), 11, new Euro(12));
        DiscountPurchase purchase3 = new DiscountPurchase("Water", new Euro(200), 5, new Euro(3));

        Assert.assertEquals(false, purchase2.equals(purchase1));
        Assert.assertEquals(true, purchase3.equals(purchase1));
        Assert.assertEquals(false, purchase2.equals(purchase3));
    }

    @Test
    void verifyEqualsQuantityDiscountPurchase() {
        QuantityDiscountPurchase purchase1 = new QuantityDiscountPurchase("Water", new Euro(200), 5, 3);
        QuantityDiscountPurchase purchase2 = new QuantityDiscountPurchase("Milk", new Euro(400), 11, 2);
        QuantityDiscountPurchase purchase3 = new QuantityDiscountPurchase("Water", new Euro(200), 5, 3);

        Assert.assertEquals(false, purchase2.equals(purchase1));
        Assert.assertEquals(true, purchase3.equals(purchase1));
        Assert.assertEquals(false, purchase2.equals(purchase3));
    }

    @Test
    void verifyEqualsAll() {
        QuantityDiscountPurchase purchase1 = new QuantityDiscountPurchase("Water", new Euro(200), 5, 3);
        DiscountPurchase purchase2 = new DiscountPurchase("Water", new Euro(200), 11, new Euro(20));
        Purchase purchase3 = new Purchase("Water", new Euro(200), 5);

        Assert.assertEquals(true, purchase2.equals(purchase1));
        Assert.assertEquals(true, purchase3.equals(purchase1));
        Assert.assertEquals(true, purchase2.equals(purchase3));
    }

    @Test
    void verifyGetPurchaseFromFactory() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("src/in.txt"));
        Purchase purchase = PurchasesFactory.getPurchaseFromFactory(sc);

        Assert.assertEquals(new Purchase("Milk", new Euro(180), 3), purchase);


    }
}
