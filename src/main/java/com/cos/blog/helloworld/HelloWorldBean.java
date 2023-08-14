package com.cos.blog.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldBean {
	private String message;

// @Data
//	public String getMessage() {
//		return this.message;
//	}
//	public void setMessage(String msg) {
//		this.message = msg;
//	}
	
// @AllArgsConstructor
//	public HelloWorldBean(String message) {
//		this.message = message;
//	}
}
