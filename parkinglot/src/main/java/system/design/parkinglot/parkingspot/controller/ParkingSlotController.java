package system.design.parkinglot.parkingspot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.design.parkinglot.parkingspot.entity.ParkingSlot;
import system.design.parkinglot.parkingspot.service.ParkingSlotService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/parkingslot")
public class ParkingSlotController {

    @Value("#{'${parking.type}'.split(',')}")
    private List<String> parkingType;

    private ParkingSlotService service;

    @Autowired
    public ParkingSlotController(ParkingSlotService service) {
        this.service = service;
    }

    @GetMapping("/listslots")
    public String listSpot(@RequestParam("floorId") int id, Model model) {
        List<ParkingSlot> ps = service.findAll();
        List<ParkingSlot> resultps = new ArrayList<>();
        for (ParkingSlot ps1: ps) {
            if (id==ps1.getParkingFloorId()) {
                //System.out.println("inside if:");
                //System.out.println("data in slot listing: " + ps1);
                resultps.add(ps1);
            } else {
                continue;
            }
        }
        //System.out.println("list of parking slot for id: " + id + " is: " + resultps);
        model.addAttribute("slotList", resultps);
        return "parkingslot/list-spots";
    }

    @GetMapping("/showFormToAddSlot")
    public String showFormToAddSpot(Model model) {
        ParkingSlot ps = new ParkingSlot();
        System.out.println("parking type: " + parkingType);
        model.addAttribute("slot", ps);
        model.addAttribute("parkingType", parkingType);
        return "parkingslot/add-slot";
    }

    @PostMapping("/saveslot")
    public String saveSlot(@ModelAttribute("slot") ParkingSlot parkingSlot) {
        System.out.println("parking slot data: " + parkingSlot);

        List<ParkingSlot> psList = service.findAllByParkingFloorId(parkingSlot.getParkingFloorId());

        if (!psList.isEmpty() || psList.size() > 0) {
            for (ParkingSlot ps : psList) {
                if (ps.getParkingSpotId() != parkingSlot.getParkingSpotId()) {


                    service.save(parkingSlot);
                } else {
                    System.out.println("inside else: " + parkingSlot);
                    service.setSlotInfoBuId(parkingSlot.getParkingSpotId(),
                            parkingSlot.getParkingFloorId(), parkingSlot.getParkingType(),
                            parkingSlot.getVehicleType(), parkingSlot.getAvailableCount(),
                            parkingSlot.getIsVaccant(), parkingSlot.getId());
                }
            }
        } else {
            service.save(parkingSlot);
        }

        return "redirect:/admin/showFloors";
    }

    @GetMapping("/showformforupdate")
    public String showFormForUpdate(@RequestParam("id") int id, Model model) {
        ParkingSlot ps = service.findById(id);
        model.addAttribute("slot", ps);
        model.addAttribute("parkingType", parkingType);
        return "parkingslot/add-slot";
    }

    @GetMapping("/delete")
    public String deleteslot(@RequestParam("id") int id) {
        service.deleteById(id);
        return "redirect:/admin/showFloors";
    }
}