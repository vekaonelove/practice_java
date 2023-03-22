package practice;
import java.util.Objects;

public class BusinessTrip {
    private int dailyAllowance;
    private String account;
    private int transportationExpenses;
    private int days;

    public BusinessTrip(int dailyAllowance, String account, int transportationExpenses, int days) {
        this.dailyAllowance = dailyAllowance;
        this.account = account;
        this.transportationExpenses = transportationExpenses;
        this.days = days;
    }

    public BusinessTrip() {
        this.dailyAllowance = 1200;
        this.account = "Ivan Ivanov";
        this.transportationExpenses = 1000;
        this.days = 4;
    }

    public int getTotalExpensesInCents() {
        return transportationExpenses + dailyAllowance * days;
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
        return "dailyAllowance=" + getValueInEuro(dailyAllowance) + '\n' +
                "account='" + account + "'\n" +
                "transportationExpenses=" + getValueInEuro(transportationExpenses) + '\n' +
                "days=" + days + '\n' +
                "total=" + getTotalExpenses();
    }

    public double getDailyAllowance() {
        return dailyAllowance;
    }

    public void setDailyAllowance(int dailyAllowance) {
        this.dailyAllowance = dailyAllowance;
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

        if (Double.compare(that.dailyAllowance, dailyAllowance) != 0) return false;
        if (Double.compare(that.transportationExpenses, transportationExpenses) != 0) return false;
        if (days != that.days) return false;
        return Objects.equals(account, that.account);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(dailyAllowance);
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