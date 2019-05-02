package com.groupc.flippedclass.security.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.groupc.flippedclass.entity.User;
import com.groupc.flippedclass.security.services.MailService;

@Service
public class MailServiceImpl implements MailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	public MailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Override
	public void sendEmail(User user) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setSubject("Bienvenido a Flipped Class");
		mail.setText("Bienvenido a Flipped Class, estos son tus credenciales de login: \n"
				+ "Usuario: " + user.getUsername() + "\n"
				+ "Password: " + user.getPassword());
		javaMailSender.send(mail);
	}

	
}
