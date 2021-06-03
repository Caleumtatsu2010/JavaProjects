package Exercise1;

public class Employee extends Person{
	public static final int ID_MANAGE = 0;
	public static final int NET = 0;
	public static final String POSITION = "NONE";
	public static final Short APPLY_YEAR = 2021; 
	public static final Short DEPART_ID = 0;

	private int id_manage;// mã quản lý nhân viên
	private int net;// Thu nhập
	private String position;// Vị trí
	private Short apply_year;// Năm làm việc
	private Short depart_id;// mã phòng ban

	public Employee() {
		this(Employee.FIRSTNAME,Employee.LASTNAME,Employee.AGE,
				Employee.ADDRESS,
				Employee.ID_MANAGE,Employee.NET,Employee.POSITION,Employee.APPLY_YEAR,Employee.DEPART_ID);
	}

	public Employee(String firstName,String lastName,byte age,
			Address address,
			int id_manage,int net,String position,short apply_year,short depart_id) {
		super(firstName,lastName,(byte)age,address);
		this.id_manage = id_manage;
		this.net=net;
		this.position = position;
		this.apply_year = apply_year;
		this.depart_id = depart_id;
	}

	// getter
	public int getId_manage() {
		return id_manage;
	}

	public int getNet() {
		return net;
	}

	public String getPosition() {
		return position;
	}

	public Short getApply_year() {
		return apply_year;
	}

	public Short getDepart_id() {
		return depart_id;
	}

	//setter
	public void setId_manage(int id_manage) {
		this.id_manage = id_manage;
	}

	public void setNet(int net) {
		this.net = net;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setApply_year(Short apply_year) {
		this.apply_year = apply_year;
	}

	public void setDepart_id(Short depart_id) {
		this.depart_id = depart_id;
	}

	@Override
	public String toString() {
		return super.toString()+", id_manage=" + id_manage + ", net=" + net + ", position=" + position + ", apply_year="
				+ apply_year + ", depart_id=" + depart_id;
	}

}
