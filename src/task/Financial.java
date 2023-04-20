package task;

public class Financial {
    public static String getValueInEuro(double cost){
        return String.format("%d.%02d", cost / 100, Math.round(cost % 100));
    };
}
