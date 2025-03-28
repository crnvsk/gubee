package Annotations;

public class OverrideFuncionario {
    protected double salario;

    public double getSalarioTotal(double bonus) {
        return this.salario + bonus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Funcionario [salario=");
        builder.append(salario);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(salario);
        result = prime * result + (int)
  (temp ^ (temp >>> 32));
        return result;
    }

}
