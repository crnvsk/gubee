package GOFPatterns;

// Interface comum para Proxy e Serviço Real
interface Servico {
    void executar();
}

// Serviço Real (o objeto original)
class ServicoReal implements Servico {
    @Override
    public void executar() {
        System.out.println("Executando serviço real...");
    }
}

// Proxy que controla o acesso ao serviço real
class ServicoProxy implements Servico {
    private ServicoReal servicoReal;
    private boolean usuarioAutenticado;

    public ServicoProxy(boolean usuarioAutenticado) {
        this.usuarioAutenticado = usuarioAutenticado;
    }

    @Override
    public void executar() {
        if (usuarioAutenticado) {
            if (servicoReal == null) {
                servicoReal = new ServicoReal();
            }
            servicoReal.executar();
        } else {
            System.out.println("Acesso negado! Usuário não autenticado.");
        }
    }
}

// Teste do padrão Proxy
public class ProxyDemo {
    public static void main(String[] args) {
        Servico servicoNaoAutorizado = new ServicoProxy(false);
        servicoNaoAutorizado.executar(); // Deve negar o acesso

        Servico servicoAutorizado = new ServicoProxy(true);
        servicoAutorizado.executar(); // Deve permitir o acesso
    }
}
