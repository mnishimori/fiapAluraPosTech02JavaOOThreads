class Contador {
    private int contador = 0;

    public int getContador() {
        return contador;
    }

    public void incrementar() {
        this.contador++;
        System.out.println("Incrementando... Contador: " + this.contador);
    }  

    public void decrementar() {
        this.contador--;
        System.out.println("Decrementando... Contador: " + this.contador);
    }  
}

class ThreadSync extends Thread {
    private Contador contador;

    public ThreadSync(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            this.contador.incrementar();
        }
    }
}

public class TesteThreadConcorrencia {
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
