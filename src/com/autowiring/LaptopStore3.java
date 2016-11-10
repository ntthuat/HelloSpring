package com.autowiring;

//Class này ví dụ cho autowiring by constructor
public class LaptopStore3 {
	private AcerLatop laptop1;
	private LenovoLaptop laptop2;
	
	//Mấu chốt là ở đây
	
	public AcerLatop getLaptop1() {
		return laptop1;
	}
	public LaptopStore3(AcerLatop laptop1, LenovoLaptop laptop2) {
		super();
		this.laptop1 = laptop1;
		this.laptop2 = laptop2;
	}
	
	public void setLaptop1(AcerLatop laptop1) {
		this.laptop1 = laptop1;
	}
	public LenovoLaptop getLaptop2() {
		return laptop2;
	}
	public void setLaptop2(LenovoLaptop laptop2) {
		this.laptop2 = laptop2;
	}
	
}
