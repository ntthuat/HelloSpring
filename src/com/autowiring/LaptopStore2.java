package com.autowiring;

//Class này ví dụ cho autowiring by type
public class LaptopStore2 {
	
	// mấu chốt là ở đây
	private AcerLatop laptop1;
	private LenovoLaptop laptop2;
	
	
	public AcerLatop getLaptop1() {
		return laptop1;
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
