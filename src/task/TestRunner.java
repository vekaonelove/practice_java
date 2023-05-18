package task;
import org.junit.jupiter.api.Test;
import task.Purchase;
import org.junit.Assert;


class TestRunner {

    @org.junit.jupiter.api.Test
    void verifyGetCost() {
        //1
        Purchase purchase1 = new Purchase(2, 33.3, 1);
        Assert.assertEquals(13300, purchase1.getCost());

        purchase1.setPercent(100);
        Assert.assertEquals(0, purchase1.getCost());

        purchase1.setPercent(50);
        Assert.assertEquals(10000, purchase1.getCost());


        //2
        Purchase purchase2 = new Purchase(999, 100, 1);
        Assert.assertEquals(0, purchase2.getCost());

        purchase2.setPercent(80);
        Assert.assertEquals(1998000, purchase2.getCost());

        purchase2.setPercent(50);
        Assert.assertEquals(4995000, purchase2.getCost());

    }

    @org.junit.jupiter.api.Test
    void verifyToString() {
        //1
        Purchase purchase1 = new Purchase(5, 56.7, 3);
        Assert.assertEquals("5;56.7;WEDNESDAY;21700", purchase1.toString());

        //2
        Purchase purchase2 = new Purchase(22, 12.34, 1);
        Assert.assertEquals("22;12.34;MONDAY;192900", purchase2.toString());

    }


    @org.junit.jupiter.api.Test
    void verifyPurchaseByIntDay() {
        Purchase purchase = new Purchase(17, 0.334, 6);
        Purchase purchase1 = new Purchase(purchase.getNumber(),purchase.getPercent(),purchase.getWeekDay());

        Assert.assertEquals(17, purchase.getNumber());
        Assert.assertEquals(WeekDay.SATURDAY, purchase.getWeekDay());
        Assert.assertEquals(0.334, purchase.getPercent(),0.0001);;

        Assert.assertEquals(purchase1.getNumber(), purchase.getNumber());
        Assert.assertEquals(purchase1.getWeekDay(), purchase.getWeekDay());
        Assert.assertEquals(purchase1.getPercent(), purchase.getPercent(),0.0001);;
    }

    @org.junit.jupiter.api.Test
    void verifyPurchaseByWeekDay() {
        Purchase purchase = new Purchase(123, 30, WeekDay.WEDNESDAY);
        Assert.assertEquals(123, purchase.getNumber());
        Assert.assertEquals(WeekDay.WEDNESDAY, purchase.getWeekDay());
        Assert.assertEquals(30, purchase.getPercent(),0.0001);;
    }

    @org.junit.jupiter.api.Test
    void verifyDefaultPurchase() {
        Purchase purchase = new Purchase();
        Assert.assertEquals(0, purchase.getNumber());
        Assert.assertEquals(null, purchase.getWeekDay());
        Assert.assertEquals(0, purchase.getPercent(),0.0001);;
    }

    @org.junit.jupiter.api.Test
    void verifyGetValueInEuro() {
        Assert.assertEquals("12.00", Financial.getValueInEuro(1200));
        Assert.assertEquals("12.34", Financial.getValueInEuro(1234));

    }

    @org.junit.jupiter.api.Test
    void verifyIllegalWeekDayNumberInConstructor() {
        int illegalDay = 30;
        Exception exception = Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            new Purchase(1234,40, illegalDay);
        });
        Assert.assertTrue(exception.getMessage().contains("Index " + illegalDay + " out of bounds"));
    }
}