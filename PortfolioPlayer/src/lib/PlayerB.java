package lib;

public class PlayerB extends Player {
	
	@Override
	public Name getName() {
		Name name = super.getName();
		name.setFamilyName(name.getFamilyName().toUpperCase());
		name.setFirstName(name.getFirstName().toUpperCase());
		
		super.setName(name);
		return name;
	}
}
