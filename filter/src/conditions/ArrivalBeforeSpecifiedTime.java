package conditions;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Excludes flights with arrival time earlier than the specified time
 */
public class ArrivalBeforeSpecifiedTime implements FilterCondition {
    private final LocalDateTime specifiedTime;

    public ArrivalBeforeSpecifiedTime(LocalDateTime specifiedTime) {
        this.specifiedTime = specifiedTime;
    }

    //Exclude flights with arrival time earlier than the specified time
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isAfter(specifiedTime))
                )
                .collect(Collectors.toList());
    }
}
