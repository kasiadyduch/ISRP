package app.controller;

import app.service.MailService;
import app.service.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.SendFailedException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, allowCredentials = "true", allowedHeaders = "GET, POST, PUT, OPTION, DELETE")
public class MailServiceController {

    @Autowired
    MailService mailService;

    public MailServiceController() {
        mailService = new MailServiceImpl();
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void send(
            @RequestParam(value = "mail") String mail,
            @RequestParam(value = "mess") String mess
    ) throws SendFailedException {
        mailService.sendEmail(mail, mess);
    }
}
