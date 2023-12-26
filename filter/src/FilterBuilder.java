import java.time.Duration;
import java.time.LocalDateTime;

public interface FilterBuilder {
    FilterBuilder setArrivalBeforeDeparture(boolean arrivalBeforeDeparture);
    FilterBuilder setDepartureBeforeSpecifiedTime(boolean departureBeforeSpecifiedTime);
    FilterBuilder setDepartureSpecifiedTime(LocalDateTime DepartureSpecifiedTime);
    FilterBuilder setDepartureAfterSpecifiedTime(boolean departureAfterSpecifiedTime);
    FilterBuilder setArrivalBeforeSpecifiedTime(boolean arrivalBeforeSpecifiedTime);
    FilterBuilder setArrivalSpecifiedTime(LocalDateTime arrivalSpecifiedTime);
    FilterBuilder setArrivalAfterSpecifiedTime(boolean arrivalAfterSpecifiedTime);
    FilterBuilder setDesiredGroundTime(Duration desiredGroundTime);
    FilterBuilder setDesiredTransfersNumber(Integer desiredTransfersNumber);
    FilterBase build();
}
