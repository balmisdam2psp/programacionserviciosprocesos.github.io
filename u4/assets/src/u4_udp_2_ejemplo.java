public class BasicUDP_Server {

    public static void main(String[] argv) throws Exception {

        // Buffer para recibir el datagrama
        byte[] bufer = new byte[1024];

        // El Socket del servidor se asocia a un puerto para que los clientes
        // puedan enviar peticiones.
        DatagramSocket socket = new DatagramSocket(12345);

        // Se espera la llegada de un DATAGRAMA
        // Al igual que con TCP, esta llamada a receive es bloqueante
        // y es la que tiene que marcar la sincronización entre lecturas y 
        // escrituras de las app cliente / servidor
        System.out.println("Esperando Datagrama ................");
        // Se crea el objeto que almacenará el mensaje enviado por el cliente
        DatagramPacket datagramaRecibido = new DatagramPacket(bufer, bufer.length);
        // Se espera el mensaje y se le pasa el datagrama para que lo almacene ahí
        socket.receive(datagramaRecibido);
        String mensajeRecibido = new String(datagramaRecibido.getData());

        //Información recibida
        System.out.println("Número de Bytes recibidos: " + datagramaRecibido.getLength());
        System.out.println("Contenido del Paquete    : " + mensajeRecibido.trim());

        System.out.println("Puerto origen del mensaje: " + datagramaRecibido.getPort());

        System.out.println("IP de origen             : " + datagramaRecibido.getAddress().getHostAddress());
        System.out.println("Puerto destino del mensaje:" + socket.getLocalPort());

        // Liberamos los recursos
        socket.close(); 
    }
}