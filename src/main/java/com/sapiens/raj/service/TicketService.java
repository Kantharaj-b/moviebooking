/**
 * 
 */
package com.sapiens.raj.service;

import com.sapiens.raj.dto.BookTicketRequestDto;
import com.sapiens.raj.dto.TicketDto;


public interface TicketService {

	TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

	TicketDto getTicket(long id);
}