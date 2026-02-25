package terminal;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class TerminalSaque {
    private final Map<BigDecimal, Integer> moedasEmCaixa = new LinkedHashMap<>();

    public TerminalSaque() {
        moedasEmCaixa.put(BigDecimal.valueOf(200.00), 0);
        moedasEmCaixa.put(BigDecimal.valueOf(100.00), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(50.00), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(20.00), 0);
        moedasEmCaixa.put(BigDecimal.valueOf(10.00), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(5.00), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(2.00), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(1.00), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(0.50), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(0.25), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(0.10), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(0.05), 10);
        moedasEmCaixa.put(BigDecimal.valueOf(0.01), 10);
    }

    public void sacar(BigDecimal valor) {
        Map<BigDecimal, Integer> mapMoedasQuantidades = this.calcularMoedas(valor);
        this.apresentarResultado(mapMoedasQuantidades);
    }

    private Map<BigDecimal, Integer> calcularMoedas(BigDecimal valor) {
        BigDecimal valorRestante = valor;
        Map<BigDecimal, Integer> mapMoedaQuantidade = new LinkedHashMap<>();

        for (Map.Entry<BigDecimal, Integer> moeda : moedasEmCaixa.entrySet()) {
            if (valorRestante.compareTo(BigDecimal.ZERO) == 0) break;

            int quantidadeNecessariaMoeda = valorRestante.divide(moeda.getKey()).intValue();
            if (moeda.getValue() == 0 || quantidadeNecessariaMoeda < 1) continue;

            if (moeda.getValue() <= quantidadeNecessariaMoeda) {
                quantidadeNecessariaMoeda = moeda.getValue();
            }

            mapMoedaQuantidade.put(moeda.getKey(), quantidadeNecessariaMoeda);
            valorRestante = valorRestante.subtract(moeda.getKey().multiply(BigDecimal.valueOf(quantidadeNecessariaMoeda)));
        }
        return mapMoedaQuantidade;
    }

    private void apresentarResultado(Map<BigDecimal, Integer> mapMoedasQuantidades) {
        if (mapMoedasQuantidades.isEmpty()) System.out.println("Não há valor para saque.");

        for (Map.Entry<BigDecimal, Integer> entry : mapMoedasQuantidades.entrySet()) {
            BigDecimal nota = entry.getKey();
            Integer quantidade = entry.getValue();
            System.out.println("Nota: " + nota + " Quantidade: " + quantidade);
        }
    }
}
