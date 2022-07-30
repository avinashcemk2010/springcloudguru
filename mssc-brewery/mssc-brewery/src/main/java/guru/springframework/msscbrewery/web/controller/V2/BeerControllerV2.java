package guru.springframework.msscbrewery.web.controller.V2;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.service.BeerService;
import guru.springframework.msscbrewery.web.service.V2.BeerServiceV2;

@RequestMapping("api/v2/beer")
@RestController
public class BeerControllerV2 {
	
	@Autowired
	private final BeerServiceV2 beerServiceV2;
	
	public BeerControllerV2(BeerServiceV2 beerServiceV2) {
		super();
		this.beerServiceV2 = beerServiceV2;
	}

	@GetMapping("/{beerID}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerID") UUID id) {
		return new ResponseEntity(beerServiceV2.getBeerById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(BeerDtoV2 beerDtoV2) {
		BeerDtoV2 saveDto = beerServiceV2.saveNewBeer(beerDtoV2);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "api/v2/beer/" + saveDto.getId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerID}")
	public ResponseEntity handleUpdate(
			@PathVariable("beerID") UUID id, 
			@RequestBody BeerDtoV2 beerDtoV2) {
		BeerDtoV2 saveDto = beerServiceV2.updateBeer(beerDtoV2);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{beerID}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteBeer(@PathVariable("beerID") UUID id) {
		beerServiceV2.delete(id);
	}

}
