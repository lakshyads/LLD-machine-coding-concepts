package parkingLot.service.strategy.slotAllocationStrategy;

public class SlotAllocationStrategyFactory {
    public static ISlotAllocationStrategy getSlotAllocationStrategy(SlotAllocationStrategies slotAllocationStrategy) {
        // TODO: convert to switch case after adding more slot allocation strategies
        if (slotAllocationStrategy.equals(SlotAllocationStrategies.NEAREST_SLOT_ALLOCATION_STRATEGY))
            return new NearestSlotAllocationStrategy();
        return null;
    }
}
