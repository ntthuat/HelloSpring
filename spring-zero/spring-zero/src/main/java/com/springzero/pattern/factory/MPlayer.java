package com.springzero.pattern.factory;

public class MPlayer implements Product{

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MPlayer(int id) {
		super();
		this.id = id;
	}
	
	public MPlayer() {
		super();
	}

	@Override
	public void show() {
		System.out.println("Showing Mplayer");
	}

}
