package com.productapp.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {
	
	
	private String message;
	private String contact;
	private LocalDateTime date;
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
	
	
}
