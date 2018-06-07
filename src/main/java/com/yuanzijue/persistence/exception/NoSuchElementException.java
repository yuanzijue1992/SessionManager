package com.yuanzijue.persistence.exception;

public class NoSuchElementException extends Exception{
	
	private String element;
	
	public NoSuchElementException(String element) {
		super();
		this.element=element;
	}

	@Override
	public void printStackTrace() {
		System.out.println("no such element: "+element);
		super.printStackTrace();
	}

}
