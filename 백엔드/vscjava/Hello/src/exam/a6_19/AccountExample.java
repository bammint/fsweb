package exam.a6_19;

public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account();

        // balance 값을 설정하고 가져옴
        account.setBalance(10000);
        System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000

        // 음수 값을 설정해도 이전 값이 유지됨
        account.setBalance(-100);
        System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000

        // 백만 원을 초과하는 값을 설정해도 이전 값이 유지됨
        account.setBalance(2000000);
        System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 10000

        // 범위 내의 값을 설정하고 가져옴
        account.setBalance(300000);
        System.out.println("현재 잔고: " + account.getBalance()); // 현재 잔고: 300000
    }
}
