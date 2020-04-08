package system.design.parkinglot.auth.service;

import system.design.parkinglot.auth.Entity.AdminLogin;

import java.util.List;
import java.util.Optional;

public interface LoginService {
    public Optional<AdminLogin> findByUserId(String userId);
    public List<AdminLogin> findAll();
    public void save(AdminLogin login);
}
