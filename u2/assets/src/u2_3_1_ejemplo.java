Process p = pbuilder.start();
BufferedReader processOutput = 
    new BufferedReader(new InputStreamReader(p.getInputStream()));

String linea;    
while ((linea = processOutput.readLine()) != null) {
    System.out.println("> " + linea);        
}            
processOutput.close();   