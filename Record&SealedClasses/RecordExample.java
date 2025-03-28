public class RecordExample {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Carlos", 25);
        System.out.println(p.saudacao());

        // Métodos automáticos gerados pelo `record`
        System.out.println(p); // Pessoa[nome=Carlos, idade=25]
        System.out.println(p.nome()); // Carlos
        System.out.println(p.idade()); // 25
    }

    public record Pessoa(String nome, int idade) {
        public String saudacao() {
            return "Olá, meu nome é " + nome + " e tenho " + idade + " anos.";
        }
    }
}
