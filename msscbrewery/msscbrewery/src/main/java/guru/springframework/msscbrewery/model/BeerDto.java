package guru.springframework.msscbrewery.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BeerDto {
	
	@Null
	private UUID id;
	@Null
	private Integer version;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	@Null
	private OffsetDateTime createDate;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ", shape = JsonFormat.Shape.STRING)
	@Null
	private OffsetDateTime lastModifiedDate;
	@NotBlank
	private String beerName;
	@NotNull
	private BeerStyleEnum beerStyle;
	@Positive
	@NotNull
	private Long upc;
	private Integer quantityInHand;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull
	@Positive
	private BigDecimal price;
	
	public BeerDto() {}

	public BeerDto(UUID id, Integer version, OffsetDateTime createDate, OffsetDateTime lastModifiedDate,
			String beerName, BeerStyleEnum beerStyle, Long upc, Integer quantityInHand, BigDecimal price) {
		super();
		this.id = id;
		this.version = version;
		this.createDate = createDate;
		this.lastModifiedDate = lastModifiedDate;
		this.beerName = beerName;
		this.beerStyle = beerStyle;
		this.upc = upc;
		this.quantityInHand = quantityInHand;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public OffsetDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
	}

	public OffsetDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getBeerName() {
		return beerName;
	}

	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}

	public BeerStyleEnum getBeerStyle() {
		return beerStyle;
	}

	public void setBeerStyle(BeerStyleEnum beerStyle) {
		this.beerStyle = beerStyle;
	}

	public Long getUpc() {
		return upc;
	}

	public void setUpc(Long upc) {
		this.upc = upc;
	}

	public Integer getQuantityInHand() {
		return quantityInHand;
	}

	public void setQuantityInHand(Integer quantityInHand) {
		this.quantityInHand = quantityInHand;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BeerDto [id=" + id + ", version=" + version + ", createDate=" + createDate + ", lastModifiedDate="
				+ lastModifiedDate + ", beerName=" + beerName + ", beerStyle=" + beerStyle + ", upc=" + upc
				+ ", quantityInHand=" + quantityInHand + ", price=" + price + "]";
	}
	
}
