import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;
import conditions.*;
import sorter.FlightSorter;
import sorter.FlightSorterImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flightList = FlightBuilder.createFlights();

        FilterCondition arrivalBeforeDeparture = new ArrivalBeforeDeparture();
        FilterCondition departureBeforeNow = new DepartureBeforeSpecifiedTime(LocalDateTime.now());
        FilterCondition totalGroundTimeExceedingTwoHours = new TotalGroundTimeExceedingDesired(Duration.ofHours(2));

        System.out.println("Исходный набор перелетов");
        for (Flight flight : flightList) {
            System.out.println(flight);
        }
        System.out.println();
        System.out.println("Исключены перелеты с приземлением ранее вылета");
        for (Flight flight : arrivalBeforeDeparture.filterFlights(flightList)) {
            System.out.println(flight);
        }
        System.out.println();
        System.out.println("Исключены перелеты с вылетом ранее текущего времени");
        for (Flight flight : departureBeforeNow.filterFlights(flightList)) {
            System.out.println(flight);
        }
        System.out.println();
        System.out.println("Исключены перелеты с общим временем на земле более 2 часов");
        for (Flight flight : totalGroundTimeExceedingTwoHours.filterFlights(flightList)) {
            System.out.println(flight); //Additional sorting is not needed, because it occurs in the filtering method
        }

        FilterBuilder filterBuilder = new FilterBuilderImpl();

        FilterBase filterArrivalBeforeDeparture =
                filterBuilder.setArrivalBeforeDeparture(true).build();
        FilterBase filterDepartureBeforeNow =
                filterBuilder.setDepartureBeforeSpecifiedTime(true)
                        .setDepartureSpecifiedTime(LocalDateTime.now())
                        .build();
        FilterBase filterTotalGroundTimeExceedingTwoHours =
                filterBuilder.setDesiredGroundTime(Duration.ofHours(2)).build();

        printFlights("Исключены перелеты с приземлением ранее вылета",
                filterArrivalBeforeDeparture, flightList);

        printFlights("Исключены перелеты с вылетом ранее текущего времени",
                filterDepartureBeforeNow, flightList);

        printFlights("Исключены перелеты с общим временем на земле более 2 часов",
                filterTotalGroundTimeExceedingTwoHours,flightList);


        // Additional checks
        List<FilterCondition> conditions = new ArrayList<>();
        conditions.add(departureBeforeNow);
        conditions.add(totalGroundTimeExceedingTwoHours);
        FilterCondition andFilter = new AndCondition(conditions);

        System.out.println();
        System.out.println("Исключены перелеты с вылетом ранее текущего времени И общим временем на земле более 2 часов");
        for (Flight flight : andFilter.filterFlights(flightList)) {
            System.out.println(flight);
        }
        System.out.println();



    }

    private static void printFlights(String message, FilterBase filterBase, List<Flight> flights) {
        FilterService filterService = new FilterServiceImpl();
        System.out.println(message);
        for (Flight flight : filterService.applyFilter(filterBase, flights)) {
            System.out.println(flight);
        }
        System.out.println();

    }

}