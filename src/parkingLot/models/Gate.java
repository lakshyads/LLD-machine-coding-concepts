package parkingLot.models;

import parkingLot.models.constants.GateStatus;
import parkingLot.models.constants.GateType;

public class Gate extends BaseModel {
    private String operator; // TODO: convert to Operator object
    private GateType gateType;
    private int gateNumber;
    private GateStatus gateStatus;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
