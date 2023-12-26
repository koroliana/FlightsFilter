package conditions;

import com.gridnine.testing.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDeparture implements FilterCondition{

    //Exclude flights with an arrival date earlier than the departure date
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isBefore(segment.getArrivalDate())))
                .collect(Collectors.toList());
    }
}
