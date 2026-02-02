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