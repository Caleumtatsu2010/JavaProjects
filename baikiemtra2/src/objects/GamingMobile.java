package objects;

import java.util.List;

public class GamingMobile extends Mobile
{
	private String gpu;
	private String module_batery;
	
	public GamingMobile(int mobile_id, List<String> mobile_monitor, byte mobile_os, byte moblile_front_camera,
			byte moblile_behind_camera, byte mobile_cpu, String gpu, String module_batery) {
		super(mobile_id, mobile_monitor, mobile_os, moblile_front_camera, moblile_behind_camera, mobile_cpu);
		this.gpu = gpu;
		this.module_batery = module_batery;
	}
	
	public GamingMobile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GamingMobile(int mobile_id, List<String> mobile_monitor, byte mobile_os, byte moblile_front_camera,
			byte moblile_behind_camera, byte mobile_cpu) {
		super(mobile_id, mobile_monitor, mobile_os, moblile_front_camera, moblile_behind_camera, mobile_cpu);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() 
	{
		return "\nIn ra các thuộc tính của lớp cha Mobile và lớp con GamingMobile"+super.toString()+"\nGamingMobile [gpu=" + gpu + ", module_batery=" + module_batery + "]";
	}

	public String getGpu() 
	{
		return gpu;
	}
	
	public void setGpu(String gpu) 
	{
		this.gpu = gpu;
	}
	
	public String getModule_batery() 
	{
		return module_batery;
	}
	
	public void setModule_batery(String module_batery) 
	{
		this.module_batery = module_batery;
	}
	

	
	

	
	
	
	
	
	

}
