package fr.ippon.epitech.notifications.mail;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public void sendSms(String number, String message) {
        System.out.println("SMS (" + number + ") : " + message);
    }


}
