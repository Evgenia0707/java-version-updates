package stream.traders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import stream.traders.Trader;
@Data
@AllArgsConstructor
@Getter
@ToString
public class Transaction {

    private Trader trader;
    private int year;
    private int value;



}
