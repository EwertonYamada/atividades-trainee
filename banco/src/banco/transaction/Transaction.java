package terminal.transaction;

import terminal.utils.enums.TransactionType;

import java.math.BigDecimal;

public class Transaction {
    private BigDecimal value;
    private TransactionType transactionType;
    private Long orginAccount;
    private Long destinationAccount;
}
