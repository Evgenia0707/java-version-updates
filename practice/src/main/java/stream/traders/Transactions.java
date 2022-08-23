package stream.traders;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Transactions {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
//1. Find all transactions in the year 2011 and sort them by value(small to high)
        List<Transaction> trans2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());//returns a Collector describing how to accumulate a stream into a list
        System.out.println(trans2011);

        System.out.println("___________________________________________________________");
//2. What are all the unique cities where the traders work?
        Set<String> uniqueCity = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(toSet());
        System.out.println(uniqueCity);

        System.out.println("________________________");

        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("___________________________________________________________");
//3. Find all traders from Cambridge and sort them by name.
        List<Trader> tradCamb = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(tradCamb);//[Trader{name='Alan', city='Cambridge'}, Trader{name='Brian', city='Cambridge'}, Trader{name='Raoul', city='Cambridge'}]

        System.out.println("___________________________________________________________");
//4. Return a string of all traders’ names sorted alphabetically.
        String traderNameAlph = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(" "));
//              .reduce("",(name1,name2) -> name1 + name2);
        System.out.println(traderNameAlph);//Alan Brian Mario Raoul

        System.out.println("___________________________________________________________");
//5. Are any traders based in Milan?
        boolean isInMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(isInMilan);//true

        System.out.println("___________________________________________________________");
//6. Print the values of all transactions from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("___________________________________________________________");
//7. What is the highest value of all the transactions?
        Integer highestValueTrans = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
//                .max(comparing(Transaction::getValue));
        System.out.println(highestValueTrans);//1000

        System.out.println("__________________");

        Optional<Integer> highValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(highValue.get());

        System.out.println("___________________________________________________________");
//8. Find the transaction with the smallest value.
        Integer smallValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println(smallValue);//300

        System.out.println("__________________");

        Optional<Transaction> smallValue1 = transactions.stream()
                .reduce((t1,t2) -> t1.getValue()<t2.getValue() ? t1 : t2);
        System.out.println(smallValue1.get());

    }
}
