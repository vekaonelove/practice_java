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
        this.account = "Ivan Ivanov";
        this.transportationExpenses = 1000;
        this.days = 4;
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
        String valueInEuro = String.valueOf(value / 100) + '.';
        if (String.valueOf(value % 100).length() == 2) {
            valueInEuro += String.valueOf(value % 100);
        } else {
            valueInEuro += (String.valueOf(value % 100) + '0');
        }

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

        if (transportationExpenses != that.transportationExpenses) return false;
        if (days != that.days) return false;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + transportationExpenses;
        result = 31 * result + days;
        return result;
    }

    @Override
    public String toString() {
        return  account + ';' + getValueInEuro(transportationExpenses) + ';' + days + ';' + getTotalExpenses();
    }
}