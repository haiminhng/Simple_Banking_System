package banking;
import java.util.Scanner;
import java.util.Random;

public class Bank {
    Random ccidGenerator = new Random();
    static Scanner input = new Scanner(System.in);
    public static void init() {
        CreditCard ccNr1 = new CreditCard();
        int userchoice = 0;
        String checkCCNr;
        int checkCCpin = 0;
        do{
            System.out.println("1. Create an account\n" +
                    "2. Log into account\n" +
                    "0. Exit");
            userchoice = input.nextInt();
            switch(userchoice){
                case 0:
                    System.out.println("Bye!");
                    break;
                case 1:
                    System.out.println("Your card has been created\n" +
                            "Your card number:");
                    System.out.println(ccNr1.generateCardNr());
                    System.out.println("Your card PIN:");
                    System.out.println(ccNr1.generatePinNr());
                    break;
                case 2:
                    System.out.println("Enter your card number:");
                    checkCCNr = input.next();
                    System.out.println("Enter your PIN:");
                    checkCCpin = input.nextInt();
                    if(checkCCNr.equals(ccNr1.getCardNr()) && checkCCpin == ccNr1.getPinNr()){
                        System.out.println("You have successfully logged in!\n");
                        do {
                            System.out.println("1. Balance\n" +
                                    "2. Log out\n" +
                                    "0. Exit");
                            userchoice = input.nextInt();
                            switch (userchoice) {
                                case 0:
                                    userchoice = 3;
                                    break;
                                case 1:
                                    System.out.println("Balance: "+ccNr1.getCardBalance());
                                    break;
                                case 2:
                                    userchoice = 3;
                                    System.out.println("You have successfully logged out!");
                                    break;
                                default:
                                    break;
                            }
                        }while (userchoice != 3);
                    }
                    else{
                        System.out.println("Wrong card number or PIN!");
                    }
                    break;
                default:
                    break;
            }
        }while(userchoice != 0);
    }
}