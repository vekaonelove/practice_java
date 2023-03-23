package task;
import java.util.Objects;

public class BusinessTrip {
    static final int DAILY_ALLOWANCE = 100;
    private String account;
    private int transportationExpenses;
    private int days;

    public BusinessTrip(String account, int transportationExpenses, int days) {
        this.account = account;
        this.transportationExpenses = transportationExpenses;
        this.days = days;
    }

    public BusinessTrip() {
        
    }

    public int getTotalExpensesInCents() {
        return transportationExpenses + DAILY_ALLOWANCE * days;
    }

    public String getTotalExpenses() {
        int totalExpensesInCents = getTotalExpensesInCents();
        String totalExpenses = getValueInEuro(totalExpensesInCents);
        return totalExpenses;
    }


    public String getValueInEuro(int value) {
        String valueInEuro = String.valueOf(value / 100) + '.' + String.valueOf(value % 100) +
                (-1) * (String.valueOf(value % 100).length()-2) * '0';
        return valueInEuro;
    }
    public String show() {
        return "dailyAllowance=" + DAILY_ALLOWANCE + "\n" +
                "account='" + account + "'\n" +
                "transportationExpenses=" + getValueInEuro(transportationExpenses) + '\n' +
                "days=" + days + '\n' +
                "total=" + getTotalExpenses();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getTransportationExpenses() {
        return transportationExpenses;
    }

    public void setTransportationExpenses(int transportationExpenses) {
        this.transportationExpenses = transportationExpenses;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusinessTrip that = (BusinessTrip) o;

        if (Double.compare(that.DAILY_ALLOWANCE, DAILY_ALLOWANCE) != 0) return false;
        if (Double.compare(that.transportationExpenses, transportationExpenses) != 0) return false;
        if (days != that.days) return false;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(DAILY_ALLOWANCE);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (account != null ? account.hashCode() : 0);
        temp = Double.doubleToLongBits(transportationExpenses);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + days;
        return result;
    }

    @Override
    public String toString() {
        return  account + ';' + getValueInEuro(transportationExpenses) + ';' + days + ';' + getTotalExpenses();
    }
}