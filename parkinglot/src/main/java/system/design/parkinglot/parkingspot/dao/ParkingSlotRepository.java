package system.design.parkinglot.parkingspot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import system.design.parkinglot.parkingspot.entity.ParkingSlot;

import java.util.List;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {
    public ParkingSlot findByParkingSpotId(int id);
    public List<ParkingSlot> findAllByParkingFloorId(int id);

    @Modifying
    @Query("update ParkingSlot p set p.parkingSpotId = ?1, p.parkingFloorId = ?2, p.parkingType = ?3, p.vehicleType = ?4, p.availableCount = ?5, p.isVaccant = ?6 where p.id = ?7")
    public void setSlotInfoBuId(int parkingSpotId, int parkingFloorId, String parkingType, String vehicleType, int availableSpotCount, char isVaccant, int id);
}
