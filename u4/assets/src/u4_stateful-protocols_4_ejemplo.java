// Comprobamos si se ha cerrado el extremo cliente del socket
// Y damos por concluida la comunicación.
if (str == null) {
    estado = Estados.END;
} else {
    // Mostramos la información recibida por consola
    System.out.println("CLIENTE > " + str);
}