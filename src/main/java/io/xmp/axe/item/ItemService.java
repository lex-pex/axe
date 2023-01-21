package io.xmp.axe.item;

//import java.time.LocalDate;
//import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service // @Component 
public class ItemService {

	private final ItemRepository itemRepository;

	@Autowired 
	public ItemService( ItemRepository itemRepository ) {
		this.itemRepository = itemRepository;
	}

	public List<Item> get() {
		return itemRepository.findAll(); 
	}

	public ItemRepository getItemRepository() {
		return itemRepository;
	}

	public void add( Item item ) {
		// Check whether the e-mail is taken... 
		Optional<Item> itemOptional = itemRepository.findByEmail( item.getEmail() );
		if( itemOptional.isPresent() ) {
			throw new IllegalStateException ( "email allocated already" );
		} else {
			itemRepository.save( item );
		}
	}

	public void delete( Long id ) {
		if( ! itemRepository. existsById( id ) )
			throw new IllegalStateException ( "There is no Item #id:" + id );
		else 
			itemRepository.deleteById( id );
	}

	@Transactional 
	public void update( Long id, String name, String email ) {

		Item item = itemRepository.findById( id ).orElseThrow( () -> 
			new IllegalStateException( "There is no item id#:" + id ));

		pasteName( name, item );
		pasteEmail( email, item );
	}

	private void pasteName( String name, Item item ) {
		if (name != null && name.length() > 0 && !Objects.equals( item.getName(), name )) 
			item.setName( name );
	}

	private void pasteEmail( String email, Item item ) {
		if (email != null && email.length() > 0 && !Objects.equals( item.getEmail(), email )) {
			Optional<Item> io = itemRepository.findByEmail( email );
			if (io.isPresent())
				throw new IllegalStateException( "email allocated already" );
			item.setEmail( email );
		} else 
			throw new IllegalStateException( "email eather the same, or invalid" );
	}
}


