package guru.springframework.msscbrewery.web.model.v2;

import java.util.UUID;

public class BeerDtoV2 {
	
	private UUID id;
	private String beername;
	private BeerStyleEnum beerStyle;
	private Long upc;
	
	public BeerDtoV2() {}

	public BeerDtoV2(UUID id, String beername, BeerStyleEnum beerStyle, Long upc) {
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

	@Override
	public String toString() {
		return "BeerDtoV2 [id=" + id + ", beername=" + beername + ", beerStyle=" + beerStyle + ", upc=" + upc + "]";
	}
	
}
