/**
 * 
 */
package com.sapiens.raj.service;

import com.sapiens.raj.dto.TheaterDto;


public interface TheaterService {

	TheaterDto addTheater(TheaterDto theaterDto);

	TheaterDto getTheater(long id);
}