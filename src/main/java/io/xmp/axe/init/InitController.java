package io.xmp.axe.init;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

	@GetMapping ( "/init" )
	public InitRepsonse init() {

		return new InitRepsonse ( 
			"Wellcome...", 
				List.of ( "Java", "Python", "Php", "JavaScript" ), 
					new Record ( "url@lex.io:pack/role.us", 4, 21 ) ); 
	}

	record InitRepsonse ( String invite, List<String> langs, Record record ) {} 

	record Record ( String name, int number, double weigh ) {} 
}



