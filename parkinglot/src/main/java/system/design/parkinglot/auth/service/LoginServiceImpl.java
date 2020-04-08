package system.design.parkinglot.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.design.parkinglot.auth.Entity.AdminLogin;
import system.design.parkinglot.auth.dao.LoginAuthRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private LoginAuthRepository loginAuthRepository;

    @Autowired
    public LoginServiceImpl(LoginAuthRepository loginAuthRepository) {
        this.loginAuthRepository = loginAuthRepository;
    }

    @Override
    public Optional<AdminLogin> findByUserId(String userId) {
        return loginAuthRepository.findByUserId(userId);
    }

    @Override
    public List<AdminLogin> findAll() {
        return loginAuthRepository.findAll();
    }

    @Override
    public void save(AdminLogin login) {
        loginAuthRepository.save(login);
    }
}
