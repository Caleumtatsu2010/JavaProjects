package objects;

public class Person implements Comparable<Person>
{
		private String firstName;
		private String lastName;
		private int age;
		@Override
		public int compareTo(Person o) 
		{
	       	 int resFirst = this.getFirstName().compareTo(o.getFirstName());
	         if (resFirst != 0) 
	         {
	            return resFirst;
	         } 
	         else 
	         {
	        	int resLast = this.getLastName().compareTo(o.getLastName());
	            return resLast;
	         }
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
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String toString()
		{
			return "First Name: "+firstName+"   Last Name: "+   lastName+"   Age: "+age;
		}
		
}
