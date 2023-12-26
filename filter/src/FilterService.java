import com.gridnine.testing.Flight;

import java.util.List;

public interface FilterService {
    void addCondition(String methodName, Object... parameters);

    List<Flight> applyFilter(List<Flight> flights);

}
