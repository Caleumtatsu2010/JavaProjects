package objects;

import java.util.*;

public class Mobile 
{
	//Object's properties
	private int mobile_id;
	private List<String> mobile_monitor; 
	private byte mobile_os;
	private byte moblile_front_camera;
	private byte moblile_behind_camera;
	private byte mobile_cpu;
	public Mobile(int mobile_id, List<String> mobile_monitor, byte mobile_os, byte moblile_front_camera, byte moblile_behind_camera, byte mobile_cpu) 
	{
		super();
		this.mobile_id = mobile_id;
		this.mobile_monitor = mobile_monitor;
		this.mobile_os = mobile_os;
		this.moblile_front_camera = moblile_front_camera;
		this.moblile_behind_camera = moblile_behind_camera;
		this.mobile_cpu = mobile_cpu;
	}
	public Mobile() 
	{
		super();
		
	}
	@Override
	public String toString() 
	{
		return "Mobile [mobile_id=" + mobile_id + ", mobile_monitor=" + mobile_monitor + ", mobile_os=" + mobile_os
				+ ", moblile_front_camera=" + moblile_front_camera + ", moblile_behind_camera=" + moblile_behind_camera
				+ ", mobile_cpu=" + mobile_cpu + "]";
	}
	public int getMobile_id() {
		return mobile_id;
	}
	public void setMobile_id(int mobile_id) {
		this.mobile_id = mobile_id;
	}
	public List<String> getMobile_monitor() {
		return mobile_monitor;
	}
	public void setMobile_monitor(List<String> mobile_monitor) {
		this.mobile_monitor = mobile_monitor;
	}
	public byte getMobile_os() {
		return mobile_os;
	}
	public void setMobile_os(byte mobile_os) {
		this.mobile_os = mobile_os;
	}
	public byte getMoblile_front_camera() {
		return moblile_front_camera;
	}
	public void setMoblile_front_camera(byte moblile_front_camera) {
		this.moblile_front_camera = moblile_front_camera;
	}
	public byte getMoblile_behind_camera() {
		return moblile_behind_camera;
	}
	public void setMoblile_behind_camera(byte moblile_behind_camera) {
		this.moblile_behind_camera = moblile_behind_camera;
	}
	public byte getMobile_cpu() {
		return mobile_cpu;
	}
	public void setMobile_cpu(byte mobile_cpu) {
		this.mobile_cpu = mobile_cpu;
	}

	
	
	
	
}
