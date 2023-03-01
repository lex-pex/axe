package io.xmp.axe.item;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity 
@Table 
public class Item { 
	@Id 
	@SequenceGenerator( name = "item_sequence", sequenceName = "item_sequence", allocationSize = 1 ) 
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "item_sequence" ) 
	private long id; 
	private String name; 
	private String email; 
	private LocalDate bd; // birth-date 
	@Transient 
	private Integer age; 
	// Default Constructor 
	public Item() { 
		super();
	}
	// Mocking Constructor ( with id ) 
	public Item( long id, String name, String email, LocalDate bd ) { 
		this.id = id;
		this.name = name;
		this.email = email;
		this.bd = bd;
	} 
	// All Arguments Constructor 
	public Item( String name, String email, LocalDate bd ) { 
		this.name = name;
		this.email = email;
		this.bd = bd;
	}
	public long getId() { 
		return id;
	} 
	public void setId(long id) {
		this.id = id;
	} 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBd() {
		return bd;
	}
	public void setBd(LocalDate bd) {
		this.bd = bd;
	}
	public Integer getAge() { 
		return Period.between(this.bd, LocalDate.now()).getYears();
	}
	@Override
	public String toString() {
		return String.format (
			"Item {id=%s, name=%s, email=%s, dob=%s, age=%s}", 
				id, name, email, bd, age );
	}
}





