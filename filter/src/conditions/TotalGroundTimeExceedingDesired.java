package conditions;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import sorter.FlightSorter;
import sorter.FlightSorterImpl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TotalGroundTimeExceedingDesired implements FilterCondition {
    private final Duration desiredGroundTime;

    public TotalGroundTimeExceedingDesired(Duration desiredGroundTime) {
        this.desiredGroundTime = desiredGroundTime;
    }

    //Exclude flights with total time between flights exceeding desired duration
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight ->
                        calculateGroundTime(flight.getSegments()).compareTo(desiredGroundTime) < 0)
                .collect(Collectors.toList());
    }

    private Duration calculateGroundTime(List<Segment> segments) {
        FlightSorter flightSorter = new FlightSorterImpl();
        flightSorter.sortByDepartureDate(segments);
        Duration groundTime = Duration.ZERO;
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
            groundTime = groundTime.plus(Duration.between(arrival, nextDeparture));
        }
        return groundTime;
    }

}
