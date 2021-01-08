package limuiju.todolist.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("eoaudehd0818@gmail.com"
				, "qnsghdekf105!");
	}
	
}
