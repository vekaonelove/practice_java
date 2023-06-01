package entity;

public abstract class AbstractPriceable implements Priceable{
    private final String name;

    protected AbstractPriceable(String name) {
        this.name = name;
    }

    protected AbstractPriceable() {
        this.name = null;
    }

    public String getName() {
        return name;
    }

    protected abstract String fieldsToString();

    public String toString(){
        return name + ";" + fieldsToString() + ";" + getPrice();
    }
}
