Process p = pbuilder.start();
BufferedReader processError = 
    new BufferedReader(new InputStreamReader(p.getErrorStream()));
// En este ejemplo, por ver una forma diferente de recoger la información,
// en vez de leer todas las líneas que llegan, recogemos la primera línea
// y suponemos que nos han enviado un entero.    
int value = Integer.parseInt(processError.readLine());
processError.close();