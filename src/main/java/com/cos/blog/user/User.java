package com.cos.blog.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(value= {"password","ssn"})
public class User {
	private Integer id;
	
	@Size(min=2, message="Name은 2글자 이상 입력해 주세요.")
	private String name;
	@Past
	private Date joinDate;
	
//	@JsonIgnore
	private String password;
//	@JsonIgnore
	private String ssn;
}
