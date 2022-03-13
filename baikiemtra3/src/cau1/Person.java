package cau1;

public class Person 
{
		public static final String FIRSTNAME = "NoFirstName";
		public static final String LASTNAME = "NoLastName";
		public static final int AGE = 0;
		public static final Address ADDRESS = new Address();
	
		private String firstName;
		private String lastName;
		private int age;
		private Address address;
		public Person() {
			this(Person.FIRSTNAME, Person.LASTNAME, (byte) 0, Person.ADDRESS);
		}
		public Person(String firstName, String lastName, int age, Address address) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.address = address;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		@Override
		public String toString() {
			return "FirstName=" + firstName + " LastName=" + lastName + " Age=" + age + " Address=" + address;
		}
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
}
