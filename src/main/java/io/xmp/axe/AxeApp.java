package io.xmp.axe;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class AxeApp { 
	public static void main ( String... args ) {

		SpringApplication.run ( AxeApp.class, args );

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> squares = list.stream()
                .filter(x -> x % 2 == 0) // keep only even numbers
                .map(x -> x * x) // square each number
                .collect( Collectors.toList() ); // collect the result in a new list
        System.out.println(squares); // prints [4, 16, 36, 64, 100]

	}
}
