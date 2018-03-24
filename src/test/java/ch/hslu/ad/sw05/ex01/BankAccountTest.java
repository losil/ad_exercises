package ch.hslu.ad.sw05.ex01;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testGetBalance() {
        BankAccount bc = new BankAccount(200);
        BankAccount bc1 = new BankAccount(0);
        assertThat(bc.getBalance()).isEqualTo(200);
        assertThat(bc1.getBalance()).isEqualTo(0);
    }

    @Test
    public void testDeposite() {
        BankAccount bc = new BankAccount();
        bc.deposite(100);
        assertThat(bc.getBalance()).isEqualTo(100);

    }

    @Test
    public void testTransfer() {
        BankAccount source = new BankAccount(200);
        BankAccount target = new BankAccount();
        source.transfer(target, 150);
        assertThat(source.getBalance()).isEqualTo(50);
        assertThat(target.getBalance()).isEqualTo(150);

    }

    @Test
    public void testHashCode() {
        BankAccount bc1 = new BankAccount(100);
        BankAccount bc2 = new BankAccount(200);
        assertThat(bc1.hashCode()).isNotEqualTo(bc2.hashCode());

    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(BankAccount.class);
    }
}