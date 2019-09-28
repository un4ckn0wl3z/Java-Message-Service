package rocks.anuwat.www.rabbitmq.model;

import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long Id;
	private String name;
	
	
	public Person() {}
	
	public Person(Long id, String name) {
		super();
		Id = id;
		this.name = name;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [Id=" + Id + ", name=" + name + "]";
	}
	
	
	
	
}
