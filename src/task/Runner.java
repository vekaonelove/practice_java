package task;
import task.BusinessTrip;
import task.BusinessTripsLibrary;
public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] businessTrips = new BusinessTrip[]{
                new BusinessTrip("John Ivanov", 4551, 7),
                new BusinessTrip("Peter Smirnov", 20049, 30),
                null,
                new BusinessTrip( "Irina Shayk", 1563, 9),
                new BusinessTrip( "Bella Hadid", 1567893, 95),
                new BusinessTrip(),
        };

        BusinessTripsLibrary businessTripsLibrary = new BusinessTripsLibrary(businessTrips);

        System.out.println("Show method: ");
        businessTripsLibrary.show();
        BusinessTrip businessTripWithMaxCost = businessTripsLibrary.getBusinessTripWithMostExpenses();

        System.out.println("Business trip with max cost: ");
        System.out.println(businessTripWithMaxCost.show());

        System.out.println("\nUpdating transportationExpenses: ");
        businessTrips[4].setTransportationExpenses(5000);
        System.out.println(businessTripsLibrary.getBusinessTrips()[4].show());

        System.out.println("\nDuration=" + businessTrips[0].getDays());
        System.out.println("Duration="+ businessTrips[1].getDays());

        System.out.println("\nPrint method: ");
        businessTripsLibrary.print();


    }
}
