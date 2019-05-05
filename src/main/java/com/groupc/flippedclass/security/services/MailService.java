package com.groupc.flippedclass.security.services;

import com.groupc.flippedclass.message.request.SignUpForm;

public interface MailService {
	
	public void sendEmail(SignUpForm signupRequest);
	
}
