// Java example program on thread deadlock
public class DeadLockSample {

    // Simulates global resources shared by multiple threads
    final String R1 = "R1";
    final String R2 = "R2";

    Thread T1 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting T1");

            // Acquired R1
            synchronized (R1) {
                try {
                    // Sleep is added to make deadlock predictable
                    // One second delay ensures that the other thread
                    // acquires lock on R2!
                    Thread.sleep(100);
                } catch (Exception ex) {
                }
                synchronized (R2) {
                    System.out.println("Acquired both!");
                }
            }

            // If we reach here, no deadlock!
            System.out.println("Completed T1");
        }
    });

    Thread T2 = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Starting T2");
            synchronized (R2) {
                try {
                    // Sleep is added to make deadlock predictable
                    // One second delay ensures that the other thread
                    // acquires lock on R1!
                    Thread.sleep(100);
                } catch (Exception ex) {
                }
                synchronized (R1) {
                    System.out.println("Acquired both!");
                }
            }
            // If we reach here, no deadlock!
            System.out.println("Completed T2");
        }
    });

    // Java example program on thread deadlock
    public static void main(String[] args) {
        DeadLockSample ds = new DeadLockSample();
        ds.T1.start();
        ds.T2.start();
    }
}