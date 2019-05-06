package com.groupc.flippedclass.services;

import org.springframework.http.ResponseEntity;

import com.groupc.flippedclass.message.request.LoginForm;
import com.groupc.flippedclass.message.request.SignUpForm;

public interface AuthService {

	public ResponseEntity<?> AuthenticateUser(LoginForm loginRequest);
	
	public ResponseEntity<?> registerUser(SignUpForm signupRequest);
}
