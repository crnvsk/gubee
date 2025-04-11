package ConceitosUML.Transaction;

public class TransactionalService implements TransactionalServiceInterface{

    @Transaction
    public void performDatabaseOperation() {
        System.out.println("Executando operação no banco de dados...");
        // Simula uma operação bem-sucedida
    }

    @Transaction
    public void performFailingOperation() {
        System.out.println("Executando operação que falha...");
        // Simula uma falha
        throw new RuntimeException("Erro simulado na operação");
    }

    public void performNonTransactionalOperation() {
        System.out.println("Executando operação sem transação...");
    }
}