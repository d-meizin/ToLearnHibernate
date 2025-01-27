package meizin.ltd.NewTable;

import jakarta.persistence.*;

@Entity
@Table(name = "employhiber")
public class ProductNew {
	
	@Id
    @Column(name = "employee_id")
    private Short employeeId;

    @Column(name = "last_name", length = 20)
    private String productName;

    @Column(name = "first_name", length = 10)
    private String quantityPerUnit;

    @Column(name = "title", length = 30)
    private Float unitPrice;

    // Getters and Setters
    public Short getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Short employeeId) {
        this.employeeId = employeeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

}
