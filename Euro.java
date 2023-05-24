package entity;

public class Euro {
    private final int value;

    public Euro() {
    }

    public Euro(int value) {
        super();
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
        value += euro.value;
        return this;
    }

    public Euro subtract(Euro euro){
        value -= euro.value;
        return this;
    }

    public Euro multiply(int x){
        value *= x;
        return this;
    }

    private static int pow10(int d){
        int[] tenPowD = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        return tenPowD[d];
    }


    public Euro mul(double k, RoundMethod roundMethod, int d){
        value = roundMethod.round(value * k, d);
        return this;
    }

    public enum RoundMethod {
        FLOOR {
            public double roundFunction(double d) {
                return Math.floor(d);
            }
        },
        ROUND{
            public double roundFunction(double d) {
                return Math.round(d);
            }
        },
        CEIL {
            public double roundFunction(double d) {
                return Math.ceil(d);
            }
        };

        protected abstract double roundFunction(double value);
        private int round(double roundedValue, int d) {
            int tenPow = pow10(d);
            int result = (int) roundFunction(roundedValue / tenPow) * tenPow;
            return result;
        }
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
