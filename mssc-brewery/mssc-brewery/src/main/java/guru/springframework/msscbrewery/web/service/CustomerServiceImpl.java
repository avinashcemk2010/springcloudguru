package guru.springframework.msscbrewery.web.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID id) {
		return new CustomerDto(UUID.randomUUID(), "Avinash");
	}

}
