/**
 * 
 */
package com.sapiens.raj.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.sapiens.raj.exception.DuplicateRecordException;
import com.sapiens.raj.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapiens.raj.adapter.MovieAdapter;
import com.sapiens.raj.dto.MovieDto;
import com.sapiens.raj.model.MovieEntity;
import com.sapiens.raj.service.MovieService;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public MovieDto addMovie(MovieDto movieDto) {

		if (movieRepository.existsByNameAndLanguage(movieDto.getName(), movieDto.getLanguage())) {
			throw new DuplicateRecordException("Movie Already Exists with Name: " + movieDto.getName() + " in Language: " + movieDto.getLanguage());
		}

		log.info("Adding New Movie: " + movieDto);

		MovieEntity movieEntity = MovieAdapter.toEntity(movieDto);

		movieEntity = movieRepository.save(movieEntity);

		log.info("Added New Movie [id: " + movieEntity.getId() + ", Name: " + movieEntity.getName() + ", Language: " + movieEntity.getLanguage() + "]");

		return MovieAdapter.toDto(movieEntity);
	}

	@Override
	public MovieDto getMovie(long id) {
		log.info("Searching Movie by id: " + id);

		Optional<MovieEntity> movieEntity = movieRepository.findById(id);

		if (!movieEntity.isPresent()) {
			log.error("Movie not found for id: " + id);
			throw new EntityNotFoundException("Movie Not Found with ID: " + id);
		}

		return MovieAdapter.toDto(movieEntity.get());
	}

}