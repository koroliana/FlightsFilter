package sorter;

import com.gridnine.testing.Segment;

import java.util.Comparator;
import java.util.List;

public class FlightSorterImpl implements FlightSorter {

    // Sorting the sheet of segments by departure date
    public void sortByDepartureDate(List<Segment> segments) {
        segments.sort(Comparator.comparing(Segment::getDepartureDate));
    }
}
