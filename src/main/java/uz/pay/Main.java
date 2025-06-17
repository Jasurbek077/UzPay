package uz.pay;

import uz.pay.model.Card;
import uz.pay.model.User;
import uz.pay.service.CardService;
import uz.pay.service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        CardService cardService = new CardService();
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);

        //it is just a change for try
        int stepCode = 10;
        while (stepCode != 0){
            System.out.print("""
                    1.Register
                    2.Login
                    0.Exit ==> 
                    """);
            stepCode = scInt.nextInt();
            switch (stepCode){
                case 1 -> {
                    System.out.print("enter your name ");
                    String name = scStr.nextLine();

                    System.out.println("enter your password");
                    String password = scStr.nextLine();


//                    lasjlashdjkasdlasdhasljd
                    userService.registerUser(new User(name,password));
                }
                case 2 -> {
                    System.out.print("enter your name ");
                    String name = scStr.nextLine();

                    System.out.println("enter your password");
                    String password = scStr.nextLine();

                    User user = new User(name,password);
                    userService.loginUser(user);

                    stepCode = 10;
                    while (stepCode != 0){
                        System.out.print("""
                               1.add card
                               2.delete card
                               3.show balance
                               0.exit ==> 
                                """);
                        stepCode = scInt.nextInt();
                        switch (stepCode){
                            case 1 -> {
                                System.out.print("enter card number ");
                                String number = scStr.nextLine();

                                System.out.print("enter card password ");
                                String cardPassword = scStr.nextLine();

                                System.out.print("enter card balance ");
                                int balance = scInt.nextInt();

                                Card card = new Card(number,cardPassword);
                                cardService.addCard(card);
                                card.setCardBalance(balance);
                            }
                            case 2 -> {
                                System.out.print("enter card number ");
                                String number = scStr.nextLine();

                                System.out.print("enter card password ");
                                String cardPassword = scStr.nextLine();

                                cardService.deleteCard(new Card(number,cardPassword));
                            }
                            case 3 -> {
                                System.out.print("enter card number ");
                                String number = scStr.nextLine();

                                System.out.print("enter card password ");
                                String cardPassword = scStr.nextLine();

                                cardService.showBalance(new Card(number,cardPassword));
                            }
                        }
                    }

                }
            }
        }
    }
}
