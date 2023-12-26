import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        printFlights("Исходный набор перелетов", flightList);

        FilterService filterArrivalBeforeDeparture = new FilterServiceImpl();
        filterArrivalBeforeDeparture.addCondition("arrivalBeforeDeparture");
        printFlights("Исключены перелеты с приземлением ранее вылета",
                filterArrivalBeforeDeparture.applyFilter(flightList));

        FilterService filterDepartureBeforeNow = new FilterServiceImpl();
        filterDepartureBeforeNow.addCondition("departureBeforeSpecifiedTime", LocalDateTime.now());
        printFlights("Исключены перелеты с вылетом ранее текущего времени",
                filterDepartureBeforeNow.applyFilter(flightList));

        FilterService filterTotalGroundTimeExceedingTwoHours = new FilterServiceImpl();
        filterTotalGroundTimeExceedingTwoHours.addCondition("groundTime", Duration.ofHours(2));
        printFlights("Исключены перелеты с общим временем на земле более 2 часов",
                filterTotalGroundTimeExceedingTwoHours.applyFilter(flightList));

        // Additional check
        FilterService filterAnd = new FilterServiceImpl();
        filterAnd.addCondition("departureBeforeSpecifiedTime", LocalDateTime.now());
        filterAnd.addCondition("groundTime", Duration.ofHours(2));
        printFlights("Исключены перелеты с вылетом ранее текущего времени И общим временем на земле более 2 часов",
                filterAnd.applyFilter(flightList));
    }

    private static void printFlights(String message, List<Flight> flights) {
        System.out.println(message);
        for (Flight flight : flights) {
            System.out.println(flight);
        }
        System.out.println();

    }

}