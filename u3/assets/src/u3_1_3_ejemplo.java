public class EjemploRunnable implements Runnable {
    public void run() {
    // Código del hilo
    }

    public static void main(String[] args) {
        Thread hilo = new Thread(new EjemploRunnable());
        hilo.start();
    }
}