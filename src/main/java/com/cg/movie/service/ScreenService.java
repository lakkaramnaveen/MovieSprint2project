package com.cg.movie.service;

import java.util.List;

import com.cg.movie.entity.Login;
import com.cg.movie.entity.Screen;
import com.cg.movie.entity.Theater;
import com.cg.movie.exception.MovieException;

public interface ScreenService {
	public Login findUser(String username , String password) throws MovieException;
	public List<Screen> findByTheaterId(int theaterId) throws MovieException;
	public  List<Screen>   findAllScreens() throws MovieException;
	public Screen createScreen(Screen screen) ;
	public Screen deleteScreenById(int screenId) throws MovieException;
	public  Screen  findScreenById(int screenId) throws MovieException;
	public Theater createTheater(Theater theater);
	public List<Theater> findAllTheaters() throws MovieException;
	public Theater deleteTheaterById(int theaterId) throws MovieException;
	public Theater findTheaterById(int theaterId) throws MovieException;
	public Screen updateScreenById(Screen screen) throws MovieException;
	public Theater updateTheaterById(Theater theater) throws MovieException;
	public boolean findscreenName( int id,String name) throws MovieException;

}
