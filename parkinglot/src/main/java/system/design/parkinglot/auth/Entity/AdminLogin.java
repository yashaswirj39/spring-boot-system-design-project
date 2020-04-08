package system.design.parkinglot.auth.Entity;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class AdminLogin {

    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active")
    private int active;

    @Column(name = "roles")
    private String roles;


    public AdminLogin() {
    }

    public AdminLogin(String userId, String password, int active, String roles) {
        this.userId = userId;
        this.password = password;
        this.active = 1;
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "AdminLogin{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                '}';
    }
}