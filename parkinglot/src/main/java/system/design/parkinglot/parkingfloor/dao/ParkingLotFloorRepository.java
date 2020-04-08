package system.design.parkinglot.parkingfloor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import system.design.parkinglot.parkingfloor.entity.ParkingFloor;

public interface ParkingLotFloorRepository extends JpaRepository<ParkingFloor, Integer> {
    public ParkingFloor findByFloorNumber(int id);
}
