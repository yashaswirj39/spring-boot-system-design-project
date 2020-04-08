package system.design.parkinglot.parkingfloor.entity;

import javax.persistence.*;

@Entity
@Table(name = "parking_floor")
public class ParkingFloor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "floor_number")
    private int floorNumber;

    public ParkingFloor() {
    }

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "ParkingFloor{" +
                "id=" + id +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
