package terminal;

import java.math.BigDecimal;
import java.util.Scanner;

public class ScannerValue {

    public static BigDecimal scannerValue() {
        System.out.println("Digite o valor do saque(R$): ");
        Scanner valorEntrada = new Scanner(System.in);
        return valorEntrada.nextBigDecimal();
    }
}
