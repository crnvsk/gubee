package GOFPatterns;

// Classe abstrata com o template method
abstract class Pagamento {
    // Template method - define a sequência das operações
    public final void processarPagamento() {
        validarDados();
        processar();
        enviarConfirmacao();
    }

    abstract void validarDados(); // Definido pelas subclasses
    abstract void processar(); // Definido pelas subclasses

    // Método comum para todas as subclasses
    private void enviarConfirmacao() {
        System.out.println("Enviando confirmação de pagamento...");
    }
}

// Implementação para pagamento com cartão de crédito
class PagamentoCartao extends Pagamento {
    @Override
    void validarDados() {
        System.out.println("Validando dados do cartão...");
    }

    @Override
    void processar() {
        System.out.println("Processando pagamento via cartão de crédito...");
    }
}

// Implementação para pagamento via PayPal
class PagamentoPayPal extends Pagamento {
    @Override
    void validarDados() {
        System.out.println("Validando conta PayPal...");
    }

    @Override
    void processar() {
        System.out.println("Processando pagamento via PayPal...");
    }
}

// Teste do padrão Template Method
public class TemplateMethodDemo {
    public static void main(String[] args) {
        System.out.println("Pagamento com Cartão:");
        Pagamento pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.processarPagamento();

        System.out.println("\nPagamento com PayPal:");
        Pagamento pagamentoPayPal = new PagamentoPayPal();
        pagamentoPayPal.processarPagamento();
    }
}
