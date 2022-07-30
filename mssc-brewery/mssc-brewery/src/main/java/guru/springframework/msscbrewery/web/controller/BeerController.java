package guru.springframework.msscbrewery.web.controller;

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
import guru.springframework.msscbrewery.web.service.BeerService;

//@Deprecated
@RequestMapping("api/v1/beer")
@RestController
public class BeerController {
	
	@Autowired
	private final BeerService beerService;
	
	public BeerController(BeerService beerService) {
		super();
		this.beerService = beerService;
	}

	@GetMapping("/{beerID}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable("beerID") UUID id) {
		return new ResponseEntity<>(beerService.getBeerById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(BeerDto beerDto) {
		BeerDto saveDto = beerService.saveNewBeer(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("location", "api/v1/beer/" + saveDto.getId().toString());
		
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerID}")
	public ResponseEntity handleUpdate(@PathVariable("beerID") UUID id, @RequestBody BeerDto beerDto) {
		BeerDto saveDto = beerService.updateBeer(beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("{beerID}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteBeer(@PathVariable("beerID") UUID id) {
		beerService.delete(id);
	}
}
