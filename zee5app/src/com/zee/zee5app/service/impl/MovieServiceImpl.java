package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MoviesRepository2;
import com.zee.zee5app.repository.impl.MoviesRepositoryImpl;
import com.zee.zee5app.service.MovieService2;

public class MovieServiceImpl implements MovieService2 {
	private MoviesRepository2 repository = MoviesRepositoryImpl.getInstance();
	private MovieServiceImpl() {
		
	}
	private static MovieService2 movieservice;
	
	public static MovieService2 getInstance() {
		if(movieservice == null) {
			movieservice = new MovieServiceImpl();
		}
		return movieservice;
	}
	
	
	@Override
	public String addMovie(Movies movie) {
		return this.repository.addMovie(movie);
	}

	@Override
	public String updateMovie(String id,Movies movie) {
		return this.repository.updateMovie(id,movie);
	}

	@Override
	public Movies getMovieById(String id) {
		return this.repository.getMovieById(id);
	}

	@Override
	public Movies[] getAllMovies() {
		return this.repository.getAllMovies();
	}
	@Override
	public String deleteMovieById(String id) {
		return this.repository.deleteMovieById(id);
	}

}
