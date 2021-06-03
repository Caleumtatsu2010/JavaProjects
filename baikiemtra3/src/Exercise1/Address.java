package Exercise1;

public class Address{
	// constants
	public static final String CITYNAME = "No CityName";
	public static final String DISTRICTNAME = "No DistrictName";
	public static final String STREETNAME = "No StreetName";


	// object's properties - 0
	private String cityName;
	private String districtName;
	private String streetName;

	// constructor - 1
	public Address() {
		this(Address.CITYNAME, Address.DISTRICTNAME, Address.STREETNAME);
	}

	public Address(String cityName, String districtName, String streetName) {
		this.cityName = cityName;
		this.districtName = districtName;
		this.streetName = streetName;
	}

	public Address(Address addr) {
		// ĐẶC BIỆT LOẠI 3
		this(addr.getCityName(), addr.getDistrictName(), addr.getStreetName());
	}

	// getter methods - 2
	public String getCityName() {
		return cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public String getStreetName() {
		return streetName;
	}
	// setter methods - 3

	public void setCityName(String cityName) {
		this.cityName = cityName;
		return;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
		return;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
		return;
	}

	@Override
	public String toString() {
		return "Address [cityName=" + cityName + ", districtName=" + districtName + ", streetName=" + streetName + "]";
	}

	

}
