package conditions;

import com.gridnine.testing.Flight;

import java.util.List;

public class WithoutCondition implements FilterCondition {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights;
    }
}
