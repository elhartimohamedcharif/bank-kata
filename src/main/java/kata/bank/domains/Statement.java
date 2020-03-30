package kata.bank.domains;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Statement extends BaseClass {

    private final static String HEADER = "Date | Amount | Transaction Type | Balancee";

    private Account account;
    private List<StatementLine> statementLines = new LinkedList<>();

    public void print() {
        System.out.println(HEADER);
        statementLines.forEach(StatementLine::print);
    }
}
