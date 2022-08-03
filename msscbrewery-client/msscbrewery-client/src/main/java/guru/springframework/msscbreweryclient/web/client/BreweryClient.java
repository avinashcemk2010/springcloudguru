package guru.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

@Component
public class BreweryClient {

	public final String BEER_PATH_V1 = "/api/v1/beer/";
	@Value("${sfg.brewery.apiHost}")
	private String apiHost;
	private RestTemplate restTemplate;

	public BreweryClient(RestTemplateBuilder builder) { 
		this.restTemplate = builder.build(); 
	}

	public BeerDto getBeerById(UUID id) {
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + UUID.randomUUID(), BeerDto.class);
	}
	
	public URI saveNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apiHost + BEER_PATH_V1, BeerDto.class);
	}
	
	public void updateBeer(UUID id, BeerDto beerDto) {
		restTemplate.put(apiHost + BEER_PATH_V1 + id.toString(), beerDto);
	}
	
	public void deleteBeer(UUID id) {
		restTemplate.delete(apiHost + BEER_PATH_V1 + id.toString());
	}
}
