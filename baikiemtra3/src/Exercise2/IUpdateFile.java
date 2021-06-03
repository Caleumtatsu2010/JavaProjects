package Exercise2;

import java.io.File;
import java.util.ArrayList;

import Exercise1.Address;
import Exercise1.Employee;
import Exercise1.Person;

public interface IUpdateFile {

	public ArrayList<Employee> addEmployee(File f);

	public ArrayList<Employee> editEmployee(File f);

	public ArrayList<Employee> delEmployee(File f);

}
