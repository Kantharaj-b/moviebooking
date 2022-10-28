/**
 * 
 */
package com.sapiens.raj.service;

import com.sapiens.raj.dto.MovieDto;


public interface MovieService {

	MovieDto addMovie(MovieDto movieDto);

	MovieDto getMovie(long id);
}