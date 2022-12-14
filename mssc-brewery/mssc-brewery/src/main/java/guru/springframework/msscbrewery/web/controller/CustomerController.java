package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import guru.springframework.msscbrewery.web.service.CustomerService;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping("{customerID}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerID") UUID id) {
		return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
	}
	
}
