package concurrency.stm;

public abstract class TransactionBlock implements Runnable {
    protected Transaction tx;
}
