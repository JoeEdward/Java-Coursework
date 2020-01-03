package lib;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

/**
 * Register holds a collection of names and has common functions for dealing with them
 *
 * @author Joe
 */
public class Register implements Iterable<Name> {
    //Fields
    private ArrayList<Name> names = new ArrayList<>();

    /**
     * Default Constructor creates a new arraylist and initialises it
     */
    public Register() { }

    // Methods
    public void addName(Name name) { this.names.add(name); }

    public Name getName(int i) { return names.get(i); }

    public Name removeName(int i) { return names.remove(i); }

    public int registerSize() { return names.size(); }

    public void clearRegister() { names.clear(); }

    public boolean isRegisterEmpty() { return names.isEmpty(); }

    public String toString() {
        return "Register:[names: " + names.toString() + "]";
    }

    /**
     * Searches collection to find a specific name
     * 
     * @param familyName The surname you want to find
     * @return returns true or false depending on if the name was found
     */
    public boolean searchRegisterByFamilyName(String familyName) {
        for (Name name : names) {
            if (name.getFamilyName().equals(familyName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Counts the number of times the char is used as the last letter of the first name
     * 
     * @param letter the char for search
     * @return Returns the number of times the test was successful
     */
    public int countFirstNameOccurrences(char letter) {
        int counter = 0;
        for (Name value : names) {
            String name = value.getFirstName();
            char lastChar = name.charAt(name.length() - 1);
            if (lastChar == letter) {
                counter += 1;
            }
        }
        return counter;
    }

    /**
     * lists all names in a more human readable format
     * @return Returns an array of all names with their surname and their initial.
     */
    public ArrayList<String> getAllNames() {
        ArrayList<String> output = new ArrayList<String>();

        for (Name name : names) {
            String j = name.getFamilyName() + ", " + name.getFirstName().charAt(0);
            output.add(j.toUpperCase());
        }

        return output;
    }

    /*
     * Iterator method to conform with interface 
     */
	@Override
	public Iterator<Name> iterator() {
		return names.iterator();
	}
	
	/*
	 * Sorts the internals names ArrayList into its natural order
	 */
	public void sortRegister() {
		Collections.sort(this.names);
	}

}
