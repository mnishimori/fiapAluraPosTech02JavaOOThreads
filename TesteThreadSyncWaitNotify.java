class Exemplo {
    private boolean flag = false;

    public synchronized void esperar() throws InterruptedException {
        while (!flag) {
            wait();
            System.out.println("wait... Flag:" + this.flag);
        }
        System.out.println("wait... Flag:" + this.flag);
    }  

    public synchronized void notificar() {
        this.flag = true;
        notifyAll();
        System.out.println("notify all... Flag:" + this.flag);
    }  
}

class ThreadSync extends Thread {
    private Exemplo exemplo;

    public ThreadSync(Exemplo exemplo) {
        this.exemplo = exemplo;
    }

    @Override
    public void run(){
        try {
            this.exemplo.esperar();
            System.out.println("Thread executando após espera...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class TesteThreadSyncWaitNotify {
    public static void main(String[] args) {
        Exemplo exemplo = new Exemplo();
        ThreadSync thread = new ThreadSync(exemplo);
        thread.start();
        try {
            Thread.sleep(2000); // Espera por 2 segundos
            System.out.println("Esperando 2 segundos...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exemplo.notificar();
    }
}
