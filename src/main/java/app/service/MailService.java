package app.service;

import javax.mail.SendFailedException;

public interface MailService{
    public void sendEmail(String to, String mess) throws SendFailedException;
}
