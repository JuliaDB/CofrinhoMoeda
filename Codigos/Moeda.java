package trabalho;

import java.util.Objects;

public abstract class Moeda {
	
	protected double valor;

	public Moeda(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public abstract String getNome();
	
	@Override // equals para comparar as moedas corretamente
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moeda moeda = (Moeda) obj;
        return Double.compare(moeda.valor, valor) == 0 && getNome().equals(moeda.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, getNome());
    }
		
}
