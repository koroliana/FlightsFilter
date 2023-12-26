package conditions;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Excludes flights with departure time earlier than the specified time
 */
public class DepartureBeforeSpecifiedTime implements FilterCondition {
    private final LocalDateTime specifiedTime;

    public DepartureBeforeSpecifiedTime(LocalDateTime specifiedTime) {
        this.specifiedTime = specifiedTime;
    }

    //Exclude flights with departure time earlier than the specified time
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isAfter(specifiedTime))
                )
                .collect(Collectors.toList());
    }
}
