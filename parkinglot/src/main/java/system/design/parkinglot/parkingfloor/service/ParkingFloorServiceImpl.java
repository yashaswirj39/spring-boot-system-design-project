package system.design.parkinglot.parkingfloor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.design.parkinglot.parkingfloor.entity.ParkingFloor;
import system.design.parkinglot.parkingfloor.dao.ParkingLotFloorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingFloorServiceImpl implements ParkingFloorService{

    private ParkingLotFloorRepository floorRepository;

    @Autowired
    public ParkingFloorServiceImpl(ParkingLotFloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    @Override
    public List<ParkingFloor> findAll() {
        return floorRepository.findAll();
    }

    @Override
    public ParkingFloor findById(int id) {
        Optional<ParkingFloor> optional = floorRepository.findById(id);

        ParkingFloor parkingFloor = null;
        if (optional.isPresent()) {
            parkingFloor = optional.get();
        } else {
            throw new RuntimeException("floor id not present: " + id);
        }

        return parkingFloor;
    }

    @Override
    public void save(ParkingFloor parkingFloor) {
        floorRepository.save(parkingFloor);
    }

    @Override
    public void deleteById(int id) {
        floorRepository.deleteById(id);
    }

    @Override
    public ParkingFloor findByFloorNumber(int id) {
        return floorRepository.findByFloorNumber(id);
    }
}