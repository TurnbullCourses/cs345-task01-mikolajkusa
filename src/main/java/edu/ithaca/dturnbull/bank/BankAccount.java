package edu.ithaca.dturnbull.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)&&isAmountValid(startingBalance)){
            this.email = email;
            this.balance = startingBalance;
        }
        if(!isEmailValid(email)) {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
        if(!isAmountValid(startingBalance)){
            throw new IllegalArgumentException("starting balance is an invalid number");
        }
        
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     * @throws InsufficientFundsException if amount exceeds current balance or is a negative number
     */
    public void withdraw (double amount) throws InsufficientFundsException, IllegalArgumentException{
        
        if(!isAmountValid(amount)){
            throw new IllegalArgumentException("Invalid amount");
        }

        else if (amount <= balance){
            balance = balance - amount;
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }

    /**
     * Static method that checks the amount for validity
     * @param amount money to withdraw that is checked
     * @return true if the amount is valid (positive and has 2 decimal spaces or less), false if otherwise
     */
    public static boolean isAmountValid(double amount){
        if((amount*100)%1 != 0){
            return false;
        }
        else if(amount<0){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }

        else if (email.length() <= 3){
            return false;
        }

        else if (email.charAt(email.indexOf('-') + 1) == email.charAt(email.indexOf('@'))){
            return false;
        }

        else if (email.charAt(email.indexOf('.')) == email.charAt(email.length() - 1)){
            return false;
        }

        else if (email.charAt(email.indexOf('.')) == email.charAt(email.indexOf('.') + 1)){
            return false;
        }

        else if (!Character.isLetter(email.charAt(0))){
            return false;
        }

        else if (!Character.isLetter(email.charAt(email.length() - 2))){
            return false;
        }

        else {
            return true;
        }
    }
}