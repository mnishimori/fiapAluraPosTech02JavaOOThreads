class Contador {
    private int contador = 0;

    public int getContador() {
        return contador;
    }

    public synchronized void incrementar() {
        this.contador++;
        System.out.println("Incrementando... Contador: " + this.contador);
    }  
}

class ThreadSync extends Thread {
    private Contador contador;

    public ThreadSync(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run(){
        this.contador.incrementar();
    }
}

public class TesteThreadSync {
    public static void main(String[] args) {
        Contador contador =  new Contador();
        ThreadSync threadSync1 = new ThreadSync(contador);
        ThreadSync threadSync2 = new ThreadSync(contador);

        threadSync1.start();
        threadSync2.start();

        try {
            threadSync1.join();
            threadSync2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Valor final: " + contador.getContador());
    }
}
