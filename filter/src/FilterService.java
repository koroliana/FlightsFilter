import com.gridnine.testing.Flight;

import java.util.List;

public interface FilterService {

    public List<Flight> applyFilter(FilterBase filterBase, List <Flight> flights);

}
