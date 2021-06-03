package Exercise1;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		File file = new File(MyFiles.EMPLOYEE_FILE_PATH);

		ManagerEmployee employeeManager = new ManagerEmployee();
		
		Person p = Utilities.generateEmployee(1).get(0);
		
		((Employee) p).setId_manage(17);

		// Thêm nhân viên trả về danh sách nhân viên
		employeeManager.addEmployee(file).forEach(e->{
			System.out.println(e.toString());
		});
		// Chỉnh sửa nhân viên trả về danh sách nhân viên
//		employeeManager.editEmployee(file).forEach(e->{
//			System.out.println(e.toString());
//		});
		
		// xóa nhân viên khỏi file và trả về danh sách nhân viên
//		employeeManager.delEmployee(file).forEach(e->{
//			System.out.println(e.toString());
//		});
		
	}
}
