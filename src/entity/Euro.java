package entity;

public class Euro {
    private int value;

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

    public Euro multiply(double x){
        value = (int) (value * x);
        return this;
    }

    @Override
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
