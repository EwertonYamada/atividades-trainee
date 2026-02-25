package terminal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.math.BigDecimal.*;

public class TerminalSaque {
    private final BigDecimal[] moedasEmCaixa = {
            valueOf(200.00), valueOf(100.00), valueOf(50.00), valueOf(20.00),
            valueOf(10.00), valueOf(5.00), valueOf(2.00), valueOf(1.00),
            valueOf(0.50), valueOf(0.25), valueOf(0.10), valueOf(0.05), valueOf(0.01)
    };

    public void sacar(BigDecimal valor) {
        Map<BigDecimal, Integer> mapMoedasQuantidades = this.calcularMoedas(valor);
        this.apresentarResultado(mapMoedasQuantidades);
    }

    private Map<BigDecimal, Integer> calcularMoedas(BigDecimal valor) {
        BigDecimal valorRestante = valor;
        Map<BigDecimal, Integer> mapMoedaQuantidade = new LinkedHashMap<>();

        for (BigDecimal moeda : moedasEmCaixa) {
            if (valorRestante.compareTo(ZERO) == 0) break;

            int quantidadeMoeda = valorRestante.divide(moeda, 2, RoundingMode.HALF_EVEN).intValue();
            if (quantidadeMoeda == 0) continue;

            mapMoedaQuantidade.put(moeda, quantidadeMoeda);
            valorRestante = valorRestante.subtract(valueOf(quantidadeMoeda).multiply(moeda));
        }
        return mapMoedaQuantidade;
    }

    private void apresentarResultado(Map<BigDecimal, Integer> mapMoedasQuantidades) {
        if (mapMoedasQuantidades.isEmpty()) {
            System.out.println("Não há valor para saque.");
            return;
        }

        for (Map.Entry<BigDecimal, Integer> entry : mapMoedasQuantidades.entrySet()) {
            BigDecimal nota = entry.getKey();
            Integer quantidade = entry.getValue();
            System.out.println("Nota/modeda: " + nota + " Quantidade: " + quantidade);
        }
    }
}
