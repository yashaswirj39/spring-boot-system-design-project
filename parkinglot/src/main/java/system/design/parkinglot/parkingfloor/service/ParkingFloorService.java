package system.design.parkinglot.parkingfloor.service;

import system.design.parkinglot.parkingfloor.entity.ParkingFloor;

import java.util.List;

public interface ParkingFloorService {
    public List<ParkingFloor> findAll();
    public ParkingFloor findById(int id);
    public void save(ParkingFloor parkingFloor);
    public void deleteById(int id);
    public ParkingFloor findByFloorNumber(int id);
}
