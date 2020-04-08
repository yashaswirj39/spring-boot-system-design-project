package system.design.parkinglot.parkingfloor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import system.design.parkinglot.parkingfloor.entity.ParkingFloor;
import system.design.parkinglot.parkingfloor.service.ParkingFloorService;

import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private ParkingFloorService service;

    @Autowired
    public AdminController(ParkingFloorService service) {
        this.service = service;
    }

    @GetMapping("/showFloors")
    public String showFloor(Model model) {
        model.addAttribute("floors", service.findAll());
        return "parkinglot/list-floors";
    }

    @GetMapping("/showFormToAddFloor")
    public String showFormToAddFloor(Model model) {
        ParkingFloor pf = new ParkingFloor();
        model.addAttribute("parkingFloor", pf);
        return "parkinglot/add-floor";
    }

    @PostMapping("/saveFloor")
    public String saveFloor(@ModelAttribute("parkingFloor") ParkingFloor parkingFloor) {
        ParkingFloor pf = service.findByFloorNumber(parkingFloor.getFloorNumber());
        if (Objects.isNull(pf)) {
            service.save(parkingFloor);
        } else {
            throw new RuntimeException("Floor Number Already Exists");
        }
        return "redirect:/admin/showFloors";
    }
}
