package kata.bank.domains;

import kata.bank.enums.TransactionType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    private LocalDateTime transactionTime;
    private double amount;
    private TransactionType type;
}
