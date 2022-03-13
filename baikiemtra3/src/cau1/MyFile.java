package cau1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MyFile
{
	//Phương thức ghi dữ liệu ra file có đường dẫn truyền vào, và danh sách nhân viên 
	public static void textOutputFile(String filepath, ArrayList<Employee> list) throws IOException 
	{
			//xác định tệp tin lưu trữ dữ liệu 
			FileWriter outFileWriter = new FileWriter(filepath);
			
			//tạo đối tượng thực thi ghi dữ liệu
			PrintWriter out = new PrintWriter(outFileWriter);
			
			//ghi tiêu đề ra file
			out.println("\t\tDANH SACH EMPLOYEE");
			out.println(String.format("%-10s%-10s%-10s%-10s%-10s%-45s%-10s%-10s%-10s%-10s","STT" ,"ID", "FirstName", "LastName", "Age", "Address",
					"Net", "Position", "ApplyYear", "DepartId"));
			out.println("-----------------------------------------------------------------");
			//Ghi từng nhân viên trong list ra file
			for(int i=0;i<list.size();i++)
			{
				//Định dạng và ghi dữ liệu ghi ra file
				out.println(String.format("%-10d%-10d%-10s%-10s%-10d%-45s%-10d%-10s%-10d%-10d",i+1, list.get(i).getId() ,list.get(i).getFirstName(), list.get(i).getLastName(), list.get(i).getAge(), list.get(i).getAddress(),
						list.get(i).getNet(), list.get(i).getPosition(), list.get(i).getApply_year(), list.get(i).getDepart_id()));
			}
			//Đóng luồng
			out.close();

	}
	//đọc dữ liệu từ file có đường dẫn truyền vào
	public static ArrayList<Employee> textInputFile(String filepath) throws IOException 
	{
		ArrayList<Employee> list=null;
			//xác định tệp tin lưu trữ dữ liệu 
			FileReader inFileReader = new FileReader(filepath);
			
			//Khai báo bộ đệm đọc
			BufferedReader in = new BufferedReader(inFileReader);
			
			//khởi tạo danh sách dữ liệu trả về
			list = new ArrayList<Employee>();
			
			//Bỏ qua 3 dòng đầu không đọc
			String l1 = in.readLine();
			String l2 = in.readLine();
			String l3 = in.readLine();
			
			//Đếm số dòng trong danh sách file
			Path file = Paths.get(filepath);
			long count = Files.lines(file).count();
			
			//Bắt đầu đọc từ dòng 4
			//Cắt dòng đọc được thành 1 mảng
			for(int i=0;i<count-3;i++)
			{
				String line = in.readLine();
				while(line.indexOf("  ") != -1)
				{
					// Thay 2 cách = 1 dấu cách trong dòng đọc được
					line = line.replace("  ", " ");
				}
				
				//Cắt dòng đọc được thành 1 mảng bằng dấu cách
				String []emp = line.split(" ");
				
				//Lưu mảng cắt từ phần tử thứ 5, 6, 7 vào Address
				Address a = new Address(emp[7], emp[6], emp[5]);
				
				//Nạp từng phần tử của mảng vào employee
				Employee employee = new Employee(Integer.parseInt(emp[1]), emp[2], emp[3], Integer.parseInt(emp[4]), a , Integer.parseInt(emp[8]), emp[9], Short.parseShort(emp[10]), Short.parseShort(emp[11]));
				//Thêm nhân viên vào mảng
				list.add(employee);
			}

			//Đóng luồng
			in.close();
		return list;
		
	}
}
