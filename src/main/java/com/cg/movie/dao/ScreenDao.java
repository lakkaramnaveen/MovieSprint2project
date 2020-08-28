package com.cg.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Screen;

//it will specify it as a repository or a dao
@Repository
public interface ScreenDao extends JpaRepository<Screen, Integer> {

	// user defined method for finding screens under that particular theater
	@Query(" FROM Screen where theater.theaterId=:id")
	public List<Screen> findByTheaterId(@Param("id") int id);
	
}
