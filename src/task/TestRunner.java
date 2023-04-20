package task;
import task.Purchase;
import org.junit.Assert;
import org.junit.Test;


class TestRunner {

    @org.junit.jupiter.api.Test
    void verifyGetCost() {
        Purchase purchase = new Purchase(2, 0, 1);
        Assert.assertEquals("200.0", purchase.getCost());

        purchase.setPercent(100);
        Assert.assertEquals("0.00", purchase.getCost());

        purchase.setPercent(50);
        Assert.assertEquals("100.00", purchase.getCost());

    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Purchase purchase = new Purchase(5, 56.7, 3);
        Assert.assertEquals("5;56.7;THURSDAY", purchase.toString());

    }

    @Test
    void compareTo() {
    }

    @Test
    void Purchase() {
    }
}