package io.xmp.axe.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping ( path = "api/v1/items" ) 
public class ItemController {

	private final ItemService itemService;

	@Autowired 
	public ItemController( ItemService itemService ) {
		this.itemService = itemService; 
	}

	@GetMapping 
	public List<Item> index() { 
		return itemService.get(); 
	}

	@PostMapping 
	public void store( @RequestBody Item item ) { 
		itemService.add( item ); 
	}

	@PutMapping ( path = "{id}" ) 
	public void update ( @PathVariable ( "id" ) Long id,
							@RequestParam( required = false ) String name, 
								@RequestParam( required = false ) String email ) { 

		itemService.update( id, name, email );
	}

	@DeleteMapping ( path = "{id}" ) 
	public void deleteItem( @PathVariable ( "id" ) Long id ) { 
		itemService. delete( id ); 
	}
}

/*  Rest API methods: 
	show / showAll / index  
	create / store 
	update / save 
	remove / delete / destroy 
*/




