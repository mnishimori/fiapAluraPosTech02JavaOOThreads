import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MinhaThread implements Runnable {
    private int id;

    public MinhaThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id + " executando");
    }
}

public class TesteThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            System.out.println("Construindo new MinhaThread(" + i + ")");
            executor.execute(new MinhaThread(i));
        }
        executor.shutdown();
    }
}
