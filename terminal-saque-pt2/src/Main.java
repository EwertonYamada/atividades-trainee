import terminal.ScannerValue;
import terminal.TerminalSaque;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BigDecimal bigDecimalValue = ScannerValue.scannerValue();
        TerminalSaque terminalSaque = new TerminalSaque();
        terminalSaque.sacar(bigDecimalValue);
    }
}