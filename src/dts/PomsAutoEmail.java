/*
 * Created on Jul 31, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package dts;

import java.sql.SQLException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class PomsAutoEmail {
	@SuppressWarnings("unused")
	private void do_SendEmail(String email) throws SQLException {		
		String tsql = "";
		//
		String email_to = null, email_cc = null, email_bc = null;
        String email_subject = null, email_body = null, email_file = null;
		//
		try {
			// SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
			// Setting for Gmail
			final String host = "smtp.gmail.com";
			final String port = "465";
			final String email_uid = "arnabnandy2@gmail.com";
			final String email_pwd = "fcvagqaltstsolxi";
			//
			email_to = email;
			email_file = "C:\\Users\\arnab\\Pictures\\Biohacking.jpg";
			try {
				// Make ready Report File
				try {						
					// Turn off SSL check for Certificate.
					// XTrustProvider.install();
					// Create properties for the Session
					Properties props = new Properties();
					// need to specify the mail server here
					props.put("mail.smtp.host", host);
					props.put("mail.smtp.port", port);
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.ssl.enable", "true");
					props.put("mail.transport.protocol", "smtps");
					props.put("mail.smtp.socketFactory.port", port);
					props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
					props.put("mail.smtp.starttls.enable","true");
					props.put("mail.smtp.socketFactory.fallback", "true"); 
					// props.put("mail.smtp.sasl.realm","calcuttaport.kopt.in");
					// props.put("mail.smtp.auth.mechanisms","DIGEST-MD5");
					// To see what is going on behind the scene
					// props.put("mail.debug", "true");
					// Get a session for non-auth
					// Session session = Session.getDefaultInstance(props);
					// Create a new session with the user and pass.
					Session session = Session.getInstance(props, new Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(email_uid, email_pwd);
						}
					});
					//session.setDebug(true);
					// Instantiate a message
					Message msg = new MimeMessage(session);
					// Set message attributes
					msg.setFrom(new InternetAddress(email_uid));
					// Set to Recipients
					if (email_to != null){
					   StringTokenizer stto = new StringTokenizer(email_to, ",");
					   int cnt = stto.countTokens();
					   InternetAddress[] toaddress = new InternetAddress[cnt];
					   //{ new InternetAddress(email_to)};
					   for (int i=0; i < cnt;i++)  {
					       toaddress[i] = new InternetAddress(stto.nextToken());
                           }
                       msg.setRecipients(Message.RecipientType.TO, toaddress);
                    }
                    // Set cc Recipients
					/*if (email_cc != null){
					   StringTokenizer stcc = new StringTokenizer(email_cc, ",");
					   int cnt = stcc.countTokens();
					   InternetAddress[] ccaddress = new InternetAddress[cnt];
					   //{ new InternetAddress(email_to)};
					   for (int i=0; i < cnt;i++)  {
					       ccaddress[i] = new InternetAddress(stcc.nextToken());
					       }
                       msg.setRecipients(Message.RecipientType.CC, ccaddress);
                    }*/ 
					// Set bc Recipients
                    /*if (email_bc != null){
                        email_bc = email_uid + "," +  email_bc;
                    } else
                        email_bc = email_uid;
					if (email_bc != null){

					   StringTokenizer stbc = new StringTokenizer(email_bc, ",");
					   int cnt = stbc.countTokens();
					   InternetAddress[] bcaddress = new InternetAddress[cnt];
					   //{ new InternetAddress(email_to)};
					   for (int i=0; i < cnt;i++)  {
					       bcaddress[i] = new InternetAddress(stbc.nextToken());
                           }
                       msg.setRecipients(Message.RecipientType.BCC, bcaddress);
                    }*/
					//msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_cc, true));
					// Parse a comma-separated list of email addresses. Be strict.
					//msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(email_cc, true));
					// Parse comma/space-separated list. Cut some slack.
					//msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(email_bc, false));
					msg.setSubject("উদাহরণ");
					//msg.setSentDate(new Date());
					// Set message content and send
					// Create and fill first part
					String bp = "<b>সাজানো লেখা </b>";
					bp += "<br>ধন্যবাদ ";
					//bp += "<img src='cid:image'>";
					MimeBodyPart p1 = new MimeBodyPart();
					p1.setText(bp);
					// Create second part
					MimeBodyPart p2 = new MimeBodyPart();
					//
					//MimeBodyPart imagePart = new MimeBodyPart();
					// Put a file in the second part
					FileDataSource fds = new FileDataSource(email_file);
					
					p2.setDataHandler(new DataHandler(fds));
					p2.setFileName(fds.getName());
					// Create the Multiple part.  Add BodyParts to it.
					Multipart mp = new MimeMultipart("alternative");
					BodyPart messageBodyPart = new MimeBodyPart();
					
					messageBodyPart.setContent(bp,"text/html; charset=utf-8");
					//
					/*DataSource fds_image = new FileDataSource(email_pdffile);
					imagePart.setDataHandler(new DataHandler(fds_image));
					// assign a cid to the image
					imagePart.setHeader("Content-ID", "image");*/
					
					mp.addBodyPart(messageBodyPart);
					//mp.addBodyPart(imagePart);
					mp.addBodyPart(p2);
					// Set Multiple part as the message's content
					msg.setContent(mp);
					msg.saveChanges();
					// Send email
					Transport.send(msg);						
					System.out.println("Send Mail Done.");
				} catch (MessagingException mex) {
					// Prints all nested (chained) exceptions as well
					mex.printStackTrace();
					// How to access nested exceptions
					while (mex.getNextException() != null) {
						// Get next exception in chain
						Exception ex = mex.getNextException();
						ex.printStackTrace();
						if (!(ex instanceof MessagingException))
							break;
						else
							mex = (MessagingException) ex;
					}
					throw new SQLException("Email : Sendimg Email failed.");
				}

			} catch (SQLException se) {
				throw new SQLException("mas_auto_email:\n" + se.getMessage());
			}
		} catch (Exception ex) {
			throw new SQLException("Error:do_SendEmail():\n" + ex.getMessage());
		} catch (Throwable th) {
			throw new SQLException("Error:do_SendEmail():\n" + th.getMessage());
		} finally {
		}
		return;
	}
	public static void main(String[] args) {
		java.sql.Connection tcon = null;		
		try {
			PomsAutoEmail aPAE = new PomsAutoEmail();
			try {
				System.out.println("Started..");
				String email_id_list="arnabnandy2@gmail.com,arnab_nandy7@yahoo.com";
				//String email_id_list="arnabnandy2@gmail.com";
				StringTokenizer stbc = new StringTokenizer(email_id_list, ",");
				for (int i=0; i <= stbc.countTokens();i++)  {
					aPAE.do_SendEmail(stbc.nextToken());
				}
				System.out.println("Done.");
			} catch (Exception ex) {
				throw new SQLException("Error:Main:\n" + ex.getMessage());
			} catch (Throwable th) {
				throw new SQLException("Error:Main:\n" + th.getMessage());
			}
		} catch (Exception ex) {
			System.out.println("Error:MainCall:\n" + ex.getMessage());
		} catch (Throwable th) {
			System.out.println("Error:MainCall:\n" + th.getMessage());
		} finally {
			try {
				if (tcon != null)
					tcon.close();
			} catch (SQLException sql) {
				sql.printStackTrace();
			}
		}
		return;
	}
}