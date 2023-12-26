import conditions.FilterCondition;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterBase {

    /**
     * When arrivalBeforeDeparture == true,
     * flights with an arrival date earlier than the departure date are excluded
     */
    private boolean arrivalBeforeDeparture = false;

    /**
     * When departureBeforeSpecifiedTime == true,
     * flights with departure time earlier than the specified time are excluded
     */
    private boolean departureBeforeSpecifiedTime = false;
    ;
    LocalDateTime departureSpecifiedTime;

    /**
     * When departureAfterSpecifiedTime == true,
     * flights with departure time later than the specified time are excluded
     */
    private boolean departureAfterSpecifiedTime = false;

    /**
     * When arrivalBeforeSpecifiedTime == true,
     * flights with arrival time earlier than the specified time are excluded
     */
    private boolean arrivalBeforeSpecifiedTime = false;
    LocalDateTime arrivalSpecifiedTime;

    /**
     * When arrivalAfterSpecifiedTime == true,
     * flights with arrival time later than the specified time are excluded
     */
    private boolean arrivalAfterSpecifiedTime = false;

    private Duration desiredGroundTime;
    private Integer desiredTransfersNumber;

    public void setArrivalBeforeDeparture(boolean arrivalBeforeDeparture) {
        this.arrivalBeforeDeparture = arrivalBeforeDeparture;
    }

    public void setDepartureBeforeSpecifiedTime(boolean departureBeforeSpecifiedTime) {
        this.departureBeforeSpecifiedTime = departureBeforeSpecifiedTime;
    }

    public void setDepartureSpecifiedTime(LocalDateTime departureSpecifiedTime) {
        this.departureSpecifiedTime = departureSpecifiedTime;
    }

    public void setDepartureAfterSpecifiedTime(boolean departureAfterSpecifiedTime) {
        this.departureAfterSpecifiedTime = departureAfterSpecifiedTime;
    }

    public void setArrivalBeforeSpecifiedTime(boolean arrivalBeforeSpecifiedTime) {
        this.arrivalBeforeSpecifiedTime = arrivalBeforeSpecifiedTime;
    }

    public void setArrivalSpecifiedTime(LocalDateTime arrivalSpecifiedTime) {
        this.arrivalSpecifiedTime = arrivalSpecifiedTime;
    }

    public void setArrivalAfterSpecifiedTime(boolean arrivalAfterSpecifiedTime) {
        this.arrivalAfterSpecifiedTime = arrivalAfterSpecifiedTime;
    }

    public void setDesiredGroundTime(Duration desiredGroundTime) {
        this.desiredGroundTime = desiredGroundTime;
    }

    public void setDesiredTransfersNumber(Integer desiredTransfersNumber) {
        this.desiredTransfersNumber = desiredTransfersNumber;
    }

    public boolean isArrivalBeforeDeparture() {
        return arrivalBeforeDeparture;
    }

    public boolean isDepartureBeforeSpecifiedTime() {
        return departureBeforeSpecifiedTime;
    }

    public LocalDateTime getDepartureSpecifiedTime() {
        return departureSpecifiedTime;
    }

    public boolean isDepartureAfterSpecifiedTime() {
        return departureAfterSpecifiedTime;
    }

    public boolean isArrivalBeforeSpecifiedTime() {
        return arrivalBeforeSpecifiedTime;
    }

    public LocalDateTime getArrivalSpecifiedTime() {
        return arrivalSpecifiedTime;
    }

    public boolean isArrivalAfterSpecifiedTime() {
        return arrivalAfterSpecifiedTime;
    }

    public Duration getDesiredGroundTime() {
        return desiredGroundTime;
    }

    public Integer getDesiredTransfersNumber() {
        return desiredTransfersNumber;
    }

}
