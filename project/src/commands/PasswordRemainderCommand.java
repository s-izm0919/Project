package commands;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import bean.User;
import context.RequestContext;
import context.ResponseContext;
import dao.AbstractDaoFactory;
import dao.UserDao;

public class PasswordRemainderCommand extends AbstractCommand {
	@SuppressWarnings("unused")
	public ResponseContext execute(ResponseContext resc) {
		System.out.println("-- PasswordRemainderCommand --");

		RequestContext reqc = getRequestContext();




		String email=reqc.getParameter("email")[0];
		System.out.println("inputemail:"+email);
		User user=null;

		AbstractDaoFactory factory=AbstractDaoFactory.getFactory();
	UserDao dao=factory.getUserDao();
		user=dao. getUserPassword(email);
		System.out.println("user:"+user);

		System.out.println("userpassword:"+user.getUserPassword());

		if(user!=null) {
		     String toEmail = user.getUserMail();
		        System.out.println("email to be sent:"+toEmail);



		        String fromEmail = "ttc733@gmail.com";

		       // msender831@gmail.com
		        //String password = "Mailsender@1";
		        String password = "Test1234@";

		        try {

		        	Properties prop = System.getProperties();

		            prop.put("mail.smtp.host", "smtp.gmail.com");
		            prop.put("mail.smtp.port", "465");
		            prop.put("mail.smtp.ssl.enable", "true");
		            prop.put("mail.smtp.auth", "true");


		            //get session to authenticate the host email address and password
		            Session session = Session.getDefaultInstance(prop, new Authenticator() {
		                @Override
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication(fromEmail, password);
		                }
		            });
		            session.setDebug(true);

		            //set email message details
		           Message mess = new MimeMessage(session);


		    		//set from email address
		           mess.setFrom(new InternetAddress(fromEmail));
		          //  mess.setFrom(fromEmail);

		    		//set to email address or destination email address
		            mess.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

		    		//set email subject
		            mess.setSubject("User Email Verification");

		    		//set message text
		            mess.setText("your password is: " + user.getUserPassword());

		            //send the message


		            Transport.send(mess);
		            //Transport.send(mess, toEmail);
		            System.out.println("email sent successfuly");



		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		}
		else System.out.println("message could not sent");



	resc.setTarget("adduser");
		return resc;
	}
}

