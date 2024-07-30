package recursion;

public class FinancialForecasting {

    
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        } else {
            return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
        }
    }
}
