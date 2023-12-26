import java.time.Duration;
import java.time.LocalDateTime;

public class FilterBuilderImpl implements FilterBuilder{
    FilterBase filterBase = new FilterBase();

    @Override
    public FilterBuilder setArrivalBeforeDeparture(boolean arrivalBeforeDeparture) {
        filterBase.setArrivalBeforeDeparture(arrivalBeforeDeparture);
        return this;
    }

    @Override
    public FilterBuilder setDepartureBeforeSpecifiedTime(boolean departureBeforeSpecifiedTime) {
        filterBase.setDepartureBeforeSpecifiedTime(departureBeforeSpecifiedTime);
        return this;
    }

    @Override
    public FilterBuilder setDepartureSpecifiedTime(LocalDateTime departureSpecifiedTime) {
        filterBase.setDepartureSpecifiedTime(departureSpecifiedTime);
        return this;
    }

    @Override
    public FilterBuilder setDepartureAfterSpecifiedTime(boolean departureAfterSpecifiedTime) {
        filterBase.setDepartureAfterSpecifiedTime(departureAfterSpecifiedTime);
        return this;
    }

    @Override
    public FilterBuilder setArrivalBeforeSpecifiedTime(boolean arrivalBeforeSpecifiedTime) {
        filterBase.setArrivalBeforeSpecifiedTime(arrivalBeforeSpecifiedTime);
        return this;
    }

    @Override
    public FilterBuilder setArrivalSpecifiedTime(LocalDateTime arrivalSpecifiedTime) {
        filterBase.setArrivalSpecifiedTime(arrivalSpecifiedTime);
        return this;
    }

    @Override
    public FilterBuilder setArrivalAfterSpecifiedTime(boolean arrivalAfterSpecifiedTime) {
        filterBase.setArrivalAfterSpecifiedTime(arrivalAfterSpecifiedTime);
        return this;
    }

    @Override
    public FilterBuilder setDesiredGroundTime(Duration desiredGroundTime) {
        filterBase.setDesiredGroundTime(desiredGroundTime);
        return this;
    }

    @Override
    public FilterBuilder setDesiredTransfersNumber(Integer desiredTransfersNumber) {
        filterBase.setDesiredTransfersNumber(desiredTransfersNumber);
        return this;
    }

    @Override
    public FilterBase build() {
        return filterBase;
    }
}
