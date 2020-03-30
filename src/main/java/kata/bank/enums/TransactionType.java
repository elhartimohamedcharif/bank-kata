package kata.bank.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TransactionType {

    DEPOSIT("Deposit"),
    WITHDRAWAL("withdrawal");

    private final String label;
}
