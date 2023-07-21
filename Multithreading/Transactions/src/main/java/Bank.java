import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();
    private final Object lock = new Object();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }
    public void addAccountToBank(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        boolean check = false;
        if (isEnoughMoney(fromAccount.getMoney(), amount)) {
            long verificationLimit = 500_000;
            if (amount > verificationLimit) {
                try {
                    check = isFraud(fromAccountNum, toAccountNum, amount);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }

            synchronized (lock) {
                if (check) {
                    fromAccount.blockedAccount();
                    toAccount.blockedAccount();
                } else {
                    toAccount.setMoney(toAccount.getMoney() + amount);
                    fromAccount.setMoney(fromAccount.getMoney() - amount);
                }
            }
        }
    }
    public synchronized void getAccounts() {
        System.out.println(accounts.keySet());
    }

    public boolean isEnoughMoney(long fromAccountMoney, long amount) {
        return fromAccountMoney >= amount;
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sumMoney = 0;
        for (Map.Entry<String, Account> item : accounts.entrySet()) {
            sumMoney += item.getValue().getMoney();
        }
        System.out.println("Общая сумма на всех счетах: " + sumMoney + " руб.");
        return sumMoney;
    }
}