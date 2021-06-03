package Exercise1;

import java.util.ArrayList;



public class Utilities {
	/**
	 * Phương thức này được xây dựng để sinh <b> ngẫu nhiêm</b> một giá trị nguyên trong khoảng từ 0 đến mã -value 
	 * @param max_value
	 * @return
	 */
	public static int randomValue(int max_value) {
		return (int) (Math.random() * max_value);
	}

	/**
	 * Phương thức sinh ngẫu nhiên một danh sách nhân viên
	 *
	 * @return
	 */
	public static ArrayList<Employee> generateEmployee(int n) {
		// Danh sách trung gian
		ArrayList<Employee> listEmployee = new ArrayList<>();
		// Khai báo một mảng cace tên
		String[] firstNames = { "Anh", "Tuấn Anh", "Anh Tuấn", "Vương Anh", "Bảo", "Bảo Hân", "Bảo Yến", "Linh",
				"Cương", "Hòa", "Trang", "Thủy", "Châu", "Minh", "Minh Châu", "Hưng", "Hùng", "Tài", "Vũ",
				"Mạnh Cương" };
		// Khai báo danh sách họ
		String[] lastNames = { "Lưu", "Hoàng", "Lê", "Trần", "Ngô", "Đoàn", "Phạm", "Trương", "Lương", "Phùng", "Quách",
				"Nguyễn", "Đào", "Vũ", "Phan" };

		// Sinh ngẫu nhiên các giá trị cho các phần tử đối tượng mảng
		int index;
		
		for (int i = 0; i < n; i++) {
			// Cấp phát bộ nhớ cho từng phần tử
			Employee e = new Employee();
			// sinh tên
			index = Utilities.randomValue(firstNames.length);
			e.setFirstName(firstNames[index]);
			// sinh họ
			index = Utilities.randomValue(lastNames.length);
			e.setLastName(lastNames[index]);
			// sinh tuổi
			index = 18 + Utilities.randomValue(5);
			e.setAge((byte) index);
			// Mã nhân viên được random tự đông
			e.setId_manage(i);
			listEmployee.add(e);
		}
		return listEmployee;
	}
}
