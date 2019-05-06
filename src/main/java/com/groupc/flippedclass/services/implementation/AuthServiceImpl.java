package com.groupc.flippedclass.services.implementation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.groupc.flippedclass.entity.Role;
import com.groupc.flippedclass.entity.RoleName;
import com.groupc.flippedclass.entity.User;
import com.groupc.flippedclass.message.request.LoginForm;
import com.groupc.flippedclass.message.request.SignUpForm;
import com.groupc.flippedclass.message.response.JwtResponse;
import com.groupc.flippedclass.message.response.ResponseMessage;
import com.groupc.flippedclass.repository.RoleRepository;
import com.groupc.flippedclass.repository.UserRepository;
import com.groupc.flippedclass.security.JwtProvider;
import com.groupc.flippedclass.services.AuthService;
import com.groupc.flippedclass.services.MailService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	MailService mailService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

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
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signupRequest.getName(), signupRequest.getSurname(), signupRequest.getUsername(),
				signupRequest.getEmail(), encoder.encode(signupRequest.getPassword()));

		Set<String> strRoles = signupRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "teacher":
				Role teacherRole = roleRepository.findByName(RoleName.ROLE_TEACHER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(teacherRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);
		mailService.sendEmail(signupRequest);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}

}
