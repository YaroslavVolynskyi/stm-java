package concurrency.test;

import concurrency.stm.STM;


public class STMStrategy implements TransferStrategy {
    @Override
    public void transfer(final Account a, final Account b, final int amount) {
        STM.transaction(a, b, amount);
    }
}
