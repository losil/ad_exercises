package ch.hslu.ad.sw05.ex01;

import org.omg.PortableInterceptor.ACTIVE;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> sourceAccounts;
    private List<BankAccount> targetAccounts;
    private int startAmount;
    private int accountNumber;

    public Bank(final int accountNumber, final int startAmount) {
        this.sourceAccounts = new ArrayList<>();
        this.targetAccounts = new ArrayList<>();
        this.startAmount = startAmount;
        this.accountNumber = accountNumber;
    }

    public void createAccounts() {
        for (int i = 0; i < this.accountNumber; i++) {
            this.sourceAccounts.add(new BankAccount(this.startAmount));
            this.targetAccounts.add(new BankAccount(this.startAmount));
        }
    }

    public void startTransfers(final int number, final int amount) {
        final Thread[] threads = new Thread[number * 2];
        for (int i = 0; i < number; i++) {
            threads[i] = new Thread(new AccountTask(sourceAccounts.get(i), targetAccounts.get(i), amount));
            threads[i + number] = new Thread(new AccountTask(targetAccounts.get(i), sourceAccounts.get(i), amount));
        }

        for (final Thread thread : threads) {
            thread.start();
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (BankAccount account : this.sourceAccounts) {
            builder.append("Source" + account + "\n");
        }

        for (BankAccount account : this.targetAccounts) {
            builder.append("Target" + account + "\n");
        }
        return builder.toString();
    }


}
