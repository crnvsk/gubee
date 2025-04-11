package ConceitosUML.Transaction;

public class TransactionalTestMain {
    public static void main(String[] args) {
        // Cria uma instância do serviço com o proxy
        TransactionalServiceInterface service = TransactionProxy.createProxy(new TransactionalService());

        // Executa métodos anotados e não anotados
        service.performDatabaseOperation();
        System.out.println();

        try {
            service.performFailingOperation();
        } catch (Exception e) {
            System.out.println("Erro capturado no método main: " + e.getMessage());
        }
        System.out.println();

        service.performNonTransactionalOperation();
    }
}