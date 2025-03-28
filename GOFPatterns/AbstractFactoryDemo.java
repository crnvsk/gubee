package GOFPatterns;

// 1. Interfaces para os produtos (Botão e Checkbox)
interface Botao {
    void desenhar();
}

interface Checkbox {
    void desenhar();
}

// 2. Implementações concretas para Windows
class BotaoWindows implements Botao {
    @Override
    public void desenhar() {
        System.out.println("Desenhando botão estilo Windows.");
    }
}

class CheckboxWindows implements Checkbox {
    @Override
    public void desenhar() {
        System.out.println("Desenhando checkbox estilo Windows.");
    }
}

// 3. Implementações concretas para Mac
class BotaoMac implements Botao {
    @Override
    public void desenhar() {
        System.out.println("Desenhando botão estilo Mac.");
    }
}

class CheckboxMac implements Checkbox {
    @Override
    public void desenhar() {
        System.out.println("Desenhando checkbox estilo Mac.");
    }
}

// 4. Abstract Factory
interface UIFactory {
    Botao criarBotao();
    Checkbox criarCheckbox();
}

// 5. Implementações concretas da fábrica
class WindowsUIFactory implements UIFactory {
    @Override
    public Botao criarBotao() {
        return new BotaoWindows();
    }

    @Override
    public Checkbox criarCheckbox() {
        return new CheckboxWindows();
    }
}

class MacUIFactory implements UIFactory {
    @Override
    public Botao criarBotao() {
        return new BotaoMac();
    }

    @Override
    public Checkbox criarCheckbox() {
        return new CheckboxMac();
    }
}

// Teste do padrão Abstract Factory
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Criar UI para Windows
        UIFactory fabricaWindows = new WindowsUIFactory();
        Botao botaoWindows = fabricaWindows.criarBotao();
        Checkbox checkboxWindows = fabricaWindows.criarCheckbox();
        botaoWindows.desenhar();
        checkboxWindows.desenhar();

        // Criar UI para Mac
        System.out.println("\nMudando para Mac:");
        UIFactory fabricaMac = new MacUIFactory();
        Botao botaoMac = fabricaMac.criarBotao();
        Checkbox checkboxMac = fabricaMac.criarCheckbox();
        botaoMac.desenhar();
        checkboxMac.desenhar();
    }
}
