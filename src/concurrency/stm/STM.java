package concurrency.stm;

import concurrency.test.Account;

public final class STM {
    private STM() {}

    public static final Object commitLock = new Object();

    public static void transaction(final Account a, final Account b, final int amount) {
        boolean committed = false;
        while (!committed) {
            Transaction transaction = new Transaction(a, b, amount);
            transaction.run();
            committed = transaction.commit();
        }
    }

}
