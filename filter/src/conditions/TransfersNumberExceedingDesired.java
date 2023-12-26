package conditions;

import com.gridnine.testing.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class TransfersNumberExceedingDesired implements FilterCondition {

    private final Integer desiredTransfersNumber;

    public TransfersNumberExceedingDesired(int desiredTransfersNumber) {

        this.desiredTransfersNumber = desiredTransfersNumber;
    }

    //Excludes flights with more transfers than the desired number
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight ->
                        (flight.getSegments()).size() <= desiredTransfersNumber)
                .collect(Collectors.toList());
    }
}
