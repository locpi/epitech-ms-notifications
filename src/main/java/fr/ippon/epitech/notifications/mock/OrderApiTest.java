package fr.ippon.epitech.notifications.mock;

import fr.ippon.epitech.notifications.neworder.MessageNewOrderIncomming;
import fr.ippon.epitech.notifications.sendorder.MessageOrderSendIncomming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications/orders")
@Profile("dev")
public class OrderApiTest {

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/new")
    public MessageNewOrderIncomming newOrder() {
        MessageNewOrderIncomming message = new MessageNewOrderIncomming();
        message.setEmail("loic.pincon@mieakl.com");
        message.setNom("Pincon");
        message.setPrenom("loic");
        jmsTemplate.convertAndSend("notification_new_order", message);
        return message;
    }

    @GetMapping("/send")
    public MessageOrderSendIncomming sendOrder() {
        MessageOrderSendIncomming messageOrderSendIncomming = new MessageOrderSendIncomming("0698765432", "FRA-5678");
        jmsTemplate.convertAndSend("notification_send_order", messageOrderSendIncomming);
        return messageOrderSendIncomming;
    }


}
