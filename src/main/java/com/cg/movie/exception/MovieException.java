package com.cg.movie.exception;
//it is a class which extends the exception class
public class MovieException extends Exception {

	//contructor with field
	public MovieException(String message)
	{
		super(message);
	}
	
	public MovieException()
	{
		super();
	}
}
