package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.movie.dao.ScreenDao;
import com.cg.movie.dao.TheaterDao;
import com.cg.movie.entity.Screen;
import com.cg.movie.entity.Theater;
import com.cg.movie.exception.MovieException;
import com.cg.movie.service.ScreenService;

@SpringBootTest
class MovieSpringBootSprint2ApplicationTests {

	@Autowired
	private ScreenService screenService;

	@MockBean
	private ScreenDao screenDao;

	@MockBean
	private TheaterDao theaterDao;

	@Test
	public void getTheatersTest() throws MovieException {
		// we pass two theaters and if the method in service returns the same size
		when(theaterDao.findAll())
				.thenReturn(Stream
						.of(new Theater(2001, "inox", "hyderabad", "rahul", 123456789),
								new Theater(2002, "shiva", "hyderabad", "nivas", 1234567890))
						.collect(Collectors.toList()));
		assertEquals(2, screenService.findAllTheaters().size());

	}

	@Test
	public void getScreensTest() throws MovieException {
		when(screenDao.findAll()).thenReturn(Stream.of(new Screen(1001, "screen1", 10, 12),
				new Screen(1002, "screen2", 9, 9), new Screen(1003, "screen1", 10, 10)).collect(Collectors.toList()));
		assertEquals(3, screenService.findAllScreens().size());

	}

}
