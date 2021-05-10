package cau2;
import cau1.*;
import java.util.*;

import cau1.Address;
import cau1.Employee;
import cau1.Person;

public interface Manager 
{
	public boolean addEmployee(Person p, String filepath);
	public boolean editEmployee(Person p, String filepath);
	public boolean delEmployee(Person p, String filepath);
	public ArrayList<Employee> searchEmployee(Person[] list, String name);
	public ArrayList<Employee> searchEmployee(Person[] list, Address addr);

}
