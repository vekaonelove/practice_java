package entity;

public class DiscountProduct extends Product{
    private Euro priceDiscount;

    public Euro getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(Euro priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public DiscountProduct(String name, Euro price, Euro priceDiscount) {
        super(name, price);
        this.priceDiscount = priceDiscount;
    }

    public DiscountProduct(Euro price, Euro priceDiscount) {
        super(price);
        this.priceDiscount = priceDiscount;
    }

    @Override
    public Euro getPrice() {
        return super.getPrice().subtract(priceDiscount);
    }

    @Override
    public String fieldsToString() {
        return getPrice() + ";" + priceDiscount;
    }
}
