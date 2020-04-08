package system.design.parkinglot.parkingspot.service;
import system.design.parkinglot.parkingspot.entity.ParkingSlot;

import java.util.List;

public interface ParkingSlotService {
    public List<ParkingSlot> findAll();
    public ParkingSlot findById(int id);
    public void save(ParkingSlot parkingFloor);
    public void deleteById(int id);
    public ParkingSlot findByParkingSpotId(int id);
    public List<ParkingSlot> findAllById(Iterable<Integer> id);
    public List<ParkingSlot> findAllByParkingFloorId(int id);
    public void setSlotInfoBuId(int parkingSpotId, int parkingFloorId, String parkingType, String vehicleType, int availableSpotCount, char isVaccant, int id);
}
