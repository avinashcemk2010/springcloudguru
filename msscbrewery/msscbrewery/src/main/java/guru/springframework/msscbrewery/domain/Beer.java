package guru.springframework.msscbrewery.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Beer {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
	private UUID io;
	
	@Version
	private Long version;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;
	
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	private String beerName;
	private String beerStyle;
	
	@Column(unique = true)
	private Long upc;
	private BigDecimal price;
	
	private Integer minOnHand;
	private Integer quantityToBrew;
	
	public Beer() {}

	public Beer(UUID io, Long version, Timestamp createdDate, Timestamp lastModifiedDate, String beerName,
			String beerStyle, Long upc, BigDecimal price, Integer minOnHand, Integer quantityToBrew) {
		super();
		this.io = io;
		this.version = version;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.beerName = beerName;
		this.beerStyle = beerStyle;
		this.upc = upc;
		this.price = price;
		this.minOnHand = minOnHand;
		this.quantityToBrew = quantityToBrew;
	}

	public UUID getIo() {
		return io;
	}

	public void setIo(UUID io) {
		this.io = io;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	public String getBeerStyle() {
		return beerStyle;
	}

	public void setBeerStyle(String beerStyle) {
		this.beerStyle = beerStyle;
	}

	public Long getUpc() {
		return upc;
	}

	public void setUpc(Long upc) {
		this.upc = upc;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getMinOnHand() {
		return minOnHand;
	}

	public void setMinOnHand(Integer minOnHand) {
		this.minOnHand = minOnHand;
	}

	public Integer getQuantityToBrew() {
		return quantityToBrew;
	}

	public void setQuantityToBrew(Integer quantityToBrew) {
		this.quantityToBrew = quantityToBrew;
	}

	@Override
	public String toString() {
		return "Beer [io=" + io + ", version=" + version + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", beerName=" + beerName + ", beerStyle=" + beerStyle + ", upc=" + upc + ", price="
				+ price + ", minOnHand=" + minOnHand + ", quantityToBrew=" + quantityToBrew + "]";
	}
	
}
