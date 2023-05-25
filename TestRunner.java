import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class TestRunner {

    @Test
    void verifyEuroAdd() {
        Euro euro1 = new Euro(200);
        Euro euro2 = new Euro(300);
        Euro result = euro1.add(euro2);
        Assert.assertEquals(new Euro(500), result);
    }

    @Test
    void verifyEuroCompareTo() {
        Euro euro1 = new Euro(200);
        Euro euro2 = new Euro(300);
        Euro euro3 = new Euro(200);
        Assert.assertTrue(euro1.compareTo(euro2) < 0);
        Assert.assertTrue(euro2.compareTo(euro1) > 0);
        Assert.assertTrue(euro1.compareTo(euro3) == 0);
    }

    @Test
    void verifyProductToString() {
        Product product = new Product("Water", new Euro(200));
        Assert.assertEquals("Product;Water;200", product.toString());
    }

    @Test
    void verifyPurchaseGetCost() {
        Product product = new Product("Water", new Euro(200));
        Purchase purchase = new Purchase(product, 3);
        Assert.assertEquals(new Euro(600), purchase.getCost());
    }

    @Test
    void verifyDiscountPurchaseGetCost() {
        Product product = new Product("Water", new Euro(200));
        DiscountPurchase purchase = new DiscountPurchase(product, 3, new Euro(50));
        Assert.assertEquals(new Euro(450), purchase.getCost());
    }

    @Test
    void verifyQuantityDiscountPurchaseGetCost() {
        Product product = new Product("Water", new Euro(200));
        QuantityDiscountPurchase purchase = new QuantityDiscountPurchase(product, 5, 3);
        Assert.assertEquals(new Euro(600), purchase.getCost());
    }

    @Test
    void verifyPurchaseEquals() {
        Product product1 = new Product("Water", new Euro(200));
        Product product2 = new Product("Milk", new Euro(400));
        Purchase purchase1 = new Purchase(product1, 3);
        Purchase purchase2 = new Purchase(product2, 3);
        Purchase purchase3 = new Purchase(product1, 3);
        Assert.assertNotEquals(purchase1, purchase2);
        Assert.assertEquals(purchase1, purchase3);
    }

    @Test
    void verifyDiscountPurchaseEquals() {
        Product product1 = new Product("Water", new Euro(200));
        Product product2 = new Product("Milk", new Euro(400));
        DiscountPurchase purchase1 = new DiscountPurchase(product1, 3, new Euro(50));
        DiscountPurchase purchase2 = new DiscountPurchase(product2, 3, new Euro(50));
        DiscountPurchase purchase3 = new DiscountPurchase(product1, 3, new Euro(50));
        Assert.assertNotEquals(purchase1, purchase2);
        Assert.assertEquals(purchase1, purchase3);
    }

    @Test
    void verifyQuantityDiscountPurchaseEquals() {
        Product product1 = new Product("Water", new Euro(200));
        Product product2 = new Product("Milk", new Euro(400));
        QuantityDiscountPurchase purchase1 = new QuantityDiscountPurchase(product1, 5, 3);
        QuantityDiscountPurchase purchase2 = new QuantityDiscountPurchase(product2, 5, 3);
        QuantityDiscountPurchase purchase3 = new QuantityDiscountPurchase(product1, 5, 3);
        Assert.assertNotEquals(purchase1, purchase2);
        Assert.assertEquals(purchase1, purchase3);
    }

    @Test
    void verifyTransportPurchaseEquals() {
        Product product1 = new Product("Water", new Euro(200));
        Product product2 = new Product("Milk", new Euro(400));
        TransportPurchase purchase1 = new TransportPurchase(product2, 3);
        TransportPurchase purchase2 = new TransportPurchase(product1, 5);
        TransportPurchase purchase3 = new TransportPurchase(product1, 5);
        Assert.assertNotEquals(purchase1, purchase2);
        Assert.assertEquals(purchase2, purchase3);
    }

    @Test
    void verifyPurchaseCompareTo() {
        Product product1 = new Product("Water", new Euro(200));
        Product product2 = new Product("Milk", new Euro(400));
        Purchase purchase1 = new Purchase(product1, 3);
        Purchase purchase2 = new Purchase(product2, 3);
        Purchase purchase3 = new Purchase(product1, 3);
        Assert.assertTrue(purchase1.compareTo(purchase2) > 0);
        Assert.assertTrue(purchase2.compareTo(purchase1) < 0);
        Assert.assertTrue(purchase1.compareTo(purchase3) == 0);
    }

    @Test
    void verifySearchMethod() {
        Product product1 = new Product("Water", new Euro(200));
        Product product2 = new Product("Milk", new Euro(400));
        Purchase purchase1 = new Purchase(product1, 3);
        Purchase purchase2 = new Purchase(product2, 3);
        Purchase purchase3 = new Purchase(product1, 5);
        Purchase[] purchases = {purchase1, purchase2, purchase3};

        Arrays.sort(purchases);

        Assert.assertEquals(2, search(purchases));
        Assert.assertEquals(-1, search(purchases));
    }

}