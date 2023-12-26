package conditions;

import com.gridnine.testing.Flight;

import java.util.ArrayList;
import java.util.List;

public class AndCondition implements FilterCondition {

    private final List<FilterCondition> conditions;

    public AndCondition(List<FilterCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> result = new ArrayList<>(flights);

        for (FilterCondition condition : conditions) {
            result = condition.filterFlights(result);
        }
        return result;

    }
}
