import conditions.*;

import java.time.Duration;
import java.time.LocalDateTime;

public class FilterConditionFactory {
    public static FilterCondition createFilterCondition(String methodName, Object... parameters) {
        WithoutCondition withoutCondition = new WithoutCondition();
        String withoutConditionMessage = "Применено условие без фильтрации, возможно что-то пошло не так";
        try {
            switch (methodName) {
                case "arrivalBeforeDeparture":
                    return new ArrivalBeforeDeparture();
                case "arrivalAfterSpecifiedTime":
                    if (parameters.length == 1 && parameters[0] instanceof LocalDateTime) {
                        return new ArrivalAfterSpecifiedTime((LocalDateTime) parameters[0]);
                    }
                    break;
                case "arrivalBeforeSpecifiedTime":
                    if (parameters.length == 1 && parameters[0] instanceof LocalDateTime) {
                        return new ArrivalBeforeSpecifiedTime((LocalDateTime) parameters[0]);
                    }
                    break;
                case "departureBeforeSpecifiedTime":
                    if (parameters.length == 1 && parameters[0] instanceof LocalDateTime) {
                        return new DepartureBeforeSpecifiedTime((LocalDateTime) parameters[0]);
                    }
                    break;
                case "departureAfterSpecifiedTime":
                    if (parameters.length == 1 && parameters[0] instanceof LocalDateTime) {
                        return new DepartureAfterSpecifiedTime((LocalDateTime) parameters[0]);
                    }
                    break;
                case "groundTime":
                    if (parameters.length == 1 && parameters[0] instanceof Duration) {
                        return new TotalGroundTimeExceedingDesired((Duration) parameters[0]);
                    }
                    break;
                case "transfersNumber":
                    if (parameters.length == 1 && parameters[0] instanceof Integer) {
                        return new TransfersNumberExceedingDesired((Integer) parameters[0]);
                    }
                    break;
                default:
                    System.out.println(withoutConditionMessage);
                    return withoutCondition;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(withoutConditionMessage);
        return withoutCondition;
    }
}
