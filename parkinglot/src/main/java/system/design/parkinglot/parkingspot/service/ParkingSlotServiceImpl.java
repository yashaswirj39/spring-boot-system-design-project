package system.design.parkinglot.parkingspot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.design.parkinglot.parkingspot.dao.ParkingSlotRepository;
import system.design.parkinglot.parkingspot.entity.ParkingSlot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {

    private ParkingSlotRepository repository;

    @Autowired
    public ParkingSlotServiceImpl(ParkingSlotRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ParkingSlot> findAll() {
        return repository.findAll();
    }

    @Override
    public ParkingSlot findById(int id) {
        Optional<ParkingSlot> optional = repository.findById(id);
        ParkingSlot ps = null;
        if (optional.isPresent()) {
            ps = optional.get();
        } else {
            throw new RuntimeException("parking spot not present of ID: " + id);
        }
        return ps;
    }

    @Override
    public List<ParkingSlot> findAllById(Iterable<Integer> floorId) {
        return repository.findAllById(floorId);
    }

    @Override
    public List<ParkingSlot> findAllByParkingFloorId(int id) {
        return repository.findAllByParkingFloorId(id);
    }

    @Override
    public void setSlotInfoBuId(int parkingSpotId, int parkingFloorId, String parkingType, String vehicleType, int availableSpotCount, char isVaccant, int id) {

    }

    @Override
    public void save(ParkingSlot parkingSlot) {
        parkingSlot.setIsVaccant('N');
        repository.save(parkingSlot);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public ParkingSlot findByParkingSpotId(int id) {
        return repository.findByParkingSpotId(id);
    }
}
