package com.cg.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.entity.Login;
import com.cg.movie.entity.Screen;
import com.cg.movie.entity.Theater;
import com.cg.movie.exception.MovieException;
import com.cg.movie.service.ScreenService;

@RestController // controller + responsebody
@CrossOrigin("*") // it will allow resource sharing between different origins
public class ScreenController {

	@Autowired // service object will be injected into controller while creating controller in
				// WebApplicationContext

	ScreenService screenService;
	// we cannot create object to an interface but we can have a reference
	
	
	@GetMapping("admin/login/{user}/{pass}")
	public ResponseEntity<Login>  findUserLogin(@PathVariable("user") String username, @PathVariable("pass") String password) throws MovieException
	{
	  
		 Login log = screenService.findUser(username,password);
		 if(log==null) {
			 throw new MovieException("Login not successfull");
		 }
		 return new ResponseEntity<>(log,HttpStatus.OK);
		
		
	}

	// it is request mapping with get method
	@GetMapping("theater/screen") // uri
	public ResponseEntity<List<Screen>> findAllScreens() throws MovieException {
		// using service we call findallscreens method which will return

		// we can also return normal screen object but as it is a web request we use
		// response entity
		// it will contain body and status code like 200,404...
		return new ResponseEntity<>(screenService.findAllScreens(), HttpStatus.OK);

	}

	@GetMapping("theater/screen/{id}")
	// inorder to map a parameter from uri to method parameters we use @pathvariable
	public ResponseEntity<Screen> findScreenById(@PathVariable("id") int screenId) throws MovieException {

		return new ResponseEntity<>(screenService.findScreenById(screenId), HttpStatus.OK);
	}

	@GetMapping("theater")
	public ResponseEntity<List<Theater>> findAllTheaters() throws MovieException {
		// response enity is a class which has a body and http status code
		return new ResponseEntity<>(screenService.findAllTheaters(), HttpStatus.OK);

	}

	@GetMapping("/theater/{id}")
	public ResponseEntity<Theater> findTheaterById(@PathVariable("id") int theaterId) throws MovieException {
		return new ResponseEntity<>(screenService.findTheaterById(theaterId), HttpStatus.OK);
	}

	@GetMapping("theater/screens/{id}") // inorder to handle the exception we use throws declaration
	public ResponseEntity<List<Screen>> findByTheaterId(@PathVariable("id") int id) throws MovieException {
		return new ResponseEntity<>(screenService.findByTheaterId(id), HttpStatus.OK);
	}

//	----------------------------------------------------------------------------------------------------------------------

	// post is used when we send data and it will not appear on the url
	@PostMapping("theater/screen")

	// requestbody maps httprequest json format data from the client to the local
	// object screen
	public ResponseEntity<Screen> createScreen(@RequestBody Screen screen) {
		return new ResponseEntity<>(screenService.createScreen(screen), HttpStatus.OK);
	}

	@PostMapping("theater")
	public ResponseEntity<Theater> createTheater(@RequestBody Theater theater) {
		return new ResponseEntity<>(screenService.createTheater(theater), HttpStatus.OK);
	}

// ------------------------------------------------------------------------------------------------------------------------------

	// delete mapping is used for delete requests
	@DeleteMapping("theater/screen/{id}")
	public ResponseEntity<Screen> deleteScreenById(@PathVariable("id") int screenId) throws MovieException {

		// we can write in a single line by directly calling the method inside the boody
		return new ResponseEntity<>(screenService.deleteScreenById(screenId), HttpStatus.OK);
	}

	@DeleteMapping("theater/{id}")
	public ResponseEntity<Theater> deleteTheaterById(@PathVariable("id") int theaterId) throws MovieException {

		return new ResponseEntity<>(screenService.deleteTheaterById(theaterId), HttpStatus.OK);

	}

// -------------------------------------------------------------------------------------------------------------------------

	// it is used for update requests
	@PutMapping("theater/screen")
	public ResponseEntity<Screen> updateScreenById(@RequestBody Screen screen) throws MovieException {
		ResponseEntity<Screen> rt = null;

		if (screen != null) {
			screen = screenService.updateScreenById(screen);
			rt = new ResponseEntity<>(screen, HttpStatus.OK);
		} else {
			rt = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return rt;

	}

	@PutMapping("theater")
	public ResponseEntity<Theater> updateTheaterById(@RequestBody Theater theater) throws MovieException {
		ResponseEntity<Theater> rt = null;

		if (theater != null) {
			theater = screenService.updateTheaterById(theater);
			rt = new ResponseEntity<>(theater, HttpStatus.OK);
		} else {
			rt = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return rt;

	}

// -------------------------------------------------------------------------------------------------------	
	
	// it is request mapping with get method
		@GetMapping("theater/screen/{id}/{name}") // uri
		public ResponseEntity<Boolean> findScreen(@PathVariable("id") int id,@PathVariable("name") String name ) throws MovieException {
			
			if(screenService.findscreenName(id, name)==true) {
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			}
			
			else {
				return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
			}
		
		    
		}
	
}
