package parkingLot.service.strategy.billCalculationStrategy;

public class BillCalculationStrategyFactory {
    public static IBillCalculationStrategy getBillCalculationStrategy(BillCalculationStrategies billCalculationStrategies) {
        // TODO: convert to switch case after implementing other bill calculation strategies
        if (billCalculationStrategies.equals(BillCalculationStrategies.LOW_BILL_CALCULATION))
            return new LowBillCalculationStrategy();
        return null;
    }
}
