package parkingLot.models;

import parkingLot.models.constants.VehicleType;

public class Vehicle extends BaseModel {
    private static int id = 0;
    private String number;
    private String name;
    private String color;
    private VehicleType vehicleType;

    public Vehicle(String number, String name, String color, VehicleType vehicleType) {
        super(++id);
        this.number = number;
        this.name = name;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
