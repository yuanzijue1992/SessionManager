package com.yuanzijue.persistence.exception;

public class NoTableException extends Exception{
	
	public NoTableException() {
		super("no table in configuration");
	}

}
