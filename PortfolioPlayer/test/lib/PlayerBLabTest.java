package lib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.Test;

public class PlayerBLabTest {
	
	@Test
	public void testHasName() {
		Player p = new Player();
		
		p.setName(new Name("Tim", "Bloggs"));		
		
		assertEquals("Should return true as player is called Tim Bloggs", true, p.hasName(new Name("Tim", "Bloggs")));
		assertEquals("Should return false as player is not called Fred Jones", false, p.hasName(new Name("Fred", "Jones")));
		
		
		p = new Player(); //create another player for further checks
		
		p.setName(new Name("Fred", "Jones"));
		
		assertEquals("Should return false as player is not called Tim Bloggs", false, p.hasName(new Name("Tim", "Bloggs")));
		assertEquals("Should return true as player is called Fred Jones", true, p.hasName(new Name("Fred", "Jones")));
		
	}	
	
	
	@Test
	public void testHasName2() {
		Player p = new Player();
		
		p.setName(new Name("Tim", "Bloggs"));		
		
		assertEquals("Should return true as player is called Tim Bloggs", true, p.hasName(new Name("Tim", "Bloggs")));
		assertEquals("Should return false as player is not called Fred Jones", false, p.hasName(new Name("Fred", "Jones")));
		
		
		p = new Player(); //create another player for further checks
		
		p.setName(new Name("Fred", "Jones"));
		
		assertEquals("Should return false as player is not called Tim Bloggs", false, p.hasName(new Name("Tim", "Bloggs")));
		assertEquals("Should return true as player is called Fred Jones", true, p.hasName(new Name("Fred", "Jones")));
		
		
		/* EXTENSION */
		
		//null checks
		assertEquals("Should return false as player currently has a name", false, p.hasName(null));
		
		p.setName(null);
		assertEquals("Should return true as player does not currently have a name", true, p.hasName(null));	
		
	}	
	
	
	@Test
	public void testGetNameOverridden() {
		Player p = new Player();
		
		p.setName(new Name("Joe", "Bloggs"));
		
		assertEquals("Name should have been returned unchanged", new Name("Joe", "Bloggs"), p.getName());
		
		
		p = new PlayerB(); //create instance of subclass
		
		Name n = new Name("Joe", "Bloggs");
		p.setName(n); 
		
		//using overridden getName
		assertSame("The same Name object reference passed to the method should have been returned", n, p.getName());
		assertEquals("Name should have been returned in uppercase", new Name("JOE", "BLOGGS"), p.getName());
		
		
		//Other checks to ensure you have passed this test in the intended manner
		Field[] fields = Player.class.getDeclaredFields();
		assertTrue("All fields must remain private", Arrays.stream(fields).allMatch(f -> (Modifier.PRIVATE & f.getModifiers()) != 0));
		
		Field[] fieldsB = PlayerB.class.getDeclaredFields();
		assertEquals("The PlayerB class should not define any fields", 0, fieldsB.length);
				
		Method[] methodsB = PlayerB.class.getDeclaredMethods();
		assertTrue("The PlayerB class should only have 1 method called getName", 
				methodsB.length == 1 && methodsB[0].getName().equals("getName"));
		
	}
	
}