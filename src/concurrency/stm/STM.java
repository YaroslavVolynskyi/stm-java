package concurrency.stm;

public final class STM {
    private STM() {}

    public static final Object commitLock = new Object();

    public static void transaction(TransactionBlock block) {
        boolean committed = false;
        while (!committed) {
            block.tx = new Transaction();
            block.run();
            committed = block.tx.commit();
        }
    }

}
