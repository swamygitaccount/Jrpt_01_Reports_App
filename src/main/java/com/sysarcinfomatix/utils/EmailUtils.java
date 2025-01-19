package com.sysarcinfomatix.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	
//	in order to send the email we have predefined class called JavaMailSender.
	@Autowired
	private JavaMailSender mailSender; 
	
	
	public boolean sendEmail(String subject, String body , String to,File f) {
		
	
		try {
			
//			to send a mail, JavaMailSender class provided method called 
//			two types of methods to send the email 
//			1.mime message : if you want to send some attchement then  we can go for mime message.
//			2.simple message=if you dont want to send the attchement and just wanted to send the simple mail text. 
			MimeMessage mimeMsf= mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMsf,true);
			helper.setSubject(subject);// 
			helper.setText(body, true);
			helper.setTo(to);
			helper.addAttachment("plans.pdf", f);
			mailSender.send(mimeMsf);
//			in below crated helper class 
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
}
