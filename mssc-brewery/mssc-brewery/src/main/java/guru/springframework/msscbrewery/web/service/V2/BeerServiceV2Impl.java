package guru.springframework.msscbrewery.web.service.V2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {

	@Override
	public BeerDtoV2 getBeerById(UUID beerID) {
		return new BeerDtoV2(UUID.randomUUID(), "Galaxy cat", BeerStyleEnum.ALE, (long) 1.0);
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDtoV2) {
		return new BeerDtoV2(UUID.randomUUID(), "Budweiser", BeerStyleEnum.GOSE, (long) 2.0);
	}

	@Override
	public BeerDtoV2 updateBeer(BeerDtoV2 beerDtoV2) {
		return null;
	}

	@Override
	public void delete(UUID id) {

	}

}
