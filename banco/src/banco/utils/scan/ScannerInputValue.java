package terminal.utils.scan;

import terminal.utils.enums.MenuOptions;

import java.util.Scanner;

public class ScannerInputValue {

    public static MenuOptions getInputValue() {
        Scanner option = new java.util.Scanner(System.in);
        return MenuOptions.valueOf(String.valueOf(option.nextLong()));
    }
}
