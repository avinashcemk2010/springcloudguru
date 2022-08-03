package guru.springframework.msscbreweryclient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.client.BreweryClient;
import guru.springframework.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {
	
	@Autowired
	BreweryClient client;

	@Test
	void testGetBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewBeer() {
		BeerDto dto = new BeerDto(UUID.randomUUID(), "Bud", "New style" ,(long)1.0);
		URI uri = client.saveNewBeer(dto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}
	
	@Test
	void testUpdateBeer() {
		BeerDto dto = new BeerDto(UUID.randomUUID(), "Bud", "New style" ,(long)1.0);
		client.updateBeer(UUID.randomUUID(), dto);
		
	}
	
	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());;
	}

}
