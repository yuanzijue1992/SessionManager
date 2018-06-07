package com.yuanzijue.persistence.exception;

public class NoSuchAttributeException extends Exception{
	
	private String attribute;
	
	public NoSuchAttributeException(String attribute) {
		super();
		this.attribute=attribute;
	}

	@Override
	public void printStackTrace() {
		System.out.println("no such attribute: "+attribute);
		super.printStackTrace();
	}
		

}
