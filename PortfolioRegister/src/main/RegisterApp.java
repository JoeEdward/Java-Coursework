package main;

import lib.Name;
import lib.Register;

import java.util.ArrayList;

public class RegisterApp {


	public static String execute(Register reg, Name n) {	

		String output = "";
		reg.removeName(1);
		reg.addName(n);

		ArrayList<String> names = reg.getAllNames();


		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			String[] split = name.split(", ");
			if (split[0].length() >= 5) {
				output = output + names.get(i) + "\n";
			}
		}

		return output;
	}
}