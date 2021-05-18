package banking;
import java.util.Random;

public class CreditCard {
    private String cardNumber; // cardNumber = IIN + cAccountNr + checkSumNr
    private int PinNr = 0000;// pinNr
    private double cardBalance = 0;
    private final int IINR = 400000; // final
    private int checkSumNr; //last digit of cardNumber
    private int[] cAccountNrFrom = new int[9];// an Array Form for 9 digits Nr
    private int[] pinNrForm = new int[4]; // to generate 4 random digits Pin
    private Random nrGenerator = new Random(); // Generate random number

    protected String generateCardNr() {
        StringBuilder builder = new StringBuilder();
        builder.append(IINR);
        builder.append(cAccountNrGenerator());
        builder.append(checkSumNrGenerator());
        while(builder.length()==16){
            cardNumber = builder.toString();
            return cardNumber;
        }
        return cardNumber;
    }

    protected String getCardNr(){
        return cardNumber;
    }

    protected int getPinNr(){
        return PinNr;
    }

    protected int generatePinNr() {
        StringBuilder builder = new StringBuilder();
        builder.append(pinNrGenerator());
        while(builder.length()==4){
            PinNr = Integer.parseInt(builder.toString());
            return PinNr;
        }
        return PinNr;

    }

    protected double getCardBalance() {
        return cardBalance;
    }

    private void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    private int cAccountNrGenerator() {
    StringBuilder builder = new StringBuilder();
    for(int raNr : cAccountNrFrom){
        raNr = nrGenerator.nextInt(9);
        builder.append(raNr);
    }
     int raNr = Integer.parseInt(builder.toString());
     return raNr;
    }

    private int pinNrGenerator() {
        StringBuilder builder = new StringBuilder();
        for(int raNr : pinNrForm){
            raNr = nrGenerator.nextInt(9);
            builder.append(raNr);
        }
        int raNr = Integer.parseInt(builder.toString());
        return raNr;
    }

    private int checkSumNrGenerator() {
        checkSumNr = nrGenerator.nextInt(9);
        return checkSumNr;
    }

}
