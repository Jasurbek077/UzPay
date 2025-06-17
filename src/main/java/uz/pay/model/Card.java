package uz.pay.model;

import lombok.Data;

import java.util.UUID;
@Data
public class Card {
    private String cardNumber;
    private String password;
    private int cardBalance;

    public Card(String cardNumber, String password) {
        this.cardNumber = cardNumber;
        this.password = password;
    }

}
