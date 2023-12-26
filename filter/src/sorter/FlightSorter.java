package sorter;

import com.gridnine.testing.Segment;

import java.util.List;

public interface FlightSorter {

    void sortByDepartureDate(List<Segment> segments);

}
