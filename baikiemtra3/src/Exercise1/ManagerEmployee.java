package Exercise1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Exercise2.IManagerEmployee;
import Exercise2.IUpdateFile;

public class ManagerEmployee implements IManagerEmployee, IUpdateFile{


	/**
	 *-Phương thức thêm nhân viên :<br/>
	 * + Trả về true nếu thêm thành công. <br/>
	 * + Ngược lại trả về false nếu thêm thất bại. <br/>
	 *-Trình tự thực hiện :Đọc file -> Thêm nhân viên -> cập nhật file
	 */
	@Override
	public boolean addEmployee(Person p) {
		if(p==null) return false;
		// Tạo một danh sánh nhân viên lưu thông tin đọc từ file
		ArrayList<Employee> employees = null;
		// Tạo đối tượng thực thi ghi dữ liệu
		PrintWriter out = null;
		// Tạo file cần ghi
		File f = new File(MyFiles.EMPLOYEE_FILE_PATH);
		try {
			// Đọc thông tin nhân viên từ file
			employees = MyFiles.readFileEmployee(f);
			// Khởi tạo đối tượng thực thi ghi dữ liệu
			out = new PrintWriter(new FileWriter(f));
			// Cập nhật mã nhân viên
			((Employee) p).setId_manage(employees.size());
			// Thêm nhân viên vào danh sách
			employees.add((Employee) p);
			// Sắp xếp nhân viên theo tuổi
			Collections.sort(employees);
			// Cập nhật nhân viên trong file
			MyFiles.updateFile(employees,out);
			// Trả về true nều không có lỗi trong quá trình thực thi
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally {
			// Đóng luồng thực thi ghi dữ liệu
			out.close();
		}
	}

	/**
	 * -Phương thức chỉnh sửa nhân viên :<br/>
	 * 	+ Trả về true nếu chỉnh sửa thành công.<br/>
	 * 	+ Ngược lại trả về false nếu chỉnh sửa thất bại.<br/>
	 * -Trình tự thực hiện :Đọc file -> Chỉnh sửa nhân viên -> cập nhật file
	 */
	@Override
	public boolean editEmployee(Person p) {
		if(p==null) return false;
		File f = new File(MyFiles.EMPLOYEE_FILE_PATH);
		// Đọc thông tin từ file
		ArrayList<Employee> employees = null;
		PrintWriter out = null;
		try {
			employees = MyFiles.readFileEmployee(f);
			// Tạo đối tượng thực thi ghi dữ liệu
			out = new PrintWriter(new FileWriter(f));
			for(int i = 0;i<employees.size();i++) {
				// Kiểm tra xem mã nhân viên nhập vào có trong file hay không
				if(employees.get(i).getId_manage()==((Employee) p).getId_manage()) {
					employees.set(i, (Employee)p);
					break;
				}
			}
			// Sắp xếp nhân viên theo tuổi
			Collections.sort(employees);
			// Cập nhật lại file
			MyFiles.updateFile(employees,out);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			//Đóng luồng
			out.close();
		}
	}

	/**
	 * -Phương thức xóa nhân viên :<br/>
	 * 	+ Trả về true nếu xóa thành công.<br/>
	 * 	+ Ngược lại trả về false nếu xóa thất bại.<br/>
	 * -Trình tự thực hiện :Đọc file -> Thêm nhân viên -> cập nhật file
	 */
	@Override
	public boolean delEmployee(Person p) {
		if(p==null) return false;
		File f = new File(MyFiles.EMPLOYEE_FILE_PATH);
		// Đọc thông tin từ file
		ArrayList<Employee> employees = null;
		PrintWriter out = null;
		try {
			employees = MyFiles.readFileEmployee(f);
			// Tạo đối tượng thực thi ghi dữ liệu
			out = new PrintWriter(new FileWriter(f));
			for(Employee employee:employees) {
				// Kiểm tra xem mã nhân viên nhập vào có trong file hay không
				if(employee.getId_manage()==((Employee) p).getId_manage()) {
					employees.remove(employee);// xóa nhân viên khỏi danh sách
					break;
				}
			}
			// Cập nhật lại file 
			MyFiles.updateFile(employees,out);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			//Đóng luồng
			out.close();
		}
	}

	/**
	 * Phương thức tìm kiếm nhân viên theo tên
	 */
	@Override
	public ArrayList<Employee> searchEmployee(Person[] list, String name) {
		ArrayList<Employee> result = new ArrayList<Employee>();
		for(Person p : list) {
			String checkName = p.getLastName()+p.getFirstName();
			if(checkName.equals(name)) {
				result.add((Employee) p);
			}
		}
		return result;
	}
	/**
	 * Phương thức tìm kiếm nhân viên theo địa chỉ
	 */
	@Override
	public ArrayList<Employee> searchEmployee(Person[] list, Address addr) {
		ArrayList<Employee> result = new ArrayList<Employee>();
		for(Person p : list) {
			if(p.getAddress().equals(result)) {
				result.add((Employee) p);
			}
		}
		return result;
	}

	/**
	 * - Phương thức thêm nhân viên vào file và trả về danh sách nhân viên. <br/>
	 * - Trình tự thực hiện :Nhập Nhân viên -> Đọc file -> Thêm nhân viên -> cập nhật file
	 */
	@Override
	public ArrayList<Employee> addEmployee(File f) {
		ArrayList<Employee> employees = null;
		PrintWriter out = null;
		// Nhập mã nhân viên từ bàm phím
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		System.out.println("Nhập nhân viên muốn thêm: ");
		boolean checkInput = false;
		do {
			try {
				System.out.print("First name : ");
				employee.setFirstName(scanner.nextLine());
				System.out.print("Last name : ");
				employee.setLastName(scanner.nextLine());
				System.out.print("Age : ");
				employee.setAge(Byte.parseByte(scanner.nextLine()));
				System.out.print("NET : ");
				employee.setNet(Integer.parseInt(scanner.nextLine()));
				System.out.print("Position : ");
				employee.setPosition(scanner.nextLine());
				System.out.print("Apply year : ");
				employee.setApply_year(Short.parseShort(scanner.nextLine()));
				System.out.print("Depart id : ");
				employee.setDepart_id(Short.parseShort(scanner.nextLine()));
				checkInput = true;
			}catch (NumberFormatException e) {
				System.out.println("Lỗi nhập số");
				checkInput = false;
			}
			if(!checkInput) {
				System.out.println("Nhập lại mã nhân viên.");
			}
		}while(!checkInput);
		try {
			employees = MyFiles.readFileEmployee(f);
			// Tạo đối tượng thực thi ghi dữ liệu
			out = new PrintWriter(new FileWriter(f));
			employee.setId_manage(employees.size());
			employees.add(employee);
			// Sắp xếp nhân viên theo tuổi
			Collections.sort(employees);
			return MyFiles.updateFile(employees,out);
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}finally {
			// Đóng luồng
			out.close();
		}
	}
	/**
	 * -Phương thức chỉnh sửa nhân viên trong file Và trả về danh sách nhân viên. <br/>
	 * -Trình tự thực hiện :Nhập nhân viên -> Đọc file -> Chỉnh sửa nhân viên -> cập nhật file
	 */
	@Override
	public ArrayList<Employee> editEmployee(File f) {
		// Nhập mã nhân viên từ bàm phím
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		System.out.println("Nhập nhân viên muốn sửa: ");
		do {
			try {
				System.out.print("Id manage: ");
				employee.setId_manage(Integer.parseInt(scanner.nextLine()));
				System.out.print("First name : ");
				employee.setFirstName(scanner.nextLine());
				System.out.print("Last name : ");
				employee.setLastName(scanner.nextLine());
				System.out.print("Age : ");
				employee.setAge(Byte.parseByte(scanner.nextLine()));
				System.out.print("NET : ");
				employee.setNet(Integer.parseInt(scanner.nextLine()));
				System.out.print("Position : ");
				employee.setPosition(scanner.nextLine());
				System.out.print("Apply year : ");
				employee.setApply_year(Short.parseShort(scanner.nextLine()));
				System.out.print("Depart id : ");
				employee.setDepart_id(Short.parseShort(scanner.nextLine()));
			}catch (NumberFormatException e) {
				System.out.println("Lỗi nhập số");
			}
			if(employee.getId_manage()<0) {
				System.out.println("Mã nhân viên không hợp lệ! Nhập lại mã nhân viên.");
			}
		}while(employee.getId_manage()<0);
		// Đọc thông tin từ file
		ArrayList<Employee> employees = null;
		PrintWriter out = null;
		try {
			employees = MyFiles.readFileEmployee(f);
			// Tạo đối tượng thực thi ghi dữ liệu
			out = new PrintWriter(new FileWriter(f));
			for(int i = 0;i<employees.size();i++) {
				// Kiểm tra xem mã nhân viên nhập vào có trong file hay không
				if(employees.get(i).getId_manage()==employee.getId_manage()) {
					employees.set(i, employee);
					break;
				}
			}
			// Sắp xếp nhân viên theo tuổi
			Collections.sort(employees);
			return MyFiles.updateFile(employees,out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			//Đóng luồng
			out.close();
		}
	}

	/**
	 * -Phương thức xóa nhân viên ra khỏi file và trả về một danh sách nhân viên. <br/>
	 * -Trình tự thực hiện :Nhập mã viên -> Đọc file -> Xóa nhân viên -> Cập nhật file
	 */
	@Override
	public ArrayList<Employee> delEmployee(File f) {
		// Nhập mã nhân viên muốn xóa từ bàm phím
		Scanner scanner = new Scanner(System.in);
		int id_manage=-1;
		do {
			System.out.print("Nhập mã nhân viên muốn xóa: ");
			
			try {
				// Ép kiểu cho mã nhân viên về kiểu int
				id_manage = Integer.parseInt(scanner.next());
			}catch (NumberFormatException e) {
				System.out.println("Mã nhân viên không hợp lệ!");
			}
			// Nếu mã nhân viên âm thì  yêu cầu nhập lại
			if(id_manage<0) {
				System.out.println("Nhập lại mã nhân viên.");
			}
		}while(id_manage<0);
		// Đọc thông tin từ file
		ArrayList<Employee> employees = null;
		// Tạo đối tượng thực thi ghi dữ liệu
		PrintWriter out = null;
		try {
			// Đọc file nhân viên và lưu vào biến danh sách nhân viên
			employees = MyFiles.readFileEmployee(f);
			// Khởi tạo đối tượng thực thi ghi dữ liệu
			out = new PrintWriter(new FileWriter(f));
			// Thực hiện kiểm tra từng nhân viên
			for(Employee employee:employees) {
				// Kiểm tra xem mã nhân viên nhập vào có trong file hay không
				if(employee.getId_manage()==id_manage) {
					// xóa nhân viên khỏi danh sách và thoát khỏi vòng lặp
					employees.remove(employee);
					break;
				}
			}
			return MyFiles.updateFile(employees,out);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			//Đóng luồng thực thi ghi dữ liệu
			out.close();
		}
	}
	
	
}
