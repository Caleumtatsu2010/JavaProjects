package objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PhotographyMobile extends Mobile
{
	private byte module_camera;
	private String holographic_display;
	
	
	public PhotographyMobile(int mobile_id, List<String> mobile_monitor, byte mobile_os, byte moblile_front_camera,
			byte moblile_behind_camera, byte mobile_cpu, byte module_camera, String holographic_display) {
		super(mobile_id, mobile_monitor, mobile_os, moblile_front_camera, moblile_behind_camera, mobile_cpu);
		this.module_camera = module_camera;
		this.holographic_display = holographic_display;
	}

	
	public PhotographyMobile() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PhotographyMobile(int mobile_id, List<String> mobile_monitor, byte mobile_os, byte moblile_front_camera,
			byte moblile_behind_camera, byte mobile_cpu) {
		super(mobile_id, mobile_monitor, mobile_os, moblile_front_camera, moblile_behind_camera, mobile_cpu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() 
	{
		return "\nIn ra các thuộc tính của lớp cha Mobile và lớp con PhotographyMobile"+super.toString()+"\nPhotographyMobile [module_camera=" + module_camera + ", holographic_display=" + holographic_display + "]";
	}
	public byte getModule_camera() 
	{
		return module_camera;
	}
	
	public void setModule_camera(byte module_camera) 
	{
		this.module_camera = module_camera;
	}
	
	public String getHolographic_display()
	{
		return holographic_display;
	}
	
	public void setHolographic_display(String holographic_display) 
	{
		this.holographic_display = holographic_display;
	}


	


}
