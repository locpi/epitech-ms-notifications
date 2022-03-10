package fr.ippon.epitech.notifications;

import fr.ippon.epitech.notifications.mail.EmailService;
import fr.ippon.epitech.notifications.mail.SmsService;
import fr.ippon.epitech.notifications.neworder.MessageNewOrderIncomming;
import fr.ippon.epitech.notifications.sendorder.MessageOrderSendIncomming;
import org.springframework.stereotype.Service;

@Service
public class NotificationSwitcherService {

    private EmailService emailService;
    private SmsService smsService;


    public NotificationSwitcherService(EmailService emailService, SmsService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void sendNotificationNouvelleCommande(MessageNewOrderIncomming messageNewOrderIncomming) {
        this.emailService.sendSimpleMessage(messageNewOrderIncomming.getEmail(), "New order",
            messageNewOrderIncomming.getNom() + " " + messageNewOrderIncomming.getPrenom() + " une nouvelle commande pour vous");
    }

    public void sendNotificationCommandeEnvoye(MessageOrderSendIncomming messageOrderSendIncomming) {
        String message = "Votre colis numéro " + messageOrderSendIncomming.getNumeroColis() + " est en route";
        smsService.sendSms(messageOrderSendIncomming.getNumber(), message);
    }


}
