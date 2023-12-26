import com.gridnine.testing.Flight;
import conditions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterServiceImpl implements FilterService {

    public List<Flight> applyFilter(FilterBase filterBase, List <Flight> flights) {
        FilterCondition andCondition = new AndCondition(getConditions(filterBase));
        return andCondition.filterFlights(flights);
    }

    private List<FilterCondition> getConditions(FilterBase filterBase) {
        List<FilterCondition> conditions = new ArrayList<FilterCondition>();
        LocalDateTime departureSpecifiedTime = filterBase.getDepartureSpecifiedTime();
        LocalDateTime arrivalSpecifiedTime = filterBase.getArrivalSpecifiedTime();

        if (filterBase.isArrivalBeforeDeparture()) {
            conditions.add(new ArrivalBeforeDeparture());
        }

        if (departureSpecifiedTime != null) {
            if (filterBase.isDepartureBeforeSpecifiedTime()) {
                conditions.add(new DepartureBeforeSpecifiedTime(departureSpecifiedTime));
            }
            if (filterBase.isDepartureAfterSpecifiedTime()) {
                conditions.add(new DepartureAfterSpecifiedTime(departureSpecifiedTime));
            }
        }

        if (arrivalSpecifiedTime != null) {
            if (filterBase.isArrivalBeforeSpecifiedTime()) {
                conditions.add(new ArrivalBeforeSpecifiedTime(arrivalSpecifiedTime));
            }
            if (filterBase.isArrivalAfterSpecifiedTime()) {
                conditions.add(new ArrivalAfterSpecifiedTime(arrivalSpecifiedTime));
            }
        }

        if (filterBase.getDesiredGroundTime() != null){
            conditions.add(new TotalGroundTimeExceedingDesired(filterBase.getDesiredGroundTime()));
        }

        if (filterBase.getDesiredTransfersNumber() != null){
            conditions.add(new TransfersNumberExceedingDesired(filterBase.getDesiredTransfersNumber()));
        }

        return conditions;
    }
}