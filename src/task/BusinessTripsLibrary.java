package task;

public class BusinessTripsLibrary {
    BusinessTrip[] businessTrips;

    public BusinessTripsLibrary(BusinessTrip[] businessTrips) {
        this.businessTrips = businessTrips;
    }

    public void print(BusinessTrip businessTrip) {
        if (businessTrip != null) {
            System.out.println(businessTrip.toString());
        } else {
            System.out.println("empty");
        }
    }

    public void print() {
        for (BusinessTrip businessTrip : businessTrips) {
            print(businessTrip);
        }
    }

    public void show(BusinessTrip businessTrip) {
        if (businessTrip != null) {
            System.out.println(businessTrip.show() + '\n');
        } else {
            System.out.println("empty\n");
        }
    }

    public void show() {
        for (BusinessTrip businessTrip: businessTrips) {
            show(businessTrip);
        }
    }

    public BusinessTrip getBusinessTripWithMostExpenses() {
        int maxExpensesIndex = 0;
        double maxExpenses = 0;

        for (int i = 0; i < businessTrips.length; i++) {
            if (businessTrips[i] != null && businessTrips[i].getTotalExpensesInCents() > maxExpenses) {
                maxExpensesIndex = i;
                maxExpenses = businessTrips[i].getTotalExpensesInCents();
            }
        }

        return businessTrips[maxExpensesIndex];
    }

    public BusinessTrip[] getBusinessTrips() {
        return businessTrips;
    }
}
