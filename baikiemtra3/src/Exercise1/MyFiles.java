package Exercise1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class MyFiles {

	public static final String EMPLOYEE_FILE_PATH = "ListEmployee.txt";

	/**
	 * Phương thức ghi danh sách nhân viên được tạo ngẫu nhiên vào file
	 * @param numberOfEployees
	 * @throws IOException
	 */
	public static void generateFileEmployee(int numberOfEployees) throws IOException {
		// Sinh ngẫu nhên danh sách nhân viên
		ArrayList<Employee> employees = Utilities.generateEmployee(numberOfEployees);
		// Sắp xếp nhân viên theo tuổi
		Collections.sort(employees);
		// xác định tệp tin
		FileWriter outFileWriter = new FileWriter(EMPLOYEE_FILE_PATH);
		// Tạo đối tượng thực thi ghi dữ liệu
		PrintWriter out = new PrintWriter(outFileWriter);
		updateFile(employees,out);
		// Đóng đối tượng thực thi ghi dữ liệu
		out.close();
	}

	/**
	 * Phương thức đọc thông tin của nhân viên từ file
	 * @param f
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Employee> readFileEmployee(File f) throws IOException {
		// Biến lưu danh sách nhân viên khi đọc từ file
		ArrayList<Employee> employees = new ArrayList<Employee>();
		// Xác định file để đọc dữ liệu
		FileReader inFileReader = new FileReader(f);
		// Khai báo bộ đệm đọc
		BufferedReader in = new BufferedReader(inFileReader);
		// Lưu từng dòng của file
		String line = "";
		byte count = 0;// Biến đến để bỏ qua dòng không cần thiết trong file
		// Đọc từng dòng trong file và lưu từng dòng vào biến line
		while ((line = in.readLine()) != null) {
			
			// Đếm nếu < 5 dòng thì tăng biến đếm lên 1 đơn vị
			// Ngược lại dữ nguyên
			count = (byte) (count < 5 ? count + 1 : count);
			// Bỏ qua 4 dòng đầu tiên của file không đọc
			if (count < 5)
				continue;
			/*
			 * Dùng "\\|" thay cho "|". Bởi vì phương thức split nhận một biểu thức chính
			 * quy, và | là một trong những ký tự đặc biệt. Nó có nghĩa là 'or'. Điều đó có
			 * nghĩa là bạn đang tách bởi '' hoặc '', chỉ là ''. Do đó nó sẽ phân chia giữa
			 * mọi ký tự.
			 */
			String[] data = line.substring(1, line.length() - 2).split("\\|");
			// Thêm kết quả đã xử lý vào danh sách nhân viên
			employees.add(new Employee(data[2].trim(), data[1].trim(), Byte.parseByte(data[3].trim()), 
					new Address(data[4].trim(),data[5].trim(),data[6].trim()),
					Integer.parseInt(data[0].trim()), Integer.parseInt(data[7].trim()), data[8].trim(),
					Short.parseShort(data[9].trim()), Short.parseShort(data[10].trim())));

		}
		// Đóng luồng
		in.close();
		return employees;
	}
	
	/**
	 * Phương thức cập nhật file khi thên, sửa hoặc xóa nhân viên trong file
	 * @param employees
	 * @param out
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<Employee> updateFile(ArrayList<Employee> employees,PrintWriter out) throws IOException {
		
		// Ghi các loại dữ liệu
		out.println("-------------- DANH SÁCH NHÂN VIÊN ( TỔNG SỐ: "+employees.size()+" ) -------------- ");
		StringBuffer line = new StringBuffer();
		for(int i = 0;i<153;i++) {
			line.append("-");
		}
		out.println(line.toString());
		//Đinh dạng tiêu đề bảng
		//%-12s : sẽ in chuỗi như tham số đầu vào. Nếu số chữ số nhỏ hơn 12, đầu ra sẽ được thêm khoảng trắng ở bên phải.
		String header = String.format("|%-12s|%-12s|%-12s|%-12s|%-15s|%-15s|%-15s|%-12s|%-12s|%-12s|%-12s|",
				"ID MANAGE", "LAST NAME","FIRST NAME", "AGE","CITY NAME","DISTRICT NAME",
				"STREET NAME", "NET", "POSITION", "APPL YEAR", "DEPART ID");
		out.println(header);
		out.println(line.toString());
		// Biến lưu từng dòng của văn bản có định dạng
		String row = "";
		for (Employee employee : employees) {
			// Định dạng văn bản sẽ ghi vào file.
			row = String.format("|%-12s|%-12s|%-12s|%-12s|%-15s|%-15s|%-15s|%-12s|%-12s|%-12s|%-12s|", employee.getId_manage(),
					employee.getLastName(), employee.getFirstName(), employee.getAge(), employee.getAddress().getCityName(),
					employee.getAddress().getDistrictName(),employee.getAddress().getStreetName(),employee.getNet(),
					employee.getPosition(), employee.getApply_year(), employee.getDepart_id());
			// In dòng vừa định dạng ra file
			out.println(row);
		}
		return employees;
	}

}
