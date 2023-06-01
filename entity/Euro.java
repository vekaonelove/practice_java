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

    public Euro mul(double k, RoundMethod roundMethod, int d) {
        return new Euro(roundMethod.round(value * k,  d));
    }

    public Euro round(RoundMethod roundMethod, int d){
        return new Euro(roundMethod.round(value, d));
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
        return this.value - euro.value;
    }
}