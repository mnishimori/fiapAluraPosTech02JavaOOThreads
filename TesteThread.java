public class TesteThread {
    public static void main(String[] args) {
        MinhaThread minhaThread = new MinhaThread();
        System.out.println("Estado da thread: 1 - " + minhaThread.getState());
        minhaThread.start();
        System.out.println("Estado da thread: 3 - " + minhaThread.getState());
    }
}

class MinhaThread extends Thread {

    @Override
    public void run(){
        System.out.println("Estado da thread: 2 - " + this.getState());
    }
}
