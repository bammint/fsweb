package a1023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main1 {
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
                                new Transaction(alan, 2012, 950));

                // 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오
                List<Transaction> transactionsIn2011 = transactions.stream()
                                .filter(transaction -> transaction.getYear() == 2011)
                                .sorted(Comparator.comparing(Transaction::getValue))
                                .collect(Collectors.toList());
                System.out.println(transactionsIn2011);
                // ----------------------------------------------------------------------------

                // 거래자가 근무하는 모든 도시를 중복없이 나열하시오
                List<String> transaction2 = transactions.stream()
                                .map(Transaction::getTrader) // Transaction 에서는 Trader를 추출
                                .map(Trader::getCity) // Trader 도시 이름을 추출
                                .distinct()
                                .collect(Collectors.toList());
                System.out.println(transaction2);

                List<String> cities = transactions.stream()
                                .map(transaction -> transaction.getTrader().getCity())
                                .distinct()
                                .collect(Collectors.toList());
                System.out.println(cities);
                // -------------------------------------------------------------------------------

                // 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
                // List<String> cambridge = transactions.stream()
                // .map(c -> transaction.getTrader().getCity("Cambridge"))
                // .map(n -> c.getName())
                // .sorted();

                List<String> Cambridge_traders = transactions.stream()
                                .map(Transaction::getTrader) // Transaction 객체를 Trader 객체로 변환(3. 객체변환)
                                .filter(s -> s.getCity().equals("Cambridge"))
                                .map(s -> s.getName()) // 각 거래자의 이름만을 추출(정보를 추출)
                                .distinct()
                                .sorted()
                                .collect(Collectors.toList());
                System.out.println("Cambridge_traders : " + Cambridge_traders);

                List<String> quiz3 = transactions.stream()
                                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                                .map(transaction -> transaction.getTrader().getName())
                                .distinct()
                                .sorted().collect(Collectors.toList());
                quiz3.forEach(n -> System.out.println(n.toString()));
                // -------------------------------------------------------------------------------

                // 모든 거래자의 이름을 알파벳순으로 정리해서 반환하시오
                List<String> All_traders = transactions.stream()
                                .map(transaction -> transaction.getTrader().getName())
                                .sorted()
                                .distinct()
                                .collect(Collectors.toList());
                System.out.println("All_traders: " + All_traders);

                String quiz4 = transactions.stream()
                                .map(transaction -> transaction.getTrader().getName())
                                .sorted()
                                .distinct()
                                .reduce("", (s, s2) -> s + s2 + " ");
                System.out.println(quiz4);

                List<String> quiz4_1 = transactions.stream()
                                .map(transaction -> transaction.getTrader().getName())
                                .sorted()
                                .distinct()
                                .collect(Collectors.toList());
                quiz4_1.forEach(System.out::println);
                // -------------------------------------------------------------------------------

                // 밀라노에 거래자가 있는가?
                // boolean Milan = Arrays.stream()
                // .anyMatch(m -> transaction.getTrader().getCity("Milan").getName());
                // System.out.println(Milan);

                boolean quiz5 = transactions.stream()
                                .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
                System.out.println(quiz5);

                boolean quiz5_1 = transactions.stream()
                                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
                System.out.println("Milan_trader: " + quiz5_1);
                // -------------------------------------------------------------------------------

                // 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력하시오
                // List<String> ct = transactions.stream()
                // .map(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                // .map(transaction -> transaction.getValue())
                // .collect(Collectors.toList());
                // System.out.println(ct);

                List<Integer> quiz6 = transactions.stream()
                                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                                .map(Transaction::getValue)
                                .collect(Collectors.toList());
                System.out.println(quiz6);

                transactions.stream()
                                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                                .forEach(transaction -> System.out.println(transaction.getValue()));

                // -------------------------------------------------------------------------------

                // 전체 트랜잭션 중 최댓값은 얼마인가?
                int max1 = transactions.stream()
                                .map(Transaction::getValue)
                                .max(Integer::compareTo)
                                .orElse(0);
                System.out.println("Max Transaction Value: " + max1);

                // Optional
                Optional<Integer> quiz7 = Optional.ofNullable(transactions.stream()
                                .map(transaction -> transaction.getValue())
                                .reduce(0, (integer, integer2) -> Integer.max(integer, integer2)));
                System.out.println(quiz7);

                List<Transaction> transactions1 = new ArrayList<>();
                Optional<Integer> quiz7_1 = Optional.ofNullable(transactions1.stream()
                                .map(transaction -> transaction.getValue())
                                .reduce(0, (integer, integer2) -> Integer.max(integer, integer2)));
                System.out.println(quiz7_1);
                // -------------------------------------------------------------------------------
                // 전체 트랜잭션 중 최솟값은 얼마인가?
                int min1 = transactions.stream()
                                .map(Transaction::getValue)
                                .min(Integer::compareTo)
                                .orElse(0);
                System.out.println("Min Transaction Value: " + min1);
                // -------------------------------------------------------------------------------
        }
}
