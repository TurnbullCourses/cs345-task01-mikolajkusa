package edu.ithaca.dturnbull.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance(), 0.001);
    }

    @Test
    void withdrawTest() throws InsufficientFundsException{
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance(), 0.001);
        assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(300));

       
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com")); // correct email format
        assertFalse( BankAccount.isEmailValid("")); // empty email, it is a border case 
        assertFalse( BankAccount.isEmailValid("a-@b.cc")); // no dashes before @, border case
        assertFalse( BankAccount.isEmailValid("a..b@c")); // no consecutive periods, border case
        assertFalse( BankAccount.isEmailValid(".a@b")); // no non-letters at the first index, border case
        assertFalse( BankAccount.isEmailValid("a@b")); // length of email cannot be less than or equal to 3, border case
        assertFalse( BankAccount.isEmailValid("a@")); //length of email must be greater than 3 characters
        assertFalse( BankAccount.isEmailValid("@")); //length of email must be greater than 3 chracters
        assertFalse( BankAccount.isEmailValid("a@b.b")); // there must be two letters after the dot, border case
        assertTrue( BankAccount.isEmailValid("a@b.bb")); // there must be two letters after the dot
        assertFalse( BankAccount.isEmailValid("a@b.")); // there must be two letters after the dot

    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance(), 0.001);
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}