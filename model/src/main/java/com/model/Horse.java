package com.model;
import java.util.Random;
import java.util.ArrayList;


public class Horse {
	private String name;
	private String warcry;
	private boolean healthy;
	private int distanceTraveled=0;
	private int totalDistanceTraveled=0;
	public ArrayList<Integer> speedList= new ArrayList<Integer>();


	public Horse(String name, boolean healthy, String warcry) {
		this.name = name;
		this.healthy = healthy;
		this.warcry = warcry;
	}

	public String getWarcry(){
		return warcry;
	}

	public String getName() {
		if(healthy) {
			return name.toUpperCase();
		}else {
			return name;
		}
	}

	public void setHealth(boolean healthy) {
		this.healthy = healthy;
	}

	public boolean getHealth() {
		return healthy;
	}

	public int getDistanceTraveled() {
		return distanceTraveled;
	}

	public int getTotalDistanceTraveled() {
		return totalDistanceTraveled;
	}

	public void setDistanceTraveled(int distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}

	public void setTotalDistanceTraveled(int distanceTraveled) {
		this.totalDistanceTraveled = distanceTraveled;
	}

	//
	// public void runTo(int distance) {
	// 	distanceTraveled = 0;
	// 	try{
	// 		while(distanceTraveled < distance) {
	// 			int speed = gallop();
	// 			if(distanceTraveled > distance) {
	// 				totalDistanceTraveled -= distanceTraveled - distance;
	// 				distanceTraveled = distance;
	// 			}
	// 			System.out.println(name + "\t Speed: " + speed + "\t Distance Traveled: " + distanceTraveled + "\t Distance Left:" + (distance - distanceTraveled) + "\t Total Distance Traveled: " + totalDistanceTraveled );
	// 		}
	// 		System.out.println(name + "\t is finished. \t" + this.warcry);
	// 	}catch(Exception ex) {
	// 		ex.printStackTrace();
	// 	}
	// }

	public ArrayList<Integer> getSpeedList() {
		return speedList;
	}

	public int getCurrentSpeed() {
		Random r = new Random();
		return r.nextInt(10);
	}

	@Override
	public String toString() {
		return "Name: " + name.toLowerCase() + "| healthy: " + healthy + "| Warcry: " + warcry ;
	}
}
