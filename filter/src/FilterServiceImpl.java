import com.gridnine.testing.Flight;
import conditions.AndCondition;
import conditions.FilterCondition;

import java.util.ArrayList;
import java.util.List;

public class FilterServiceImpl implements FilterService {
    List<FilterCondition> conditions = new ArrayList<>();

    public void addCondition(String methodName, Object... parameters) {
        conditions.add(FilterConditionFactory
                .createFilterCondition(methodName, parameters));
    }

    public List<Flight> applyFilter(List<Flight> flights) {
        FilterCondition andCondition = new AndCondition(conditions);
        return andCondition.filterFlights(flights);
    }
}