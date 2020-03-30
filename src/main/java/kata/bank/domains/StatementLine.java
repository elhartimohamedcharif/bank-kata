package kata.bank.domains;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatementLine {
    private Transaction transaction;
    private double currentBalance;


    public void print(){
        System.out.println(transaction.getTransactionTime() +" | "+ transaction.getAmount() +" | "+ transaction.getType()+" | "+this.getCurrentBalance());
    }
}
