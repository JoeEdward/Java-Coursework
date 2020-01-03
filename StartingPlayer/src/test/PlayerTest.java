package test;

import lib.Name;
import lib.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {


    @Test
    public void setNameTest() {
        Player test_model = new Player();
        Name name = new Name("Joe", "Edwards");

        test_model.setFullPlayerName("Joe Edwards");

        assertEquals("Testing Name set", name, test_model.getName());
    }
}
