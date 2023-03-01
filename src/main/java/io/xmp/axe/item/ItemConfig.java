package io.xmp.axe.item;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class ItemConfig { 
	@Bean 
	CommandLineRunner commandLineRunner( ItemRepository itemRepository ) { 
		return args -> {  // Mocks 
			Item i1 = new Item( 1, "Max", "max@mail.io", LocalDate .of( 2001, Month.MAY, 16 )),
				i2 = new Item( 2, "Axel", "axel@mail.io", LocalDate .of( 2000, Month.JULY, 05 )),
				i3 = new Item( 3, "Booker", "booker@m.io", LocalDate .of( 1997, Month.MARCH, 1 ));
			itemRepository . saveAll ( List.of( i1, i2, i3 ) ); 
		};
	}
}

/** POST >> Content-Type: application/json 
	{
	  "name": "Mars",
	  "email": "mars@mail.io",
	  "bd": "1995-12-17"
	} 
*/




