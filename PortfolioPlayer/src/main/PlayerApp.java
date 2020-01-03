package main;

import java.util.ArrayList;

import lib.Player;

public class PlayerApp {

	/**
	 * WARNING! - Verbose function for testing and example purposes only
	 * 
	 * @author Joe
	 */
	public static String execute(ArrayList<Player> players, String fullName) {
		
		// Get first name in list to set name of
		Player P1 = players.get(0);
		
		// Set name of player
		P1.setFullPlayerName(fullName);
		
		// Initialise Output String
		String output = "";
		
		// Iterate over ArrayList to find names with "a" in them and output them to string
		for (int i = 0; i < players.size(); i++) {
			Player P = players.get(i);
			String name = P.getFullPlayerName();
			if (P.getName().getFullName().indexOf("a") != -1) {
				output = output + name + "\n";
			}
		}
		
		// Return Final output string
		
		return output;
	}
	
}
