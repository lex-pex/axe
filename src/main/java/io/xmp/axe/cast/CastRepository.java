package io.xmp.axe.cast;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface CastRepository extends JpaRepository<Casto, Integer> {

	@Modifying 
	@Transactional 
	@Query ( value =  
		"INSERT INTO casto( id, name, email, bd ) VALUES " + 
		"(nextval('cast_sequence'), 'Axe', 'axe@m.io', '2001-05-16' ), " + 
		"(nextval('cast_sequence'), 'Gym', 'gym@.io', '2019-03-29' ), " + 
		"(nextval('cast_sequence'), 'Fix', 'fix@m.io', '2009-11-19' );",
		nativeQuery = true ) 
	void seed();

	@Query(value = "CREATE TABLE cust;", nativeQuery = true)
    @Modifying
	void migrate();

}
