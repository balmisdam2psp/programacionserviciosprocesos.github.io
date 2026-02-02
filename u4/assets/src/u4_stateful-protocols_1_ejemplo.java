public class U4A03_SaludoWorker extends Thread {

    Socket socketCliente;
    BufferedReader entrada;
    PrintWriter salida;

    private final String[] messages = {"Hi Server!", "Hi Client!", "Bye Server!", "Error. Unknown or unexpected command"};

    public enum Estados {
        HI, BYE, END;
    }
    Estados estado;

    U4A03_SaludoWorker(Socket socketCliente) {
        this.socketCliente = socketCliente;
        // Inicializamos el valor del estado al estado inicial
        estado = Estados.HI;
    }

    @Override
    public void run() {
        try {
            // Establece canal de entrada
            entrada = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream()));

            // Obtenemos el canal de salida
            salida = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socketCliente.getOutputStream())), true);

            // Recibe lo que envía el cliente hasta que el mensaje sea
            // END OF TRANSMISSION
            while (estado != Estados.END) {
                // Recibe la solicitud del cliente por el InputStream
                String str = entrada.readLine();

                // Comprobamos si se ha cerrado el extremo cliente del socket
                // Y damos por concluida la comunicación.
                if (str == null) {
                    estado = Estados.END;
                } else {
                    // Mostramos la información recibida por consola
                    System.out.println("CLIENTE > " + str);
                }

                // Controlamos la respuesta en función del mensaje recibido y 
                // el estado actual
                switch (estado) {
                    case HI:
                        if (messages[0].equals(str)) {
                            // Enviamos respuesta al cliente
                            salida.println(messages[1]);
                            // Cambiamos el estado del protocolo
                            estado = Estados.BYE;
                        } else {
                            // Enviamos error al cliente
                            salida.println(messages[3]);
                        }
                        break;
                    case BYE:
                        if (messages[2].equals(str)) {
                            // Cambiamos el estado del protocolo
                            estado = Estados.END;
                        } else {
                            // Enviamos error al cliente
                            salida.println(messages[3]);
                            estado = Estados.HI;
                        }
                        break;
                    case END:
                        // No sería necesario contemplarlo en este caso
                        // Pero sí en otros en los que se tenga que enviar 
                        // algún mensaje antes de salir.
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error de comunicación con el cliente");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        } finally {
            try {
                entrada.close();
                System.out.println("Conexión cerrada: " + socketCliente);
                socketCliente.close();
            } catch (IOException e) {
                System.out.println("Error inesperado cerrando los recursos");
            }
        }
    }
}