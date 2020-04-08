package system.design.parkinglot.auth.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_registeration")
public class AdminRegisteration {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "email_id")
    private String email;

    @Column(name = "password")
    private String password;

    public AdminRegisteration() {
    }

    public AdminRegisteration(String userId, String contactNo, String address, String name, String age, String bloodGroup, String email, String password) {
        this.userId = userId;
        this.contactNo = contactNo;
        this.address = address;
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminRegisteration{" +
                "userId='" + userId + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
