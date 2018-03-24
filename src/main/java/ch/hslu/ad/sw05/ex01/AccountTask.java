package ch.hslu.ad.sw05.ex01;

public class AccountTask implements Runnable {
    private BankAccount source;
    private BankAccount target;
    private int amount;

    public AccountTask(final BankAccount source, final BankAccount target, final int amount) {
        this.source = source;
        this.target = target;
        this.amount = amount;
    }

    private void transfer() {
        source.transfer(target, amount);
    }

    @Override
    public void run() {
        transfer();
    }
}
