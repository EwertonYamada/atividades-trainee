import terminal.ScannerValue;
import terminal.TerminalSaque;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal valor = ScannerValue.scannerValue();
        TerminalSaque terminalSaque = new TerminalSaque();
        terminalSaque.sacar(valor);
    }
}