package Exercise2;

import java.util.ArrayList;

import Exercise1.Address;
import Exercise1.Employee;
import Exercise1.Person;

public interface IManagerEmployee {

	public boolean addEmployee(Person p);

	public boolean editEmployee(Person p);

	public boolean delEmployee(Person p);

	public ArrayList<Employee> searchEmployee(Person[] list, String name);

	public ArrayList<Employee> searchEmployee(Person[] list, Address addr);

}
