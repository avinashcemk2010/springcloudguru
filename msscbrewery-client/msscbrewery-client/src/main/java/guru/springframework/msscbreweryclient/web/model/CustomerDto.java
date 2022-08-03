package guru.springframework.msscbreweryclient.web.model;

import java.util.UUID;

public class CustomerDto {
	
	private UUID id;
	private String name;
	
	public CustomerDto() {}

	public CustomerDto(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
}
