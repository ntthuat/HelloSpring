package dustin.examples;

public class PersonBuilder {

	private String newLastName;
	private String newFirstName;
	private String newMiddleName;
	private String newSalutation;
	private String newSuffix;
	private String newStreetAddress;
	private String newCity;
	private String newState;
	private boolean newIsFemale;
	private boolean newIsEmployed;
	private boolean newIsHomeOwner;
	
	public PersonBuilder() {
	}

	// thay vì sử dụng hàm setter như bình thường, thì ở đây void thay bằng PersonBuilder và return this.
	public PersonBuilder setNewLastName(String newLastName) {
		this.newLastName = newLastName;
		return this;
	}

	
	public PersonBuilder setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
		return this;
	}

	
	public PersonBuilder setNewMiddleName(String newMiddleName) {
		this.newMiddleName = newMiddleName;
		return this;
	}

	
	public PersonBuilder setNewSalutation(String newSalutation) {
		this.newSalutation = newSalutation;
		return this;
	}

	
	public PersonBuilder setNewSuffix(String newSuffix) {
		this.newSuffix = newSuffix;
		return this;
	}

	
	public PersonBuilder setNewStreetAddress(String newStreetAddress) {
		this.newStreetAddress = newStreetAddress;
		return this;
	}

	
	public PersonBuilder setNewCity(String newCity) {
		this.newCity = newCity;
		return this;
	}

	
	public PersonBuilder setNewState(String newState) {
		this.newState = newState;
		return this;
	}

	
	public PersonBuilder setNewIsFemale(boolean newIsFemale) {
		this.newIsFemale = newIsFemale;
		return this;
	}

	
	public PersonBuilder setNewIsEmployed(boolean newIsEmployed) {
		this.newIsEmployed = newIsEmployed;
		return this;
	}

	
	public PersonBuilder setNewIsHomeOwner(boolean newIsHomeOwner) {
		this.newIsHomeOwner = newIsHomeOwner;
		return this;
	}
	
	@Override
	public String toString() {
		return "LastName: "+newLastName+"FirstName: "+newFirstName;
	}
	
}
