package terminal.menu;

import terminal.utils.enums.MenuOptions;
import terminal.utils.scan.ScannerInputValue;

public class MainMenu {
    public void showMainMenu() {
        System.out.println(
                """
                         Bem vindo ao Banco SG. Selecione uma opção:
                         1. Depósito
                         2. Saque
                         3. Transferência
                         4. Ver saldo
                """
        );

        MenuOptions option = ScannerInputValue.getInputValue();
        this.handleSelectedOption(option);
    }

    public void handleSelectedOption(MenuOptions option) {
        switch (option) {
            case SAQUE:
            case DEPOSITO:
            case TRANSFERENCIA:
                this.doTransaction(option);
            case VER_SALDO: this.showBalance();
        }
    }

    private void doTransaction(MenuOptions option) {

    }

    private void showBalance() {

    }

}
