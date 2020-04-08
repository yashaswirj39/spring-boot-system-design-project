package system.design.parkinglot.parkingspot.entity;

import javax.persistence.*;

@Entity
@Table(name = "parking_slot")
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "parking_spot_id")
    private int parkingSpotId;

    @Column(name = "parking_floor_id")
    private int parkingFloorId;

    @Column(name = "parking_type")
    private String parkingType;

    @Column(name = "is_vaccant")
    private char isVaccant;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "available_spot_cout")
    private int availableCount;

    public ParkingSlot() {
    }

    public ParkingSlot(int parkingSpotId, int parkingFloorId, String parkingType, char isVaccant) {
        this.parkingSpotId = parkingSpotId;
        this.parkingFloorId = parkingFloorId;
        this.parkingType = parkingType;
        this.isVaccant = isVaccant;
    }

    public ParkingSlot(int parkingSpotId, int parkingFloorId, String parkingType, char isVaccant, String vehicleType, int availableCount) {
        this.parkingSpotId = parkingSpotId;
        this.parkingFloorId = parkingFloorId;
        this.parkingType = parkingType;
        this.isVaccant = isVaccant;
        this.vehicleType = vehicleType;
        this.availableCount = availableCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public int getParkingFloorId() {
        return parkingFloorId;
    }

    public void setParkingFloorId(int parkingFloorId) {
        this.parkingFloorId = parkingFloorId;
    }

    public String getParkingType() {
        return parkingType;
    }

    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }

    public char getIsVaccant() {
        return isVaccant;
    }

    public void setIsVaccant(char isVaccant) {
        this.isVaccant = isVaccant;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id=" + id +
                ", parkingSpotId=" + parkingSpotId +
                ", parkingFloorId=" + parkingFloorId +
                ", parkingType='" + parkingType + '\'' +
                ", isVaccant=" + isVaccant +
                ", vehicleType='" + vehicleType + '\'' +
                ", availableCount=" + availableCount +
                '}';
    }
}