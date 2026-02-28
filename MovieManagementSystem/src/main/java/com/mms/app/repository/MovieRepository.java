package com.mms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mms.app.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
