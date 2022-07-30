package guru.springframework.msscbrewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.BeerDto;

@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerID) {
		return new BeerDto(UUID.randomUUID(), "Galaxy cat", "Pale ale", (long) 1.0);
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return new BeerDto(UUID.randomUUID(), "Budweiser", "Lenka", (long) 2.0);
	}

	@Override
	public BeerDto updateBeer(BeerDto beerDto) {
		return null;
	}

	@Override
	public void delete(UUID id) {
		System.out.println("deleting beer");
	}

}
