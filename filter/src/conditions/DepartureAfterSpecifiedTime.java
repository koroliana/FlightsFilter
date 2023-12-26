package conditions;

import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureAfterSpecifiedTime implements FilterCondition{
    private final LocalDateTime specifiedTime;

    public DepartureAfterSpecifiedTime(LocalDateTime specifiedTime) {
        this.specifiedTime = specifiedTime;
    }

    //Exclude flights with departure time later than the specified time
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isBefore(specifiedTime))
                )
                .collect(Collectors.toList());
    }
}
