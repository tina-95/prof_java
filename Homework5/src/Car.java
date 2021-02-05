import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
private CountDownLatch cdlStart;
private CountDownLatch cdlFinish;
private static CyclicBarrier barrier;
private static final AtomicInteger racePosition = new AtomicInteger();

    {
        cdlStart = MainClass.cdlStart;
        cdlFinish = MainClass.cdlFinish;
        barrier = MainClass.barrier;
    }


    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
    
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            cdlStart.countDown();
            System.out.println(this.name + " готов");
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        System.out.println(this.name+ " занял " + racePosition.incrementAndGet()+" место ");
        cdlFinish.countDown();
    }
}
