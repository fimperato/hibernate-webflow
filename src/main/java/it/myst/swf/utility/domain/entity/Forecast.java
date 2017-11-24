package it.myst.swf.utility.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HBN_FORECAST")
public class Forecast implements Serializable {
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private BigDecimal value;
    
    @Column(name="START_DATE")
    private Date startDate;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "PRODUCT")
    @JoinColumn(name="PRODUCT", insertable=false, updatable=false)
    private Product product;
    
    public Forecast() {
		super();
	}

    public Forecast(String name, String description, BigDecimal value, Product product) {
		super();
		this.name = name;
		this.description = description;
		this.value = value;
		this.product = product;
	}
    
	public Forecast(Product product) {
		super();
		this.name = "forecast_for_"+product.getName();
		this.product = product;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_HBN_FORECAST_SEQ")
    @SequenceGenerator(name = "id_HBN_FORECAST_SEQ", sequenceName ="HBN_FORECAST_SEQ")
    public Long getId() {
    	return id;
    }

    public void setId(Long id) {
    	this.id = id;
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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

    public Product getProduct() {
		return product;
    }

    public void setProduct(Product product) {
    	this.product = product;
    }
    
	@Override
    public String toString() {
		return "Forecast (" + name + ", " + description + ", " + value + ")";
    }
}
