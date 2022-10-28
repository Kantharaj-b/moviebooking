/**
 * 
 */
package com.sapiens.raj.service;

import com.sapiens.raj.dto.UserDto;


public interface UserService {

	UserDto addUser(UserDto userDto);

	UserDto getUser(long id);
}