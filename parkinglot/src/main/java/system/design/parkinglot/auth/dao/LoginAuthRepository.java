package system.design.parkinglot.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.design.parkinglot.auth.Entity.AdminLogin;

import java.util.Optional;

@Repository
public interface LoginAuthRepository extends JpaRepository<AdminLogin, String> {

    public Optional<AdminLogin> findByUserId(String userId);
}
