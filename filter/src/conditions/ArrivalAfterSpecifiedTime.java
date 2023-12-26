package conditions;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Excludes flights with arrival time later than the specified time
 */
public class ArrivalAfterSpecifiedTime implements FilterCondition {
    private final LocalDateTime specifiedTime;

    public ArrivalAfterSpecifiedTime(LocalDateTime specifiedTime) {
        this.specifiedTime = specifiedTime;
    }

    //Exclude flights with arrival time later than the specified time
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(specifiedTime))
                )
                .collect(Collectors.toList());
    }
}
