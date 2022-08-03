package guru.springframework.msscbrewery;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.msscbrewery.controller.BeerController;
import guru.springframework.msscbrewery.model.BeerDto;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@Test
	void testGetBeerByd() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("http://localhost:8080/api/v1/beer/" + UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testSaveNewBeer() throws Exception {
		BeerDto beerDto = new BeerDto();
		String beerDtoJson = mapper.writeValueAsString(beerDto);
		mockMvc.perform(
				MockMvcRequestBuilders.post("http://localhost:8080/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void testUpdateBeerByID() throws Exception {
		BeerDto beerDto = new BeerDto();
		String beerDtoJson = mapper.writeValueAsString(beerDto);
		mockMvc.perform(
				MockMvcRequestBuilders.put("http://localhost:8080/api/v1/beer/" + UUID.randomUUID().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson))
		.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	void testDeleteBeerByID() {
		fail("Not yet implemented");
	}

}
