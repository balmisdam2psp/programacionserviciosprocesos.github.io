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