package com.entity;

public class Car {
	
	int car_id;
	String name;
	String color;
	String speed;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int car_id, String name, String color, String speed) {
		super();
		this.car_id = car_id;
		this.name = name;
		this.color = color;
		this.speed = speed;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", name=" + name + ", color=" + color + ", speed=" + speed + "]";
	}
	
	

}
