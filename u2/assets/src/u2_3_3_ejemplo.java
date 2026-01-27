import java.io.*;
public class Ejercicio2 {
    public static void main(String[] args) {
        String comando = "notepad";
        ProcessBuilder pbuilder = new ProcessBuilder (comando);
        Process p = null;
        try {
            p = pbuilder.start();
            // 1- Procedemos a leer lo que devuelve el proceso hijo
            InputStream is = p.getInputStream();
            // 2- Lo convertimos en un InputStreamReader
            // De esta forma podemos leer caracteres en vez de bytes
            // El InputStreamReader nos permite gestionar diferentes codificaciones
            InputStreamReader isr = new InputStreamReader(is);
            // 2- Para mejorar el rendimiento hacemos un wrapper sobre un BufferedReader
            // De esta forma podemos leer enteros, cadenas o incluso líneas.
            BufferedReader br = new BufferedReader(isr);

            // A Continuación leemos todo como una cadena, línea a línea
            String linea;
            while ((linea = br.readLine()) != null) 
                System.out.println(linea);
        } catch (Exception e) {
            System.out.println("Error en: "+comando);
            e.printStackTrace();
        } finally {
            // Para finalizar, cerramos los recursos abiertos
            br.close();
            isr.close();
            is.close();
        }    
    }
}