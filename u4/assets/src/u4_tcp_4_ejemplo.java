public class Worker extends Thread {

    private Socket socketCliente;
    private BufferedReader entrada = null;
    private PrintWriter salida = null;

    ....

    @Override
    public void run() {
        try {
            // Establece canal de entrada
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);

            // Realizamos la comunicación entre servidor y cliente
            // **** ES LO QUE CAMBIA EN CADA EJERCICIO ****

            // Hacemos una recepción de información desde el cliente
            String mensajeRecibido = entrada.readLine();
            System.out.println("<-- Cliente: " + mensajeRecibido);
            
            // Hacemos un envío al cliente
            String mensajeEnviado = "Mensaje enviado desde el servidor al cliente";
            salida.println(mensajeEnviado);
            System.out.println("--> Cliente: " + mensajeEnviado);
        }
        ....
} 