package Exercise1;

public class Person implements Comparable<Person>{

	// constants
	public static final String FIRSTNAME = "No FirstName";
	public static final String LASTNAME = "No LastName";
	public static final byte AGE = 0;
	public static final Address ADDRESS = new Address();

	// Object's properties
	private String firstName;
	private String lastName;
	private byte age;
	private Address address;// Địa chỉ

	// Constructor
	public Person() {
		this(Person.FIRSTNAME, Person.LASTNAME, (byte) 0, Person.ADDRESS);
	}
	public Person(String firstName, String lastName, byte age, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = new Address(address);// khởi tạo một vùng bộ nhớ mới và sao chép giá trị sang
	}

	// Getter methods 

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public byte getAge() {
		return this.age;
	}

	public Address getAddress() {
		return this.address;
	}

	public String getFullAddress() {
		return this.address.toString();
	}

	// Setter methods 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public void setAddress(Address address) {
		this.address = new Address(address);
	}
	public void setAddress(String cityName, String districtName, String streetName) {
		this.address = new Address(cityName,districtName,streetName);
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", "+address.toString();
	}
	
	
	@Override
	public int compareTo(Person p) { 
		return this.age-p.age;
	}
}
