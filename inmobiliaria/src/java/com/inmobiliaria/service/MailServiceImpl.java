package com.inmobiliaria.service;

import java.io.File;  
   
import javax.mail.MessagingException;  
import javax.mail.internet.MimeMessage;  
   
import org.apache.commons.logging.Log;  
import org.apache.commons.logging.LogFactory;  
import org.springframework.core.io.FileSystemResource;  
import org.springframework.mail.javamail.JavaMailSenderImpl;  
import org.springframework.mail.javamail.MimeMessageHelper;  
import org.springframework.util.Assert;  

import com.inmobiliaria.model.Util;
   
/** 
 * Servicio de envío de emails 
 */  
public class MailServiceImpl implements MailService {  
   
     private static final Log log = LogFactory.getLog(MailServiceImpl.class);  
   
     /** wrapper de Spring sobre javax.mail */  
     private JavaMailSenderImpl mailSender;  
   
     public void setMailSender(JavaMailSenderImpl mailSender) {  
         this.mailSender = mailSender;  
     }  
   
     /** correo electrónico del remitente */  
     private String from;  
     private String bcc;
   
     public void setFrom(String from) {  
         this.from = from;  
     }  
   
     public String getFrom() {  
         return from;  
     }  

     public void setBcc(String bcc) {  
         this.bcc = bcc;  
     }  
   
     public String getBcc() {  
         return bcc;  
     }  

     /** flag para indicar si está activo el servicio */  
     public boolean active = true;  
   
     public boolean isActive() {  
         return active;  
     }  
   
     public void setActive(boolean active) {  
         this.active = active;  
     }  
   
     private static final File[] NO_ATTACHMENTS = null;  
   
     /** envío de email  
      * @param to correo electrónico del destinatario 
      * @param subject asunto del mensaje 
      * @param text cuerpo del mensaje 
      */  
     public void send(String to, String subject, String text) {  
         send(to, subject, text, NO_ATTACHMENTS);  
     }  
   
     /** envío de email con attachments 
      * @param to correo electrónico del destinatario 
      * @param subject asunto del mensaje 
      * @param text cuerpo del mensaje 
      * @param attachments ficheros que se anexarán al mensaje  
      */  
     public void send(String to, String subject, String text, File... attachments) {  
         // chequeo de parámetros   
         Assert.hasLength(to, "email 'to' needed");  
         Assert.hasLength(subject, "email 'subject' needed");  
         Assert.hasLength(text, "email 'text' needed");  
   
         // asegurando la trazabilidad  
         //GHGif (log.isDebugEnabled()) {  
             final boolean usingPassword = !"".equals(mailSender.getPassword());  
             System.out.println("Sending email to: '" + to + "' [through host: '" + mailSender.getHost() + ":"  
                     + mailSender.getPort() + "', username: '" + mailSender.getUsername() + "' usingPassword:"  
                     + usingPassword + "].");  
             System.out.println("From: " + getFrom());
             System.out.println("bcc: " + getBcc());
             System.out.println("isActive: " + active);  
           //GHG}  
         // el servicio esta activo?  
         if (!active) return;  
   
         // plantilla para el envío de email  
         final MimeMessage message = mailSender.createMimeMessage();  
   
         try {  
             // el flag a true indica que va a ser multipart  
             final MimeMessageHelper helper = new MimeMessageHelper(message, true);  
               
             // settings de los parámetros del envío  
             //helper.setTo(to);
             if (!Util.isStringNullOrEmpty(to)) {
            	 int j = 0;  
            	 String[] campos = to.split(";");  
            	 while(j<campos.length){
            		 helper.addTo(campos[j]);
            		 j++;  
            	 }  
             }
             helper.setSubject(subject);  
             helper.setFrom(getFrom());  
             helper.setText(text);
             if (!Util.isStringNullOrEmpty(getBcc())) {
            	 //helper.setBcc(getBcc());
            	 int j = 0;  
            	  String[] campos = getBcc().split(";");  
            	  while(j<campos.length){
            		  helper.addBcc(campos[j]);
            		  j++;  
            	  }  
             }
             
   
             // adjuntando los ficheros  
             if (attachments != null) {  
                 for (int i = 0; i < attachments.length; i++) {  
                     FileSystemResource file = new FileSystemResource(attachments[i]);  
                     helper.addAttachment(attachments[i].getName(), file);  
                     //if (log.isDebugEnabled()) {  
                     //System.out.println("File '" + file + "' attached.");  
                     //}  
                 }  
             }  
   
         } catch (MessagingException e) {  
        	 e.printStackTrace();
             new RuntimeException(e);  
         }  
           
         // el envío  
         this.mailSender.send(message);  
     }  
   
     public void sendNewPassword(String to, String subject, String text, File background) {  
         // chequeo de parámetros   
         Assert.hasLength(to, "email 'to' needed");  
         Assert.hasLength(subject, "email 'subject' needed");  
         Assert.hasLength(text, "email 'text' needed");  
   
         // asegurando la trazabilidad  
         //GHGif (log.isDebugEnabled()) {  
             final boolean usingPassword = !"".equals(mailSender.getPassword());  
             System.out.println("Sending email to: '" + to + "' [through host: '" + mailSender.getHost() + ":"  
                     + mailSender.getPort() + "', username: '" + mailSender.getUsername() + "' usingPassword:"  
                     + usingPassword + "].");  
             System.out.println("From: " + getFrom());
             System.out.println("bcc: " + getBcc());
             System.out.println("isActive: " + active);  
           //GHG}  
         // el servicio esta activo?  
         if (!active) return;  
   
         // plantilla para el envío de email  
         final MimeMessage message = mailSender.createMimeMessage();  
   
         try {  
             // el flag a true indica que va a ser multipart  
             final MimeMessageHelper helper = new MimeMessageHelper(message, true);  
               
             // settings de los parámetros del envío  
             //helper.setTo(to);
             if (!Util.isStringNullOrEmpty(to)) {
            	 int j = 0;  
            	 String[] campos = to.split(";");  
            	 while(j<campos.length){
            		 helper.addTo(campos[j]);
            		 j++;  
            	 }  
             }
             helper.setSubject(subject);  
             helper.setFrom(getFrom());  
             //helper.setText("<html><body background='cid:identifier1234' style='background-repeat: no-repeat'><table><tr><td style='font-family : Arial ;font-size : 20px;color : #ee7c18;font-weight : bold;'><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + text + "</td></tr></table></body></html>", true);
             //helper.setText("<html><body background='http://prodemundial.biogenesisbago.com/prodeMundial/img/bg_password2.jpg' style='background-repeat: no-repeat'><table><tr><td style='font-family : Arial ;font-size : 20px;color : #ee7c18;font-weight : bold;'><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + text + "</td></tr></table></body></html>", true);
             helper.setText("<html><body background='cid:identifier1234' style='background-repeat: no-repeat'><table><tr><td style='font-family : Arial ;font-size : 20px;color : #ee7c18;font-weight : bold;'><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + text + "</td></tr></table></body></html>", true);
             if (!Util.isStringNullOrEmpty(getBcc())) {
            	 //helper.setBcc(getBcc());
            	 int j = 0;  
            	  String[] campos = getBcc().split(";");  
            	  while(j<campos.length){
            		  helper.addBcc(campos[j]);
            		  j++;  
            	  }  
             }
             
   
             // adjuntando los ficheros  
             //if (attachments != null) {  
                // for (int i = 0; i < attachments.length; i++) {  
                     //FileSystemResource file = new FileSystemResource(attachments[i]);  
                     //helper.addAttachment(attachments[i].getName(), file);  
                     //if (log.isDebugEnabled()) {  
                     //System.out.println("File '" + file + "' attached.");  
                     //}  
                 //}  
             //}  
             FileSystemResource file = new FileSystemResource(background);  
             helper.addInline("identifier1234", file);

   
         } catch (MessagingException e) {  
        	 e.printStackTrace();
             new RuntimeException(e);  
         }  
           
         // el envío  
         this.mailSender.send(message);  
     }
   
     public void sendNuevasTarjetas(String to, String subject, String text, File background) {
    	 sendNewPassword(to, subject, text, background);  
     }
     
}  