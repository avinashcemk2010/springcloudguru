package guru.springframework.msscbrewery.web.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

public class BeerDto {
	
	@Null
	private UUID id;
	@NotBlank
	private String beername;
	@NotBlank
	private String beerStyle;
	@Positive
	private Long upc;
	
	public BeerDto() {}

	public BeerDto(UUID id, String beername, String beerStyle, Long upc) {
		super();
		this.id = id;
		this.beername = beername;
		this.beerStyle = beerStyle;
		this.upc = upc;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getBeername() {
		return beername;
	}

	public void setBeername(String beername) {
		this.beername = beername;
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

	@Override
	public String toString() {
		return "BeerDto [id=" + id + ", beername=" + beername + ", beerStyle=" + beerStyle + ", upc=" + upc + "]";
	}
}
