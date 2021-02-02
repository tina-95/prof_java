public class task4 {
    static volatile char letter = 'A';
    public static void main(String[] args)  {

        Object sync = new Object();
        int REPEAT = 5;

        Thread a = new Thread(() -> {
            synchronized (sync){
                try {
                    for (int i = 0;i<REPEAT;i++) {
                        while (letter != 'A') {
                            sync.wait();}

                                System.out.print("A");
                                letter = 'B';

                                sync.notifyAll();

                            }

                        } catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }

            });
        Thread b = new Thread(() -> {
            synchronized (sync){
                try {
                    for (int i = 0;i<REPEAT;i++) {
                        while (letter != 'B') {
                            sync.wait();}

                        System.out.print("B");
                        letter = 'C';

                        sync.notifyAll();

                    }

                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread c = new Thread(() -> {
            synchronized (sync) {
                try {
                    for (int i = 0; i < REPEAT; i++) {
                        while (letter != 'C') {
                            sync.wait();
                        }

                        System.out.print("C");
                        letter = 'A';

                        sync.notifyAll();

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        a.start();

        b.start();

        c.start();




    }
}
