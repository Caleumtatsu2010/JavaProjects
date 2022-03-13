package cau2;
import cau1.*;
import java.io.File;
import java.util.*;

public interface FileManager extends Manager 
{
	public ArrayList<Employee> addEmployee(File f);
	public ArrayList<Employee> editEmployee(File f);
	public ArrayList<Employee> delEmployee(File f);

}
