package it.myst.swf.utility.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HBN_PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

    private String name;

    private String state;

    private BigDecimal amount;

//    private Set<Forecast> forecasts;
    
//    @OneToMany(cascade=CascadeType.ALL, mappedBy="product", orphanRemoval=true)
//    public Set<Forecast> getForecasts() { 
//    	return forecasts; 
//    }
//    
//    public void setForecasts(Set<Forecast> forecasts) {
//		this.forecasts = forecasts;
//	}

    public Product() {
		super();
	}
    
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_HBN_PRODUCT_SEQ")
    @SequenceGenerator(name = "id_HBN_PRODUCT_SEQ", sequenceName ="HBN_PRODUCT_SEQ")
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(precision = 6, scale = 2)
    public BigDecimal getAmount() {
    	return amount;
    }

    public void setAmount(BigDecimal amount) {
    	this.amount = amount;
    }

    public Forecast createForecast() {
    	return new Forecast(this);
    }

    @Override
    public String toString() {
	return "Product (" + this.name + ", " + this.state + ", " + this.amount + ")";
    }
}
