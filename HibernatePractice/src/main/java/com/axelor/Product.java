package com.axelor;




import javax.persistence.*;

@Entity(name = "Product")
public class Product {

	@Id
    // @Basic
    private Integer id;

   // @Basic
    private String sku;

    //@Basic
    private String name;

    //@Basic
    @Column(name="NOTES")
    private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}
