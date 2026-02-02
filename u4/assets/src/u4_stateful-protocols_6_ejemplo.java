public class U4A03_SaludoClient {

    private static final String[] messages = {"Hi Server!", "Hi Client!", "Bye Server!", "Error. Unknown or unexpected command"};

    public static void main(String[] args) throws IOException {
        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        // Creamos un socket en el lado cliente, enlazado con un
        // servidor que está en la misma máquina que el cliente
        // y que escucha en el puerto 4444
        try {
            socketCliente = new Socket(args[0], Integer.parseInt(args[1]));

            // Establece canal de entrada
            entrada = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream()));

            // Obtenemos el canal de salida
            salida = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socketCliente.getOutputStream())), true);
        } catch (IOException e) {
            System.err.println("No puede establecer canales de E/S para la conexión");
            System.exit(-1);
        }
        Scanner stdIn = new Scanner(System.in);

        String linea;

        // El programa cliente no analiza los mensajes enviados por el
        // usuario, simplemente los reenvía al servidor hasta que se envía 
        // el mensaje final del protocolo
        do {
            // Leo la entrada del usuario
            linea = stdIn.nextLine();
            // La envia al servidor por el OutputStream
            salida.println(linea);
            // Recibe la respuesta del servidor por el InputStream
            linea = entrada.readLine();
            if (linea == null) {
                // Comprobamos si se ha cerrado el extremo servidor del socket
                // Y damos por concluida la comunicación.
                break;
            } else {
                // Envía a la salida estándar la respuesta del servidor
                System.out.println("SERVIDOR > " + linea);
            }
        } while (true);

        // Libera recursos
        salida.close();
        stdIn.close();
        socketCliente.close();
    }
}