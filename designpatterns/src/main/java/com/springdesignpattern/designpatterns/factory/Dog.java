package com.springdesignpattern.designpatterns.factory;

public class Dog implements Pet{

	private String name;
	
	private boolean hungry;
	
	public Dog()
	{
		super();
		this.hungry=true;
	}
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "DOG";
	}

	@Override
	public boolean isHungry() {
		// TODO Auto-generated method stub
		return this.hungry;
	}

	@Override
	public void feed() {
		// TODO Auto-generated method stub
		this.hungry=false;
	}

}
