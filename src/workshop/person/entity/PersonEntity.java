package workshop.person.entity;

public class PersonEntity {
	private String name;
	private char gender;
	private String ssn;
	private String address;
	private String phone;
	
	// default constructor
	public PersonEntity() {
		
	}
	
	// overloading constructor
	public PersonEntity(String name, String ssn, String address, String phone) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.address = address;
		this.phone = phone;
	}
	
	public static void main(String[] args) {
		System.out.println("sss");
	}
	
}
