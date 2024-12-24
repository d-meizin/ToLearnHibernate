package meizin.ltd.ToLearnHibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "products_copy")
public class Product {

    @Id
    @Column(name = "product_id")
    private Short productId;

    @Column(name = "product_name", length = 40)
    private String productName;

    @Column(name = "quantity_per_unit", length = 20)
    private String quantityPerUnit;

    @Column(name = "unit_price")
    private Float unitPrice;

    // Getters and Setters
    public Short getProductId() {
        return productId;
    }

    public void setProductId(Short productId) {
        this.productId = productId;
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
