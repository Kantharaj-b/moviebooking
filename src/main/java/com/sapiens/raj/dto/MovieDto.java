/**
 * 
 */
package com.sapiens.raj.dto;

import java.time.LocalDate;

import com.sapiens.raj.enums.CertificateType;
import com.sapiens.raj.enums.MovieLanguage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class MovieDto {

	private long id;

	private String name;

	private MovieLanguage language;

	private CertificateType certificateType;

	private LocalDate releaseDate;

}