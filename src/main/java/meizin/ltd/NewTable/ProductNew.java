package meizin.ltd.NewTable;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employhiber")
public class ProductNew {
	
	@Id
    @Column(name = "employee_id")
    private Short employeeId;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(name = "first_name", length = 10)
    private String firstName;
    
    @Column(name = "title", length = 30)
    private String title;

    @Column(name = "birth_date")
    private Date birthDate;

    // Getters and Setters
    public Short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Short employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
