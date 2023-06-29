package entity;

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

    abstract double roundFunction(double value);
    public static int pow10(int d){
        int[] tenPowD = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        return tenPowD[d];
    }

    public int round(double roundedValue, int d){
        int result = (int) roundFunction(roundedValue / pow10(d) * pow10(d));
        return result;
    }
}