package fr.ippon.epitech.commandes.mail;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public void sendSms(String number, String message) {
        System.out.println("SMS (" + number + ") : " + message);
    }


}
