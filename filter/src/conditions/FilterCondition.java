package conditions;

import java.util.List;
import com.gridnine.testing.Flight;

public interface FilterCondition {

        //Filter flights according to the conditions
        List<Flight> filterFlights(List<Flight> flights);

}