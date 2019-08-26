//package com.hcl.trading.util;
//
//import javax.mail.internet.MimeMessage;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import com.hcl.movie.dto.BookDto;
//
//@Component
//public class EmailSender {
//
//	public static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);
//	@Autowired
//	JavaMailSender mailSender;
//
//	public String sendTicket(String mailId, BookDto bookDto) {
//
//		LOGGER.info("Enter send mail");
//
//		String returnString = "Email sent sucess";
//		try {
//
//			MimeMessage message = mailSender.createMimeMessage();
//			MimeMessageHelper helper = new MimeMessageHelper(message);
//
//			helper.setTo(mailId);
//			helper.setSubject("Movie ticket");
//			helper.setText("Your ticket id is:"+bookDto.getBookId());
//
//			mailSender.send(message);
//
//		} catch (Exception e) {
//			returnString = "Mail failed";
//			LOGGER.error(e.getMessage());
//		}
//		return returnString;
//
//	}
//
//}
