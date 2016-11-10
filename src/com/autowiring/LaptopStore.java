package com.autowiring;

//Class này ví dụ cho autowiring by name
public class LaptopStore {
	Laptop laptop1;
	Laptop laptop2;
	public Laptop getLaptop1() {
		return laptop1;
	}
	public void setLaptop1(Laptop laptop1) {
		this.laptop1 = laptop1;
	}
	public Laptop getLaptop2() {
		return laptop2;
	}
	public void setLaptop2(Laptop laptop2) {
		this.laptop2 = laptop2;
	}
}
