package system.design.parkinglot.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import system.design.parkinglot.auth.Entity.AdminRegisteration;

public interface RegisterationAuthRepository extends JpaRepository<AdminRegisteration, String> {
}
