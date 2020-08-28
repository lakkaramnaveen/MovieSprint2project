package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.entity.Theater;

@Repository // it will specify it as a repository or a dao
public interface TheaterDao extends JpaRepository<Theater, Integer> {

}
