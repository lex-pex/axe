package io.xmp.axe.cast;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ( path = "api/v1/casts" ) 
public class CastController { 

	private boolean seeded = false;

	@Autowired 
	private CastRepository castRepository;

	@GetMapping 
	public List<Casto> index () {
		if ( ! seeded ) {
			castRepository.seed();
			seeded = true;
		}
		return castRepository.findAll();
	}

	@PostMapping 
	public void add ( @RequestBody CustRequest request ) {
		castRepository.save(
			new Casto( request.name(), request.email(), request.bd() )
		);
	}

	@PutMapping ( path = "{id}" )
	public void update ( @PathVariable Integer id, @RequestBody CustPutRequest put ) {
		Optional<Casto> opt = castRepository.findById( id );
		if(opt.isEmpty())
			throw new IllegalStateException( "Casto.id:" + id + " is absent" );
		Casto c = opt.get();
		if(put.name() != null) 
			c.setName(put.name());
		if(put.email() != null) 
			c.setEmail(put.email());
		if(put.bd() != null) 
			c.setBd(put.bd());
		castRepository.save(c);
	}

	@DeleteMapping ( "{id}" ) 
	public void delete ( @PathVariable Integer id ) { 
		castRepository.deleteById( id ); 
	} 
	// Request DTO 
	record CustRequest( String name, String email, LocalDate bd ) {} 
	// PUT Request DTO 
	record CustPutRequest( Integer id, String name, String email, LocalDate bd ) {} 
}







