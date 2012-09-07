package com.inmobiliaria.service;

import java.io.File;

public interface MailService {

	public void send(String to, String subject, String text);  
	
	public void send(String to, String subject, String text, File... attachments); 
	
	public void sendNewPassword(String to, String subject, String text, File background);
	
	public void sendNuevasTarjetas(String to, String subject, String text, File background);
	
}
