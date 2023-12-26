package conditions;

import com.gridnine.testing.Flight;

import java.util.List;

public interface FilterCondition {

    //Filter flights according to the conditions
    List<Flight> filterFlights(List<Flight> flights);

}