package entity;

public class Product extends AbstractPriceable {
    private Euro price;

    public Product(String name, Euro price) {
        super(name);
        this.price = price;
    }

    public Product(Euro price) {
        this.price = price;
    }


    @Override
    public Euro getPrice() {
        return price;
    }

    public void setPrice(Euro price) {
        this.price = price;
    }

    public String fieldsToString(){
        return price.toString();
    }

}
