package parkingLot.repository;

import org.jetbrains.annotations.NotNull;
import parkingLot.models.Bill;
import ticTacToe.exception.BillNotFoundException;

import java.util.HashMap;

public class BillRepository {
    private final HashMap<Integer, Bill> billMap;

    public BillRepository() {
        this.billMap = new HashMap<>();
    }

    public Bill get(int billId) throws BillNotFoundException {
        Bill bill = billMap.get(billId);
        if (bill == null) throw new BillNotFoundException("Bill not found for id: " + billId);
        return bill;
    }

    public Bill put(@NotNull Bill bill) {
        billMap.put(bill.getId(), bill);
        return bill;
    }
}
