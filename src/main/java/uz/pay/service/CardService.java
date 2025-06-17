package uz.pay.service;

import uz.pay.model.Card;
import uz.pay.utility.FileUtility;

import java.util.List;

public class CardService {

    private static final String CARD_FILE = "./files/cards/json";
    private final List<Card> cards;

    public CardService() {
        cards = FileUtility.loadFileFromJson(CARD_FILE, Card.class);
    }

    public boolean addCard(Card card){
        for (Card c : cards) {
            if(c.equals(card)){
                return false;
            }
        }
        cards.add(card);
        FileUtility.saveFileToJson(CARD_FILE,cards);
        return true;
    }

    public boolean deleteCard(Card card){
        for (Card card1 : cards) {
            if(card1.equals(card)){
                cards.remove(card);
                FileUtility.saveFileToJson(CARD_FILE,cards);
                return true;
            }
        }
        return false;
    }

    public void showBalance(Card card){
        for (Card card1 : cards) {
            if(card != null && card1.equals(card)){
                System.out.println("Card balance "+card1.getCardBalance());
            }
        }

    }

}
