package com.zee.zee5app.repository.impl;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.repository.MoviesRepository2;

public class MoviesRepositoryImpl implements MoviesRepository2 {

	private Movies [] movies = new Movies[10];
	private MoviesRepositoryImpl() {
			
	}
	
	private static MoviesRepository2 moviesrepository;
		
	public static MoviesRepository2 getInstance() {
		if(moviesrepository==null)
			{
			moviesrepository = new MoviesRepositoryImpl();
			}
		return moviesrepository;
		}
	private static int count = -1;
	@Override
	public String addMovie(Movies movie) {
		if(count == movies.length-1) {
			Movies temp[] = new Movies[2*movies.length];
			System.arraycopy(movies, 0, temp,0, movies.length);
			movies = temp;
			movies[++count] = movie;
			return "Successfully added User";
		}
		movies[++count] = movie;
		return "Successfully added User";
	}

	@Override
	public String updateMovie(String id,Movies movie) {
		for (Movies currMovie : movies) {
			if (currMovie!=null) {
				if (currMovie.getId().equals(id)) {
					currMovie.setCast(movie.getCast());
					currMovie.setLanguage(movie.getLanguage());
					currMovie.setTrailer(movie.getTrailer());
					currMovie.setLength(movie.getLength());
					currMovie.setReleaseDate(movie.getReleaseDate());
					currMovie.setMovieName(movie.getMovieName());
					currMovie.setCat(movie.getCat());
					return "updated";
				}
			}	
		}
		return null;
	}
	

	@Override
	public Movies getMovieById(String id) {
		for (Movies register : movies) {
			if(register!=null) {
				
				if(register.getId().equals(id)) {
					return register;
				}
			}
		}
		return null;
	}

	@Override
	public Movies[] getAllMovies() {
		return movies;
	}

	@Override
	public String deleteMovieById(String id) {
		Movies temp[] = new Movies[movies.length];
		int i = 0;
		int j = 0;
		for (Movies currRegister : movies) {
			if (currRegister!=null) {
				if (currRegister.getId().equals(id)) {
					j++;
				}
				else {
					temp[i] = movies[j];
					i++;
					j++;
				}
			}	
		}
		movies = temp;
		return "success";
	}

}
