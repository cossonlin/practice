package learning;

public class MultipleThreadsTest implements Runnable{
    private static volatile Integer acct = 0;

    public static void main(String[] args) {
        MultipleThreadsTest r1 = new MultipleThreadsTest();
        //MultipleThreadsTest2 r2 = new MultipleThreadsTest2();
        Thread one = new Thread(r1);
        Thread two = new Thread(r1);
        one.setName("Increment");
        two.setName("Readonly");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            /*try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
            }*/
            acct = acct + 1;
            System.out.println(Thread.currentThread().getName()
                    + " run: acct = " + acct);
        }
        System.out.println(Thread.currentThread().getName()
                + " final: acct = " + acct);
    }

    static class MultipleThreadsTest2 implements Runnable{
        @Override
        public void run() {
            for (int x = 0; x < 5; x++) {
                /*try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                }*/
                System.out.println(Thread.currentThread().getName()
                        + " run: acct = " + acct);
            }
            System.out.println(Thread.currentThread().getName()
                    + " final: acct = " + acct);
        }
    }
}
