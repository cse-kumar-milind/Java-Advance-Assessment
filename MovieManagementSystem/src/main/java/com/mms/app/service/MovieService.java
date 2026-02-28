package com.mms.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mms.app.model.Movie;
import com.mms.app.repository.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository movieRepository;
	
	
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}



	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public Movie findMovieById(Long id) {
		
		return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found!"));
	}
	
	public void updateMovie(Long id, Movie updated) {
		
		Movie existingMovie = findMovieById(id);
		
		existingMovie.setTitle(updated.getTitle());
		existingMovie.setDirector(updated.getDirector());
		existingMovie.setGenre(updated.getGenre());
		existingMovie.setYear(updated.getYear());
		existingMovie.setRating(updated.getRating());
		
		movieRepository.save(existingMovie);
	}
	
	public void deleteMovie(Long id) {
		findMovieById(id);
		movieRepository.deleteById(id);
	}
	
}
