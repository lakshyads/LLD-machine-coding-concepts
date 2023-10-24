package parkingLot.service.strategy;

import parkingLot.models.Gate;
import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSlot;
import parkingLot.models.constants.*;
import parkingLot.repository.GateRepository;
import parkingLot.repository.ParkingFloorRepository;
import parkingLot.repository.ParkingLotRepository;
import parkingLot.repository.ParkingSlotRepository;
import parkingLot.service.strategy.billCalculationStrategy.BillCalculationStrategies;
import parkingLot.service.strategy.billCalculationStrategy.BillCalculationStrategyFactory;
import parkingLot.service.strategy.slotAllocationStrategy.SlotAllocationStrategies;
import parkingLot.service.strategy.slotAllocationStrategy.SlotAllocationStrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitServiceImpl implements IInitService {
    private final ParkingLotRepository parkingLotRepository;
    private final ParkingFloorRepository parkingFloorRepository;
    private final ParkingSlotRepository parkingSlotRepository;

    private final GateRepository gateRepository;

    public InitServiceImpl(ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, ParkingSlotRepository parkingSlotRepository, GateRepository gateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.gateRepository = gateRepository;
    }

    @Override
    public void init() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.setName("Parking Lot 1");
        parkingLot.setAddress("HYD");
        parkingLot.setParkingLotStatus(Status.OPEN);
        parkingLot.setSupportedVehicleTypes(new ArrayList<>(Arrays.asList(
                VehicleType.BIKE, VehicleType.CAR
        )));
        parkingLot.setSlotAllocationStrategy(
                SlotAllocationStrategyFactory.getSlotAllocationStrategy(
                        SlotAllocationStrategies.NEAREST_SLOT_ALLOCATION_STRATEGY
                ));
        parkingLot.setBillCalculationStrategy(
                BillCalculationStrategyFactory.getBillCalculationStrategy(
                        BillCalculationStrategies.LOW_BILL_CALCULATION
                ));

        // init 10 floors
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ParkingFloor parkingFloor = new ParkingFloor(i);
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingFloorStatus(Status.OPEN);

            // init slots for floor
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                ParkingSlot slot = new ParkingSlot(i * 100 + j);
                slot.setSlotNumber(i * 100 + j);
                slot.setParkingSlotStatus(ParkingSlotStatus.EMPTY);
                if (j % 2 == 0)
                    slot.setSupportedVehicleType(VehicleType.CAR);
                else slot.setSupportedVehicleType(VehicleType.BIKE);
                parkingSlots.add(slot);
                parkingSlotRepository.put(slot);
            }
            parkingFloor.setParkingSlots(parkingSlots);

            // init gates for floor

            Gate entryGate = new Gate(i * 10 + 1);
            entryGate.setGateNumber(i * 10 + 1);
            entryGate.setFloorNumber(i);
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperator("Rahul");

            Gate exitGate = new Gate(i * 10 + 2);
            exitGate.setGateNumber(i * 10 + 2);
            exitGate.setFloorNumber(i);
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperator("Ram");

            List<Gate> gates = new ArrayList<>();
            gates.add(entryGate);
            gates.add(exitGate);
            parkingFloor.setGates(gates);
            gateRepository.put(entryGate);
            gateRepository.put(exitGate);

            //
            parkingFloors.add(parkingFloor);
            parkingFloorRepository.put(parkingFloor);
        }

        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.put(parkingLot);
    }
}
