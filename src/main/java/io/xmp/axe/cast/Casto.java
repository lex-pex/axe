package io.xmp.axe.cast;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;

@Entity
public class Casto {
	@Id 
	@SequenceGenerator ( name = "cast_sequence", sequenceName = "cast_sequence", allocationSize = 1 ) 
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "cast_sequence" ) 
	private Integer id; 
	private String name; 
	private String email; 
	private LocalDate bd; // birth-date 
	@Transient 
	private Integer age; 
	// Default Constructor 
	public Casto( ) { 
		super( );
	}
	public Casto(String name, String email, LocalDate bd) {
		super();
		this.name = name;
		this.email = email;
		this.bd = bd;
	}

	// All Arguments Constructor ( mock id ) 
	public Casto( Integer id, String name, String email, LocalDate bd, Integer age ) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.bd = bd;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Casto setName(String name) {
		this.name = name;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public Casto setEmail(String email) {
		this.email = email;
		return this;
	}
	public LocalDate getBd() {
		return bd;
	}
	public Casto setBd(LocalDate bd) {
		this.bd = bd;
		return this;
	}
	public Integer getAge() { 
		return Period.between(this.bd, LocalDate.now()).getYears();
	}
	public Casto setAge(Integer age) {
		this.age = age;
		return this;
	}
	@Override 
	public String toString() {
		return String.format (
			"Item {id=%s, name=%s, email=%s, dob=%s, age=%s}", 
				id, name, email, bd, age );
	}
}




