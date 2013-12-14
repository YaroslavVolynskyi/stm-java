package concurrency.test;

import concurrency.stm.STM;
import concurrency.stm.TransactionBlock;

public class STMStrategy implements TransferStrategy {
    @Override
    public void transfer(final Account a, final Account b, final int amount) {
        STM.transaction(new TransactionBlock() {
            @Override
            public void run() {
                long old1 = a.getRef().getValue(this.tx);
                a.getRef().setValue(old1 - amount, this.tx);
                long old2 = b.getRef().getValue(this.tx);
                b.getRef().setValue(old2 + amount, this.tx);
            }
        });
    }
}
