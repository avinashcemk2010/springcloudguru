package guru.springframework.msscbrewery.web.service.V2;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {
	
	BeerDtoV2 getBeerById(UUID beerID);

	BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2);

	BeerDtoV2 updateBeer(BeerDtoV2 beerDtoV2);

	void delete(UUID id);
}
