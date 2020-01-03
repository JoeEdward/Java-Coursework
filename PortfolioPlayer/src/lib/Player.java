package lib;


/**
 * A Player has two properties a name from the Name class and a pair of dice
 *
 * @author Joe
 */
public class Player implements Rollable, Comparable<Player> {
    /* Properties */

    private Name name;
    private Rollable die;

    //Constructors

    /**
     * Creates a new instance of Player with default fields
     */
    public Player() {
        this.name = new Name();
        this.die = new PairOfDice();
    }

    /**
     * Creates a new instance with a dedicated name set and the die randomly assigned
     * @param name the name class of the Player
     */
    public Player(Name name) {
        this.name = name;
        this.die = new PairOfDice();
    }

    /**
     * Creates a new instance filling in all fields with defined classes
     * @param name The name of the player
     * @param die Preset die for the player
     */
    public Player(Name name, Rollable die) {
        this.name = name;
        this.die = die;
    }

    // Methods
    
    /*
     * Sets the name of the player
     */
    public void setName(Name name) {
        this.name = name;
    }
    
    /*
     * Gets the name of the player
     */
    public Name getName() {
        return name;
    }

    /*
     * Implements the Rollable interface
     */
    public Rollable getRollable() {
        return die;
    }

    /*
     * Calculates dice score for the player
     */
    public int getDiceScore() {
        return die.getScore();
    }

    /*
     * Randomises the dice rolls
     */
    public void rollDice() {
        die.roll();
    }

    /**
     * Sets players name from a string
     *
     * @param name must be a two word name separated by a space
     */
    public void setFullPlayerName(String name) {
        String[] newName = name.split(" ");
        this.name.setFirstName(newName[0]);
        this.name.setFamilyName(newName[1]);
    }

    public String getFullPlayerName() {
    	String FN = this.name.getFirstName().toLowerCase();
    	String LN = this.name.getFamilyName().toUpperCase();
    	
    	return FN + ", " + LN;
    }
    /*
     * compares the names to implement the comparable interface
     */
    @Override
    public int compareTo(Player other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Player:[" + this.name.toString() + "," + this.die.toString() + "]";
    }

    @Override
    public void roll() {
        this.die.roll();
    }

    @Override
    public int getScore() {
        return this.die.getScore();
    }
}
