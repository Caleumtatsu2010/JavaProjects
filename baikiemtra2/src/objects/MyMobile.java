package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMobile 
{
	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList("LCD IPS", "6.5", "HD+"));
		
		Mobile mobile = new Mobile(1001, list, (byte) 10, (byte) 12,(byte) 8, (byte) 84);
		System.out.println(mobile.toString());
		
		List<String> list2 = new ArrayList<String>();
		list2.addAll(Arrays.asList("PLS", "5.94", "Full HD"));
		
		mobile = new PhotographyMobile(1005, list2, (byte) 8, (byte) 32,(byte) 15, (byte) 50, (byte) 30, "Red Hydrogen 2");
		System.out.println(mobile.toString());
		
		List<String> list3 = new ArrayList<String>();
		list3.addAll(Arrays.asList("PTS TFT", "6", "Full HD plus"));
		
		mobile = new GamingMobile(1008, list3, (byte) 12, (byte) 40,(byte) 20, (byte) 88, "Gigabyte gtx 165", "Enerzier p 1230");
		System.out.println(mobile.toString());
		
	}
}
