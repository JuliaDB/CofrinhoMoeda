package trabalho;

public class Euro extends Moeda {
	
    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String getNome() {
        return "Euro";
    }
}