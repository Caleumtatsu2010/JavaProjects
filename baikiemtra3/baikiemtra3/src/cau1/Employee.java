package cau1;

public class Employee extends Person implements Comparable<Employee>
{
	public static final int ID_MANAGE = 0;
	public static final int NET = 0;
	public static final String POSITION = "NONE";
	public static final Short APPLY_YEAR = 2021; 
	public static final Short DEPART_ID = 0;
	
	
	private int id;
	private int net;
	private String position;
	private short apply_year;
	private short depart_id;
	
	public Employee(int id, String firstname, String lastname, int age, Address address, int net, String position, short apply_year, short depart_id) {
		super(firstname, lastname, age, address);
		this.id = id;
		this.net = net;
		this.position = position;
		this.apply_year = apply_year;
		this.depart_id = depart_id;
	}

	@Override
	public String toString() {
		return "ID="+id+" "+super.toString()+" Net=" + net + " Position=" + position + " Apply year=" + apply_year + " Depart id=" + depart_id ;
	}
	//Ghi đè phương thức compare, cài đặt tiêu chí để sắp xếp theo tuổi
	@Override
	public int compareTo(Employee o) {
		
		return this.getAge() - o.getAge();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNet() {
		return net;
	} 
	public void setNet(int net) {
		this.net = net;
	}
	public String getPosition() {
		return position;
	}
	
	public Employee() 
	{
		this(Employee.ID_MANAGE,Employee.FIRSTNAME,Employee.LASTNAME,Employee.AGE,Employee.ADDRESS,Employee.NET,Employee.POSITION,Employee.APPLY_YEAR,Employee.DEPART_ID);
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public short getApply_year() {
		return apply_year;
	}
	
	public void setApply_year(short apply_year) {
		this.apply_year = apply_year;
	}
	
	public short getDepart_id() {
		return depart_id;
	}
	
	public void setDepart_id(short depart_id) {
		this.depart_id = depart_id;
	}

}
