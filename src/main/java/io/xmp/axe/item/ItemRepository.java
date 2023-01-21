package io.xmp.axe.item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Long> // Type of Item and Type of its Id 
{
	// can stay empty ... 

	// @Query( "SELECT i FROM item i WHERE s.email = ?1" ) // optional 
	Optional<Item> findByEmail( String email );

}



