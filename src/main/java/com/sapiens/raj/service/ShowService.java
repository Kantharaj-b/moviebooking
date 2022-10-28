/**
 * 
 */
package com.sapiens.raj.service;

import java.time.LocalDate;
import java.time.LocalTime;

import com.sapiens.raj.dto.PageResponse;
import com.sapiens.raj.dto.ShowDto;


public interface ShowService {

	ShowDto addShow(ShowDto showDto);

	PageResponse<ShowDto> searchShows(String movieName, String city, LocalDate showDate, LocalTime showTime, int pageNo, int limit);

}