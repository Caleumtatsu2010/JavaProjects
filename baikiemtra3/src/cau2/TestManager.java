package cau2;
import cau1.*;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;


public class TestManager implements FileManager
{
	//phương thức thêm nhân viên vào file có đường dẫn filepath
	@Override
	public boolean addEmployee(Person p, String filepath) 
	{
		//Khởi tạo danh sách nhân viên
		ArrayList<Employee> employees = null;
		if(p==null) return false;
		try {
			// Đọc danh sách nhân viên từ file
			employees = MyFile.textInputFile(filepath);

			// Thêm nhân viên vào danh sách
			employees.add((Employee) p);
			
			// Cập nhật danh sách nhân viên trong file
			MyFile.textOutputFile(filepath, employees);
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	//phương thức sửa nhân viên 
	@Override
	public boolean editEmployee(Person p, String filepath) {
		//Khởi tạo danh sách nhân viên
		ArrayList<Employee> employees = null;
		if(p==null) return false;
		try {
			// Đọc danh sách nhân viên từ file
			employees = MyFile.textInputFile(filepath);
			for(int i = 0;i<employees.size();i++) 
			{
				// Kiểm tra xem mã nhân viên nhập vào có trong file hay không
				if(employees.get(i).getId()==((Employee) p).getId()) 
				{
					employees.set(i, (Employee)p);
					break;
				}
			}
			
			// Cập nhật lại file
			MyFile.textOutputFile(filepath, employees);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}
	//phương thức xóa nhân viên 
	@Override
	public boolean delEmployee(Person p, String filepath) {
		//Khởi tạo danh sách nhân viên
		ArrayList<Employee> employees = null;
		if(p==null) return false;
		try {
			// Đọc danh sách nhân viên từ file
			employees = MyFile.textInputFile(filepath);
			for(int i = 0;i<employees.size();i++) 
			{
				// Kiểm tra xem mã nhân viên nhập vào có trong file hay không
				if(employees.get(i).getId()==((Employee) p).getId()) 
				{
					// xóa nhân viên khỏi danh sách
					employees.remove(i);
					break;
				}
			}
			// Cập nhật lại file 
			MyFile.textOutputFile(filepath, employees);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	//phương thức tìm sinh viên theo tên
	@Override
	public ArrayList<Employee> searchEmployee(Person[] list, String name) {
		//Khởi tạo danh sách nhân viên cần tìm
		ArrayList<Employee> result = new ArrayList<Employee>();
		for(Person p : list) 
		{	//Tìm nhân viên có tên nhập vào trong danh sách
			if(p.getFirstName().equals(name)) 
			{	//Thêm nhân viên vừa tìm vào danh sách nhân viên cần tìm
				result.add((Employee) p);
			}
		}
		return result;
	}
	//phương thức tìm sinh viên theo địa chỉ
	@Override
	public ArrayList<Employee> searchEmployee(Person[] list, Address addr) {
		//Khởi tạo danh sách nhân viên
		ArrayList<Employee> result = new ArrayList<Employee>();
		for(Person p : list) 
		{
			//Tìm nhân viên có address nhập vào trong danh sách
			if(p.getAddress().equals(addr)) 
			{	//Thêm nhân viên vừa tìm vào danh sách nhân viên cần tìm
				result.add((Employee) p);
			}
		}
		return result;
	}
	//phương thức nhập nhân viên mới
	public static Employee nhap()
	{	//khởi tạo nhân viên
		Employee e = new Employee();
		Scanner s = new Scanner(System.in);
		System.out.println("Nhập nhân viên: ");
		boolean check = false;
		do {
			try {
				//Nhập mã nhân viên
				System.out.print("Id: ");
				e.setId(Integer.parseInt(s.nextLine()));
				System.out.print("First name : ");
				e.setFirstName(s.nextLine());
				System.out.print("Last name : ");
				e.setLastName(s.nextLine());
				System.out.print("Age : ");
				e.setAddress(new Address());
				e.setAge(Integer.parseInt(s.nextLine()));
				System.out.print("NET : ");
				e.setNet(Integer.parseInt(s.nextLine()));
				System.out.print("Position : ");
				e.setPosition(s.nextLine());
				
				System.out.print("Apply year : ");
				e.setApply_year(Short.parseShort(s.nextLine()));
				System.out.print("Depart id : ");
				e.setDepart_id(Short.parseShort(s.nextLine()));
				check = true;
			}catch (Exception ex) {
				System.out.println("Bạn nhập sai kiểu số");
				check = false;
			}
		}while(!check);
		System.out.println("Đã Thoát");
		return e;
	}
	//phương thức sửa nhân viên mới
	public static Employee sua()
	{	//khởi tạo nhân viên
		Employee e = new Employee();
		Scanner s = new Scanner(System.in);
		System.out.println("Nhập nhân viên: ");
		boolean check = false;
		do {
			try {
				//Nhập mã nhân viên cần sửa
				System.out.print("Nhập mã nhân viên cần sửa : ");
				e.setId(Integer.parseInt(s.nextLine()));
				System.out.print("Nhập thông tin nhân viên cần sửa : ");
				System.out.print("First name : ");
				e.setFirstName(s.nextLine());
				System.out.print("Last name : ");
				e.setLastName(s.nextLine());
				System.out.print("Age : ");
				e.setAddress(new Address());
				e.setAge(Integer.parseInt(s.nextLine()));
				System.out.print("NET : ");
				e.setNet(Integer.parseInt(s.nextLine()));
				System.out.print("Position : ");
				e.setPosition(s.nextLine());
				
				System.out.print("Apply year : ");
				e.setApply_year(Short.parseShort(s.nextLine()));
				System.out.print("Depart id : ");
				e.setDepart_id(Short.parseShort(s.nextLine()));
				check = true;
			}catch (Exception ex) {
				System.out.println("Nhập sai kiểu số");
				check = false;
			}
		}while(!check);
		System.out.println("Đã Thoát");
		return e;
	}
	//phương thức thêm nhân viên cập nhật với file
	@Override
	public ArrayList<Employee> addEmployee(File f)
	{
		//Khởi tạo danh sách nhân viên
		ArrayList<Employee> employees = null;
		//Nhập vào thông tin nhân viên
		Employee employee = nhap();
		
		try {
			// Đọc danh sách nhân viên từ file
			employees = MyFile.textInputFile(f.getPath());
			//Thêm nhân viên vào danh sách nhân viên 
			employees.add(employee);
			// Cập nhật lại file 
			MyFile.textOutputFile(f.getPath(), employees);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return employees;
	}
	//phương thức sửa nhân viên cập nhật với file
	@Override
	public ArrayList<Employee> editEmployee(File f) {
		//Khởi tạo danh sách nhân viên
		ArrayList<Employee> employees = null;
		Employee e = sua();
		try {
			// Đọc danh sách nhân viên từ file
			employees = MyFile.textInputFile(f.getPath());

			for(int i = 0;i<employees.size();i++) {
				// Kiểm tra xem mã nhân viên nhập vào có trong file hay không
				if(employees.get(i).getId()==e.getId()) {
					employees.set(i, e);
					break;
				}
			}
			//Cập nhật lại file
			MyFile.textOutputFile(f.getPath(), employees);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return employees;
	}
	//phương thức xóa nhân viên cập nhật lại file
	@Override
	public ArrayList<Employee> delEmployee(File f) {
		// Nhập mã nhân viên muốn xóa từ bàm phím
		Scanner s = new Scanner(System.in);
				int id=-1;
				do {
					System.out.print("Nhập mã nhân viên muốn xóa: ");
					try {
						id = s.nextInt();
					}catch (NumberFormatException e) {
						System.out.println("Mã nhân viên không hợp lệ!");
					}
					// Nếu mã nhân viên âm thì  yêu cầu nhập lại
					if(id<0) {
						System.out.println("Nhập lại mã nhân viên.");
					}
				}while(id<0);
				//Khởi tạo danh sách nhân viên
				ArrayList<Employee> employees = null;
				try {
					// Đọc danh sách nhân viên từ file
					employees = MyFile.textInputFile(f.getPath());

					for(Employee employee:employees) 
					{
						// Kiểm tra xem mã nhân viên nhập vào có trong file hay không
						if(employee.getId()==id) {
							// xóa nhân viên khỏi danh sách và thoát khỏi vòng lặp
							employees.remove(employee);
							break;
						}
					}
					//Cập nhật lại file
					MyFile.textOutputFile(f.getPath(), employees);
					return employees;
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
	}
	public static void main(String[] args) 
	{
		Person p = new Employee(0,"Long", "Hoàng", 50, new Address(), 1, null, (short)3, (short)3);
		
		TestManager t = new TestManager();
		
		t.addEmployee(p, "danhsach.txt");
		t.delEmployee(p, "danhsach.txt");
		t.editEmployee(p, "danhsach.txt");
		
		
		
		try {
			List<Employee> list =MyFile.textInputFile("danhsach.txt");
			Employee[] array = new Employee[list.size()];
			for(int i = 0; i < list.size(); i++) 
			{
				array[i] = list.get(i);
			}
			MyEmployee.printEmployee(t.searchEmployee(array, "Bình"));
			//MyEmployee.printEmployee(t.searchEmployee(array, new Address()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		t.addEmployee(new File("danhsach.txt"));
		t.editEmployee(new File("danhsach.txt"));
		t.delEmployee(new File("danhsach.txt"));

		
		
		
		
		
	}







}
