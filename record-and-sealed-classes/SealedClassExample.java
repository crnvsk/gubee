sealed class Forma permits Circulo, Retangulo {
}

final class Circulo extends Forma {
    double raio;

    Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public String toString() {
        return "Círculo com raio: " + raio;
    }
}

final class Retangulo extends Forma {
    double largura, altura;

    Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Retângulo com largura: " + largura + ", altura: " + altura;
    }
}

public class SealedClassExample {
    public static void main(String[] args) {
        Forma f1 = new Circulo(5.0);
        Forma f2 = new Retangulo(3.0, 4.0);

        System.out.println("Criado um círculo e um retângulo.");
        System.out.println(f1);
        System.out.println(f2);
    }
}
