import entity.Euro;
import java.io.FileReader;
import java.util.*;
import java.io.FileNotFoundException;

public class Purchase {
    private String name;
    private Euro euro;
    private int numberOfUnits;

    public Purchase() {
        this.name = null;
        this.euro = new Euro();
        this.numberOfUnits = 0;
    }
    public Purchase(String name, Euro euro, int numberOfUnits) {
        this.name = name;
        this.euro = euro;
        this.numberOfUnits = numberOfUnits;
    }

    public Purchase(Scanner sc){
        this.name = sc.next();
        this.euro = new Euro(sc.nextInt());
        this.numberOfUnits = sc.nextInt();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Euro getEuro() {
        return euro;
    }

    public void setEuro(Euro euro) {
        this.euro = euro;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public Euro getCost(){
        Euro euroForCalculation = new Euro(euro);
        return euroForCalculation.multiply(numberOfUnits);
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%d;%s", getClass().getSimpleName(), name, euro, numberOfUnits, getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (numberOfUnits != purchase.numberOfUnits) return false;
        if (!Objects.equals(name, purchase.name)) return false;
        return Objects.equals(euro, purchase.euro);
    }


}
