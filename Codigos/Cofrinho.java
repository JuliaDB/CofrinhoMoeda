package trabalho;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
	
	// Lista para armazenar as moedas
    private List<Moeda> moedas;

    // Construtor que inicializa a lista de moedas
    public Cofrinho() { 
        moedas = new ArrayList<>();
    }

    // Método para adicionar uma moeda ao cofrinho
    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda);
    }

    // Método para remover moeda
    public void removerMoeda(int indiceMoeda) {
        if (indiceMoeda >= 0 && indiceMoeda < moedas.size()) {
            Moeda moedaRemovida = moedas.remove(indiceMoeda);
            double valorTotal = moedaRemovida.getValor();
        }
    }

    // Método para listar todas as moedas no cofrinho
    public void listarMoedas() {
        for (Moeda moeda : moedas) {
            System.out.println(moeda.getNome() + " - Valor: " + moeda.getValor());
        }
    }

    // Calcula o valor total de todas as moedas convertidas para real
    public double calcularValorTotalEmReais() {
        double valorTotal = 0.0;
        for (Moeda moeda : moedas) {
            if (moeda instanceof Real) {
                valorTotal += moeda.getValor();
            } else if (moeda instanceof Dolar) {
                valorTotal += moeda.getValor() * 5.92; // Conversão de dólar para real
            } else if (moeda instanceof Euro) {
                valorTotal += moeda.getValor() * 6.25; // Conversão de euro para real
            }
        }
        return valorTotal;
    }

 // Método para remover uma moeda do cofrinho baseado no nome e valor
    public boolean removerMoeda(String nome, double valor) {
        for (int i = 0; i < moedas.size(); i++) { // Percorre a lista de moedas
            Moeda moeda = moedas.get(i);
            if (moeda.getNome().equalsIgnoreCase(nome) && moeda.getValor() == valor) {
                moedas.remove(i); // Remove a moeda encontrada
                return true;
            }
        }
        
        return false; // Moeda não encontrada
    }

    public boolean removerMoeda(Moeda moedaRemover) {
        return moedas.removeIf(moeda -> moeda.equals(moedaRemover)); // Usando a comparação do método equals
    }
}
