package utilities;

import java.util.*;

import objects.Person;

public class MyPerson 
{
	//phương thức sinh giá trị nguyên ngẫu nhiên
	public static int randomValue(int range)
	{
		int max = range-1;
		int min = 0;
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	//phương thức sinh đối tượng lớp Person ngẫu nhiên
	public static List<Person> generatePerson(int n)
	{
		String [] lastname = {"Nguyễn", "Vũ", "Lưu", "Hoàng", "Tạ", "Trần", "Phạm", "Nguyễn", "Võ", "Chu", "Hà", "Khuất", "Phan", "Nguyên"};
		String [] firstname = {"Anh","An","Huy", "Thanh", "Anh", "Cường","Dũng", "Long", "Thanh", "Dương", "Hoàng", "Kiên", "Lâm", "Mạnh", "Long","Minh", "Thành", "Bình", "Huy" };

		List<Person> list = new ArrayList<Person>();
		for(int i=0;i<n;i++)
		{
			int index;
			Person p = new Person();
			
			index=randomValue(firstname.length);
			p.setFirstName(firstname[index]);
			
			index=randomValue(lastname.length);
			p.setLastName(lastname[index]);
			
			index=1 + randomValue(80); 
			p.setAge(index);
			
			list.add(p);
		
		}
		return list;
	}
	
	//CÂU 1A SẮP XẾP DANH SÁCH PERSON THEO TÊN VÀ TÊN ĐỆM SỬ DỤNG COMPARABLE
	public static List<Person> sortByNameComparable(List<Person> listPerson, boolean isINC)
	{
		if(isINC == true)
		{
			Collections.sort(listPerson);
		}
		else
		{
			Collections.sort(listPerson);
			Collections.reverse(listPerson);
		}
		return listPerson;
		
	}
	
	//CÂU 1B SẮP XẾP DANH SÁCH PERSON THEO TÊN VÀ TÊN ĐỆM SỬ DỤNG COMPARATOR
	public static List<Person> sortByNameComparator(List<Person> listPerson, boolean isINC)
	{
		byte oriented = (byte) ((isINC) ? 1 : -1);
		Collections.sort(listPerson, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) 
            {
            	 int resFirst = oriented*o1.getFirstName().compareTo(o2.getFirstName());
                 if (resFirst != 0) 
                 {
                    return resFirst;
                 } else 
                 {
                	int resLast = oriented*o1.getLastName().compareTo(o2.getLastName());
                    return resLast;
                 }
                
            }
        });
		return listPerson;
	}
	
	//phương thức in danh sách person
	public static void printPerson(List<Person> list)
	{
		for(Person p:list)
		{
			System.out.println(p.toString());
		}
		System.out.println();
		
	}
	public static void main(String[] args) {
		System.out.println("Danh sách Person vừa khởi tạo");
		List<Person> list = generatePerson(7);
		printPerson(list);
		
		System.out.println("Danh sách Person sau khi sắp xếp theo chiều Alphabet với Comparable");
		List<Person> sortedList = sortByNameComparable(list, true);
		printPerson(sortedList);
		
		System.out.println("Danh sách Person sau khi sắp xếp ngược chiều Alphabet với Comparable");
		List<Person> sortedList2 = sortByNameComparable(list, false);
		printPerson(sortedList2);
		
		System.out.println("Danh sách Person sau khi sắp xếp theo chiều Alphabet với Comparator");
		List<Person> sortedList3 = sortByNameComparator(list, true);
		printPerson(sortedList3);
		
		System.out.println("Danh sách Person sau khi sắp xếp ngược chiều Alphabet với Comparator");
		List<Person> sortedList4 = sortByNameComparator(list, false);
		printPerson(sortedList4);

		
		
	}

}
