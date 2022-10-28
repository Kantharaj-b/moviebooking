package com.sapiens.raj;

import static org.junit.Assert.assertTrue;

import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapiens.raj.dto.UserDto;
import com.sapiens.raj.exception.DuplicateRecordException;
import com.sapiens.raj.repository.UserRepository;
import com.sapiens.raj.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void testAddUser() {

		deleteUser();

		String name = "Test";
		String mobile = "124";

		UserDto userDto = UserDto.builder().name(name).mobile(mobile).build();

		userDto = userService.addUser(userDto);

		assertTrue(Objects.nonNull(userDto));
		assertTrue(userDto.getName().equals(name));
		assertTrue(userDto.getMobile().equals(mobile));

		userRepository.deleteById(userDto.getId());
	}

	@Test(expected = DuplicateRecordException.class)
	public void testAddDuplicateUser() {

		deleteUser();

		String name = "Test";
		String mobile = "124";

		UserDto userDto = UserDto.builder().name(name).mobile(mobile).build();

		userDto = userService.addUser(userDto);

		assertTrue(Objects.nonNull(userDto));
		assertTrue(userDto.getName().equals(name));
		assertTrue(userDto.getMobile().equals(mobile));

		userService.addUser(userDto);

	}

	@Test
	public void testGetUser() {

		deleteUser();

		String name = "Test";
		String mobile = "124";

		UserDto userDto = UserDto.builder().name(name).mobile(mobile).build();

		userDto = userService.addUser(userDto);

		userDto = userService.getUser(userDto.getId());

		assertTrue(Objects.nonNull(userDto));
		assertTrue(userDto.getName().equals(name));
		assertTrue(userDto.getMobile().equals(mobile));

		userRepository.deleteById(userDto.getId());

	}

	@Test(expected = EntityNotFoundException.class)
	public void testGetNonExistentUser() {
		userService.getUser(-1);
	}

	private void deleteUser() {
		userRepository.deleteByMobile("124");
	}
}