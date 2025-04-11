package ConceitosUML.Transaction;

public interface TransactionalServiceInterface {
    void performDatabaseOperation();

    void performFailingOperation();

    void performNonTransactionalOperation();
}