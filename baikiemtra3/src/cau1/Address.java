package cau1;

public class Address 
{
	public static final String CITYNAME = "NoCityName";
	public static final String DISTRICTNAME = "NoDistrictName";
	public static final String STREETNAME = "NoStreetName";
	
	private String cityName;
	private String districName;
	private String streetName;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDistricName() {
		return districName;
	}
	public void setDistricName(String districName) {
		this.districName = districName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public Address(String cityName, String districName, String streetName) {
		super();
		this.cityName = cityName;
		this.districName = districName;
		this.streetName = streetName;
	}

	public Address() {
		this(Address.CITYNAME, Address.DISTRICTNAME, Address.STREETNAME);
	}
	@Override
	public String toString() {
		return streetName+" "+districName+" "+cityName;
	}
}
