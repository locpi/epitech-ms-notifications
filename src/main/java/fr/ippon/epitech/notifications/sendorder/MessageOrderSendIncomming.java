package fr.ippon.epitech.notifications.sendorder;

import java.io.Serializable;

public class MessageOrderSendIncomming implements Serializable {

    private String number;

    private String numeroColis;

    public MessageOrderSendIncomming(){

    }

    public MessageOrderSendIncomming(String number, String numeroColis) {
        this.number = number;
        this.numeroColis = numeroColis;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumeroColis() {
        return numeroColis;
    }

    public void setNumeroColis(String numeroColis) {
        this.numeroColis = numeroColis;
    }
}
