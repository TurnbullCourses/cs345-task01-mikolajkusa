package edu.ithaca.dturnbull.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
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
    public void withdraw (double amount) throws InsufficientFundsException{
        if (amount <= balance){
            balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Not enough money");
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

        else if (email.charAt(email.indexOf('.')) == email.charAt(email.indexOf('.') + 1)){
            return false;
        }

        else if (!Character.isLetter(email.charAt(0))){
            return false;
        }

        // else if (email.substring(email.indexOf('@')).length() <= 4){
        //     return false;
        // }

        else if (!Character.isLetter(email.charAt(email.length() - 2))){
            return false;
        }

        else {
            return true;
        }
    }
}