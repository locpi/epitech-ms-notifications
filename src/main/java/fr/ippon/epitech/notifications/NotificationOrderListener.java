package fr.ippon.epitech.notifications;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.ippon.epitech.notifications.neworder.MessageNewOrderIncomming;
import fr.ippon.epitech.notifications.sendorder.MessageOrderSendIncomming;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationOrderListener {

    private NotificationSwitcherService notificationSwitcherService;

    public NotificationOrderListener(NotificationSwitcherService notificationSwitcherService) {
        this.notificationSwitcherService = notificationSwitcherService;
    }

    @JmsListener(destination = "notification_new_order")
    public void newOrder(String messageNewOrderIncomming) {
        System.out.println(messageNewOrderIncomming);
        try {
            ObjectMapper mapper = new ObjectMapper();
            MessageNewOrderIncomming messageNewOrderIncomming1 = mapper.readValue(messageNewOrderIncomming, MessageNewOrderIncomming.class);
            notificationSwitcherService.sendNotificationNouvelleCommande(messageNewOrderIncomming1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    @JmsListener(destination = "notification_send_order")
    public void orderSend(String messageOrderSendIncomming) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            MessageOrderSendIncomming messageOrderSendIncomming1 = mapper.readValue(messageOrderSendIncomming,
                MessageOrderSendIncomming.class);
            notificationSwitcherService.sendNotificationCommandeEnvoye(messageOrderSendIncomming1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}

