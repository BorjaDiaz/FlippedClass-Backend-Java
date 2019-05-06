package com.groupc.flippedclass.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.groupc.flippedclass.message.request.SignUpForm;
import com.groupc.flippedclass.services.MailService;

@Service
public class MailServiceImpl implements MailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public MailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendEmail(SignUpForm signupRequest) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(signupRequest.getEmail());
		mail.setSubject("Registro en Flipped Class");
		mail.setText("Bienvenido a Flipped Class, "
				+ signupRequest.getName() + " " + signupRequest.getSurname() + "\n"
				+ "Estos son sus credenciales de login: \n"
				+ "Usuario: " + signupRequest.getUsername() + "\n"
				+ "Password: " + signupRequest.getPassword());
		javaMailSender.send(mail);
	}
}
