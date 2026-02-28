package com.mms.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mms.app.model.Movie;
import com.mms.app.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {
	
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping()
	public String getMoviesDetails(Model model) {
		List<Movie> movies = movieService.getAllMovies();
		
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	@GetMapping("/addMovie")
	public String addMovieForm(Model model) {
		model.addAttribute("movies", new Movie());
		
		return "addMovie";
	}
	
	@PostMapping()
	public String addMovie(Movie movie) {
		movieService.saveMovie(movie);
		return "redirect:/movies";
	}
	
	@GetMapping("/edit/{id}")
	public String updateMovieForm(Model model, @PathVariable Long id) {
		model.addAttribute("movies", movieService.findMovieById(id));
		model.addAttribute("isEdit", true);
		model.addAttribute("movieId", id);
		
		return "addMovie"; 
	}
	
	@PostMapping("/edit/{id}")
	public String updateMovie(@PathVariable Long id, Movie movie) {
		movieService.updateMovie(id, movie);
		return "redirect:/movies";
	}
	
	@GetMapping("/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		
		return "redirect:/movies";
	}
	
}
