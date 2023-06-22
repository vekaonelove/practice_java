package task;

public class Runner {
    public static void main(String[] args) {
        System.out.println("------------1-----------");
        BusinessTrip[] businessTrips = new BusinessTrip[]{
                new BusinessTrip("John Ivanov", 4551, 7),
                new BusinessTrip("Peter Smirnov", 20049, 30),
                null,
                new BusinessTrip( "Irina Shayk", 1563, 9),
                new BusinessTrip( "Bella Hadid", 1567893, 95),
                new BusinessTrip(),
        };

        System.out.println("\n------------2-----------");
        System.out.println("Show method: ");
        for (BusinessTrip trip: businessTrips) {
            if (trip != null) {
                System.out.println(trip.show() + '\n');
            } else {
                System.out.println("Empty object");
            }
        }

        System.out.println("Business trip with max cost: ");
        int maxExpenses = 0;
        BusinessTrip mostExpensiveTrip = null;

        for (BusinessTrip trip: businessTrips) {
            if (trip != null && trip.getTotalExpensesInCents() > maxExpenses) {
                mostExpensiveTrip = trip;
                maxExpenses = trip.getTotalExpensesInCents();
            }
        }
        System.out.println(mostExpensiveTrip);

        System.out.println("\n------------3-----------");
        System.out.println("\nUpdating transportationExpenses: ");
        int lastIndex = businessTrips.length - 1;
        businessTrips[lastIndex].setTransportationExpenses(5000);
        System.out.println(businessTrips[lastIndex].show());

        System.out.println("\n------------4-----------");
        System.out.println("\nDuration=" + (businessTrips[0].getDays() + businessTrips[1].getDays()));

        System.out.println("\n------------5-----------");
        System.out.println("\ntoString method: ");
        for (BusinessTrip trip: businessTrips) {
            System.out.println(trip);
        }
    }
}
