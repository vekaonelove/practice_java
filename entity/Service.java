package entity;

public class Service extends AbstractPriceable{
    private String name;
    private Euro totalCost;
    private int numberOfUsers;

    public Service(String name, String name1, Euro totalCost, int numberOfUsers) {
        super(name);
        this.name = name1;
        this.totalCost = totalCost;
        this.numberOfUsers = numberOfUsers;
    }

    public Service(String name, Euro totalCost, int numberOfUsers) {
        this.name = name;
        this.totalCost = totalCost;
        this.numberOfUsers = numberOfUsers;
    }

    public Service() {
        this.name = null;
        this.totalCost = null;
        this.numberOfUsers = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Euro getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Euro totalCost) {
        this.totalCost = totalCost;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }
    public Euro getPrice() {
        return totalCost.mul(1.0 / numberOfUsers, RoundMethod.CEIL, 0);
    }
    @Override
    protected String fieldsToString() {
        return totalCost.toString();
    }
}
