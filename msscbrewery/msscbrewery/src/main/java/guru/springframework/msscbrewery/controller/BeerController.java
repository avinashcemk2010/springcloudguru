package guru.springframework.msscbrewery.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.model.BeerDto;

@RequestMapping("api/v1/beer")
@RestController
public class BeerController {
	
	@GetMapping("/{beerID}")
	public ResponseEntity<BeerDto> getBeerByd(@PathVariable("beerID") UUID beerID) {
		return new ResponseEntity<>(new BeerDto(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerID}")
	public ResponseEntity<BeerDto> updateBeerByID(
			@PathVariable("beerID") UUID beerID, @Valid @RequestBody BeerDto beerDto) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerID}")
	public ResponseEntity<BeerDto> deleteBeerByID(
			@PathVariable("beerID") UUID beerID) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
