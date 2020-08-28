package com.cg.movie.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.movie.dao.LoginDao;
import com.cg.movie.dao.ScreenDao;
import com.cg.movie.dao.TheaterDao;
import com.cg.movie.entity.Login;
import com.cg.movie.entity.Screen;
import com.cg.movie.entity.Theater;
import com.cg.movie.exception.MovieException;

//it will let the webapplcationcontext to create a bean class for it as a component
//it indicates the class as a service class
@Service
public class ScreenServiceImpl implements ScreenService {

	private String str = "ID NOT FOUND";
	// inorder to achieve loose coupling as we can have many implementation objects
	// from one service

	// dao object will be injected into service while creating controller in
	// WebApplicationContext
	@Autowired
	ScreenDao screenDao;

	@Autowired
	TheaterDao theaterDao;
	
	@Autowired
	LoginDao loginDao;

	@Override
	public Login findUser(String username,String password) throws MovieException {

		return loginDao.findUser(username,password);
	}

	// implements abstract classes from service interface by overriding those
	// methods so that we write our own code

	@Override
	public List<Screen> findByTheaterId(int theaterId) throws MovieException {

		// it will call theater dao interface inbuilt method and returns boolean true or
		// false
		if (!theaterDao.existsById(theaterId)) {
			throw new MovieException(str);
			// it is handled by global exception handler
		}

		// in screendao we have written our own method and added query so that it will
		// give required output

		// it will call the method from screen dao interface and will return list of
		// screens if that theater has any
		List<Screen> lis =screenDao.findByTheaterId(theaterId);
		lis.sort((Screen s1, Screen s2)->s1.getScreenName().compareTo(s2.getScreenName()));
		return lis;
	}

	@Override
	public List<Screen> findAllScreens() throws MovieException {

		// it will call the method from screen dao interface and will return list of
		// screens

		return screenDao.findAll();
	}

	@Override
	public Screen createScreen(Screen screen) {
		// saves the enity and if we have any changes it will remove

		return screenDao.saveAndFlush(screen);
	}

	@Override
	public Screen findScreenById(int screenId) throws MovieException {
		Screen sc = null;
		// if id does not exist it will throw exception
		// else it will return the founded one

		Optional<Screen> scr = screenDao.findById(screenId);
		if (scr.isPresent()) {
			sc = scr.get();
		} else {
			throw new MovieException(str);
		}

		return sc;

	}

	@Override
	public Screen deleteScreenById(int screenId) throws MovieException {
		Screen scr1 = null;
		Optional<Screen> scr = screenDao.findById(screenId);
		if (scr.isPresent()) {
			scr1 = scr.get();
			screenDao.deleteById(screenId);
		} else {
			throw new MovieException(str);
		}
		// if we dont return also no problem but inorder to know what we have deleted
		// we will get a glance to see
		return scr1;
	}

	@Override
	public Screen updateScreenById(Screen screen) throws MovieException {

		if (screenDao.existsById(screen.getScreenId())) {
			screenDao.saveAndFlush(screen);

		} else {
			throw new MovieException(str);
		}
		return screen;
	}

// ---------------------------------------------------------------------------------------------------

	@Override
	public Theater createTheater(Theater theater) {

		return theaterDao.saveAndFlush(theater);
	}

	@Override
	public List<Theater> findAllTheaters() throws MovieException {

		return theaterDao.findAll();
	}

	@Override
	public Theater deleteTheaterById(int theaterId) throws MovieException {
		Theater thr = null;

		Optional<Theater> thr1 = theaterDao.findById(theaterId);
		if (thr1.isPresent()) {
			thr = thr1.get();
			theaterDao.deleteById(theaterId);
		}

		else {
			throw new MovieException(str);
		}
		return thr;
	}

	@Override
	public Theater findTheaterById(int theaterId) throws MovieException {
		Theater thr = null;
		Optional<Theater> thr1 = theaterDao.findById(theaterId);
		if (thr1.isPresent()) {
			thr = thr1.get();
		} else {
			throw new MovieException(str);
		}

		return thr;
	}

	@Override
	public Theater updateTheaterById(Theater theater) throws MovieException {
		if (theaterDao.existsById(theater.getTheaterId())) {
			theaterDao.saveAndFlush(theater);
		} else {
			throw new MovieException(str);
		}
		return theater;
	}

	@Override
	public boolean findscreenName( int id,String name) throws MovieException {
		boolean flag  = false;
		List<Screen> li=screenDao.findByTheaterId(id);
		for(int i=0;i<li.size();i++) {
			if(li.get(i).getScreenName().equals(name)) {
				flag=true;
				System.out.println(li.get(i).getScreenName());
			}
		}
		return flag;
	}

}
