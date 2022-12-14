package guru.springframework.msscbrewery.web.service;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.BeerDto;

public interface BeerService {
	
	BeerDto getBeerById(UUID beerID);

	BeerDto saveNewBeer(BeerDto beerDto);

	BeerDto updateBeer(BeerDto beerDto);

	void delete(UUID id);

}
