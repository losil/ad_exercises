package ch.hslu.ad.sw05.ex01;

/**
 * Simple BankAccount which only saves the account balance.
 */
public class BankAccount {

    private int balance;

    /**
     * Creates BankAccount with begin balance.
     *
     * @param balance amount of balance
     */
    public BankAccount(final int balance) {
        this.balance = balance;
    }

    /**
     * Create a BankAccount with an empty balance.
     */
    public BankAccount() {
        this(0);
    }

    public int getBalance() {
        return balance;
    }

    public void deposite(final int amount) {
        this.balance += amount;
    }

    public synchronized void transfer(final BankAccount target, final int amount) {
        this.balance -= amount;
        target.deposite(amount);
    }

    @Override
    public String toString() {
        return "BankAccount with a balance of: " + this.balance;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.balance);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (!(object instanceof BankAccount)) {
            return false;
        }

        BankAccount other = (BankAccount) object;
        return this.balance == other.balance;
    }
}
