package task;
import task.WeekDay;
public class Purchase implements Comparable<Purchase>{
    public static final String NAME = "IPhone";
    public static final int PRICE = 10000; //IN CENTS!
    private int number;
    private double percent;
    private WeekDay weekDay;

    public Purchase() {
        this(0,0.0,null);
    }

    public Purchase(int number, double percent, WeekDay weekDay) {
        this.number = number;
        this.percent = percent;
        this.weekDay = weekDay;
    }

    public Purchase(int number, double percent, int day) {
        this(number,percent,WeekDay.values()[day]);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }


    public long getCost(){
        double cost = (PRICE * number * (100-percent)/100) / 100; // [cents] * coefficient * coefficient / 100 = [Euro]
        long roundedCostInEuro = Math.round(cost); //rounded to 1 Euro (in longs)
        return roundedCostInEuro * 100; // in cents
    };

    @Override
    public String toString() {
         return String.format("%s;%s;%s;%s", number, percent, weekDay, getCost());
    }

    public int compareTo(Purchase purchase){
        return number - purchase.number;
    };

}

