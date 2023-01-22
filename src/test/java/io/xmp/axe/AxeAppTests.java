package io.xmp.axe;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest 
class AxeAppTests 
{ 
	private boolean trueBool = true;
	private boolean falseBool = true;
	private String notNullString = "notNullString";
	private Object originalObject = new Object();
	private Object otherObject = new Object();

	@Test 
	void contextLoads() 
	{ 
		Assertions.assertTrue( trueBool );
	    Assertions.assertFalse( falseBool );
	    Assertions.assertNotNull( notNullString );
	    Assertions.assertNull( notNullString );
	    Assertions.assertNotSame( originalObject, otherObject );
	    Assertions.assertEquals( 4, 4 );
	    Assertions.assertNotEquals( 3, 2 );
	    Assertions.assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "Array Equal Test");
	    Iterable<Integer> listOne = new ArrayList<>( Arrays.asList( 1,2,3,4 ));
	    Iterable<Integer> listTwo = new ArrayList<>( Arrays.asList( 1,2,3,4 ));
	    Assertions.assertIterableEquals(listOne, listTwo);
	    Assertions.assertTimeout( Duration.ofMillis(100), () -> {
		    Thread.sleep( 50 );
		    return "result";
	    });
	    Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
	    throw new IllegalArgumentException("error message");
	    });
	    Assertions.fail("not found good reason to pass");
	}

	@BeforeAll 
    static void setup()
	{
        System.out.println("Executes a method Before all tests");
    }

    @BeforeEach 
    void setupThis()
    {
        System.out.println("Executed Before each @Test method in the current test class");
    }

    @AfterEach 
    void tearThis()
    {
        System.out.println("Executed After each @Test method in the current test class");
    }

    @AfterAll 
    static void tear()
    {
        System.out.println("Executes a method After all tests");
    }

}









