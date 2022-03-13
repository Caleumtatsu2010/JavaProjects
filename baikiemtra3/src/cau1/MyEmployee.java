package cau1;


import java.io.*;
import java.util.*;

public class MyEmployee 
{
	//phương thức sinh giá trị nguyên ngẫu nhiên
	public static int randomValue(int range)
	{
		int max = range-1;
		int min = 0;
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	//phương thức sinh đối tượng lớp Employee ngẫu nhiên
	public static Employee[] generateEmployee(int n)
	{
		String [] lastname = {"Nguyễn", "Vũ", "Lưu", "Hoàng", "Tạ", "Trần", "Phạm", "Nguyễn", "Võ", "Chu", "Hà", "Khuất", "Phan", "Nguyên"};
		String [] firstname = {"Anh","An","Huy", "Thanh", "Anh", "Cường","Dũng", "Long", "Thanh", "Dương", "Hoàng", "Kiên", "Lâm", "Mạnh", "Long","Minh", "Thành", "Bình", "Huy" };

		Employee []list = new Employee[n];
		for(int i=0;i<list.length;i++)
		{
			list[i] = new Employee();
		}
		for(int i=0;i<n;i++)
		{
			int index;
			//Khởi tạo  nhân viên mới
			Employee p = new Employee();
			
			//Sinh ngẫu nhiên firstname
			index=randomValue(firstname.length);
			list[i].setFirstName(firstname[index]);
			
			//Sinh ngẫu nhiên lastname
			index=randomValue(lastname.length);
			list[i].setLastName(lastname[index]);
			
			//Sinh ngẫu nhiên age
			index=1 + randomValue(80); 
			list[i].setAge(index);
			
		}
		return list;
	}
	// sắp xếp danh sách person theo tuổi
	public static ArrayList<Employee> sortByAge(Employee[] list)
	{
		//Khởi tạo mảng kết quả
		ArrayList<Employee> tmp = new ArrayList<>();
		Collections.addAll(tmp, list);
		//Sắp xếp
		Collections.sort(tmp);
		return tmp;
	}
	
	// sắp xếp danh sách person theo tên 
	public static ArrayList<Employee> sortByName(Employee[] list)
	{
		//Khởi tạo mảng kết quả
		ArrayList<Employee> tmp = new ArrayList<>();
		Collections.addAll(tmp, list);
		//Sắp xếp
		Collections.sort(tmp, new Comparator<Employee>() {
			@Override
			//Ghi đè phương thức compare, cài đặt tiêu chí
			public int compare(Employee o1, Employee o2) 
			{	 //so sánh firstname
	           	 int resFirst = o1.getFirstName().compareTo(o2.getFirstName());
	             if (resFirst != 0) 
	             {
	                return resFirst;
	             } else //nếu first name trùng thì so sánh lastname
	             {
	            	int resLast = o1.getLastName().compareTo(o2.getLastName());
	                return resLast;
	             }
			}
		});
		return tmp;
	}
	//Phương thức in danh sách Employee
	public static void printEmployee(List<Employee> list)
	{
		for(int i=0;i<list.size();i++)
		{
			System.out.println((i+1)+" "+list.get(i).toString());
		}
		System.out.println();
		
	}
	public static void main(String[] args) throws IOException {
		Employee[] list = generateEmployee(5);
		List<Employee> l = new ArrayList<>();
		Collections.addAll(l, list);

		System.out.println("Danh sách Employee vừa khởi tạo");
		printEmployee(l);
	
		ArrayList<Employee> sortedList = sortByAge(list);
		System.out.println("Danh sách Employee sau khi sắp xếp theo tuổi");
		printEmployee(sortedList);
	
		MyFile.textOutputFile("danhsach.txt", sortedList);

		ArrayList<Employee> sortedList2 = sortByName(list);
		System.out.println("Danh sách Employee sau khi sắp xếp tên");
		printEmployee(sortedList2);
		
		
		MyFile.textOutputFile("danhsach.txt", sortedList2);
		
		printEmployee(MyFile.textInputFile("danhsach.txt"));
	}
		

}
