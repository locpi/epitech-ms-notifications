package fr.ippon.epitech.commandes;

import fr.ippon.epitech.commandes.neworder.MessageNewOrderIncomming;
import fr.ippon.epitech.commandes.sendorder.MessageOrderSendIncomming;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationOrderListener {

    private NotificationSwitcherService notificationSwitcherService;

    public NotificationOrderListener(NotificationSwitcherService notificationSwitcherService) {
        this.notificationSwitcherService = notificationSwitcherService;
    }

    @JmsListener(destination = "notification_new_order")
    public void newOrder(MessageNewOrderIncomming messageNewOrderIncomming) {
        notificationSwitcherService.sendNotificationNouvelleCommande(messageNewOrderIncomming);
    }

    @JmsListener(destination = "notification_send_order")
    public void orderSend(MessageOrderSendIncomming messageOrderSendIncomming) {
        notificationSwitcherService.sendNotificationCommandeEnvoye(messageOrderSendIncomming);
    }

}

