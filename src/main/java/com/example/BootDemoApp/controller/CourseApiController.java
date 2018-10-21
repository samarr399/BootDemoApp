package com.example.BootDemoApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseApiController {
	@RequestMapping("hello")
	public String sayHi() {
		return "Hi Samar";
	}
}
