package dev.poou.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.poou.pos.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
}
