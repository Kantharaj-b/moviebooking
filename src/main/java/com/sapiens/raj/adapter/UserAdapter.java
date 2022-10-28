/**
 * 
 */
package com.sapiens.raj.adapter;

import com.sapiens.raj.dto.UserDto;
import com.sapiens.raj.model.UserEntity;

import lombok.experimental.UtilityClass;


@UtilityClass
public class UserAdapter {

	public static UserEntity toEntity(UserDto userDto) {

		return UserEntity.builder()
				.name(userDto.getName())
				.mobile(userDto.getMobile())
				.build();

	}

	public static UserDto toDto(UserEntity userEntity) {

		return UserDto.builder()
				.id(userEntity.getId())
				.name(userEntity.getName())
				.mobile(userEntity.getMobile())
				.build();
	}

}