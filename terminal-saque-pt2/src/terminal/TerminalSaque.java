package terminal;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class TerminalSaque {
    private final Map<BigDecimal, Integer> moedasEmCaixa = new LinkedHashMap<>();
    private BigDecimal totalEmCaixa;

    public TerminalSaque() {
        moedasEmCaixa.put(BigDecimal.valueOf(200.00), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(100.00), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(50.00), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(20.00), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(10.00), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(5.00), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(2.00), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(1.00), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(0.50), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(0.25), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(0.1), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(0.05), 1);
        moedasEmCaixa.put(BigDecimal.valueOf(0.01), 1);
        totalEmCaixa = moedasEmCaixa.entrySet().stream()
                .map(moeda -> moeda.getKey().multiply(BigDecimal.valueOf(moeda.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void sacar() {
        BigDecimal bigDecimalValue = ScannerValue.scannerValue();
        if (bigDecimalValue.compareTo(this.totalEmCaixa) > 0) {
            throw new RuntimeException("Saldo insuficiente!");
        }
        Map<BigDecimal, Integer> mapMoedasQuantidades = this.calcularMoedas(bigDecimalValue);
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
        if (valorRestante.compareTo(BigDecimal.ZERO) > 0) {
            throw new RuntimeException("Caixa eletrônico não possui espécies suficientes para o valor informado!");
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
