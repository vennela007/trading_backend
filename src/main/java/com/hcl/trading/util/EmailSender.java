package com.hcl.trading.util;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.hcl.trading.dto.OrderDto;


@Component
public class EmailSender {

	public static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);
	@Autowired
	JavaMailSender mailSender;

	public String sendTicket(String mailId, OrderDto orderDto) {

		LOGGER.info("Enter send mail");

		String returnString = "Email sent sucess";
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setTo(mailId);
			helper.setSubject("Order Reciept");
			helper.setText("Your order id is:"+orderDto.getOrderId()+"\n"+"order status is"+
					orderDto.getStockStatus()+"\n"+"stock id is"+orderDto.getStockId()
					+"\n"+"stock quantity is"+orderDto.getStockQuantity()+
					"\n"+"order total price is"+orderDto.getTotalPrice()+"\n"+"user id is"+
					orderDto.getUserId()+"\n"+"order creation date is"+orderDto.getCreationDate()
					+"\n"+"order settlement date is"+orderDto.getSettlementDate());

			mailSender.send(message);

		} catch (Exception e) {
			returnString = "Mail failed";
			LOGGER.error(e.getMessage());
		}
		return returnString;

	}

}
