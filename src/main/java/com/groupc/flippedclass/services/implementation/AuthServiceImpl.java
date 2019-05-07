package com.groupc.flippedclass.services.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.groupc.flippedclass.entity.Role;
import com.groupc.flippedclass.entity.User;
import com.groupc.flippedclass.message.request.LoginForm;
import com.groupc.flippedclass.message.request.SignUpForm;
import com.groupc.flippedclass.message.response.JwtResponse;
import com.groupc.flippedclass.message.response.ResponseMessage;
import com.groupc.flippedclass.repository.UserRepository;
import com.groupc.flippedclass.security.JwtProvider;
import com.groupc.flippedclass.services.AuthService;
import com.groupc.flippedclass.services.MailService;
import com.groupc.flippedclass.services.RoleService;
import com.groupc.flippedclass.services.UserService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;

	@Autowired
	MailService mailService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtProvider jwtProvider;
	
	@Value("${flippedclass.defaultPassword}")
	private String defaultPassword;
	
	@Override
	public ResponseEntity<?> AuthenticateUser(LoginForm loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@Override
	public ResponseEntity<?> registerUser(SignUpForm signupRequest) {
		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Error: Este DAS ya ha sido dado de alta!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Error: Este Email ya ha sido dado de alta!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signupRequest.getName(), signupRequest.getSurname(), signupRequest.getUsername(),
				signupRequest.getEmail(), defaultPassword,true);
		
		Set<String> strRoles = signupRequest.getRole();
		Set<Role> roles = roleService.getValidRoles(strRoles);
		user.setRoles(roles);
		mailService.sendEmail(user);
		user.setPassword(userService.passwordEncoder(defaultPassword));
		userRepository.save(user);
		
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}

}
