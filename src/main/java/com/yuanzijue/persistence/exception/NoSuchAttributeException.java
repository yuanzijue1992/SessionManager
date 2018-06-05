package com.yuanzijue.persistence.exception;

public class NoSuchAttributeException extends Exception{
	
	public NoSuchAttributeException() {
		super("no such attribute in configuration");
	}	

}
