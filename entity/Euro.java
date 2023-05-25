package entity;

public class Euro {
    private final int value;

    public Euro() {
        this.value = 0;
    }

    public Euro(int value) {
        this.value = value;
    }

    public Euro(int euro, int cents) {
        this(100 * euro + cents);
    }

    public Euro(Euro euro){
        this(euro.value);
    }

    public int getEuros(){
        return value / 100;
    }

    public int getCents(){
        return value % 100;
    }

    public Euro add (Euro euro){
        return new Euro(value + euro.value);
    }

    public Euro subtract(Euro euro){
        return new Euro(value - euro.value);
    }

    public Euro multiply(int x){
        return new Euro(value * x);
    }

    private static int pow10(int d){
        int[] tenPowD = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        return tenPowD[d];
    }

    protected Euro round(RoundMethod roundMethod, int d){
        double roundedValue = roundMethod.round(value / pow10(d)) * pow10(d);
        return new Euro((int) roundedValue);
    }
    public Euro mul(double k, RoundMethod roundMethod, int d){
        double roundedValue = roundMethod.round(value * k / pow10(d)) * pow10(d);
        return new Euro((int) roundedValue);
    }
    public enum RoundMethod {
        FLOOR {
            public double round(double d) {
                return Math.floor(d);
            }
        },
        ROUND{
            public double round(double d) {
                return Math.round(d);
            }
        },
        CEIL {
            public double round(double d) {
                return Math.ceil(d);
            }
        };

        abstract double round(double value);
    }


    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Euro euro = (Euro) obj;
        return value == euro.value;
    }

    public int compareTo(Euro euro) {
        int currentCents = this.value;
        int centsToCompare = euro.value;
        return Integer.compare(currentCents, centsToCompare);
    }

}
