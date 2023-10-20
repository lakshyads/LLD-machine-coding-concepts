package parkingLot.repository;

import org.jetbrains.annotations.NotNull;
import parkingLot.exception.GateNotFoundException;
import parkingLot.models.Gate;

import java.util.HashMap;

public class GateRepository {
    private final HashMap<Integer, Gate> gateMap;

    public GateRepository() {
        this.gateMap = new HashMap<>();
    }

    public Gate get(int gateId) throws GateNotFoundException {
        Gate gate = gateMap.get(gateId);
        if (gate == null) throw new GateNotFoundException("Gate not found for id: " + gateId);
        return gate;
    }

    public Gate put(@NotNull Gate gate) {
        gateMap.put(gate.getId(), gate);
        return gate;
    }
}
