package trabalho;

public class Real extends Moeda {
	
    public Real(double valor) {
        super(valor);
    }

    @Override
    public String getNome() {
        return "Real";
    }
}