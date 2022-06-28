
class Data {
    public boolean transfer = true;
    public String data = "";

    public synchronized void send(String input) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.transfer = false;
        this.data = input;
        notifyAll();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.transfer = true;
        notifyAll();
        return this.data;
    }
}

class Sender implements Runnable {
    Data data;

    Sender(Data d) {
        this.data = d;
    }

    @Override
    public void run() {
        String[] inputData = new String[]{"one", "two", "three", "four", "end"};
        for (String inputDatum : inputData) {
            data.send(inputDatum);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("done with sending");
    }
}

class Receiver implements Runnable {
    Data data;

    Receiver(Data d) {
        this.data = d;
    }

    @Override
    public void run() {
        String s = data.receive();
        while (!s.equals("end")) {
            System.out.println(s);
            s = data.receive();
        }

        System.out.println("end of communication");
    }
}

public class SendReceive {
    public static void main(String[] args) {
        Data d = new Data();
        Thread t = new Thread(new Sender(d));
        t.start();
        Thread t2 = new Thread(new Receiver(d));
        t2.start();
    }
}
