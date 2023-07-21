public class main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Account firstClient = new Account(100, "1");
        Account secondClient = new Account(100, "2");

        bank.addAccountToBank(firstClient);
        bank.addAccountToBank(secondClient);

        Thread threadOne =
                new Thread(
                        () -> {
                            bank.transfer(firstClient.getAccNumber(), secondClient.getAccNumber(), 100);
                            bank.transfer(secondClient.getAccNumber(), firstClient.getAccNumber(), 100);
                            System.out.println(Thread.currentThread().getName());
                        });

        Thread threadTwo =
                new Thread(
                        () -> {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            bank.transfer(secondClient.getAccNumber(), firstClient.getAccNumber(), 100);
                            bank.transfer(firstClient.getAccNumber(), secondClient.getAccNumber(), 100);
                            System.out.println(Thread.currentThread().getName());
                        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
    }
}
