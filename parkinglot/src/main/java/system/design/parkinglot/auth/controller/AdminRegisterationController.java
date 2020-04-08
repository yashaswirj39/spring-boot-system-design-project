package system.design.parkinglot.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import system.design.parkinglot.auth.Entity.AdminLogin;
import system.design.parkinglot.auth.Entity.AdminRegisteration;
import system.design.parkinglot.auth.service.LoginService;

@Controller
@RequestMapping("/register")
public class AdminRegisterationController {

    private LoginService service;

    @Autowired
    public AdminRegisterationController(LoginService service) {
        this.service = service;
    }

    @GetMapping("/showRegisterForm")
    public String showRegisterForm(Model model) {
        AdminRegisteration registeration = new AdminRegisteration();

        model.addAttribute("registeration", registeration);

        return "auth/register/register-form";
    }

    @GetMapping("/validate")
    public String validateUser(@ModelAttribute("registeration") AdminRegisteration adminRegisteration) {

        //Code for Authenticating admin user

        System.out.println("admin login: " + adminRegisteration);

        return "redirect:/user/admin/login";
    }
}