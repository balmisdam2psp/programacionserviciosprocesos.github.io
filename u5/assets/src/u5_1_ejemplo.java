// URLConnectionExample
public static void main(String[] args) throws MalformedURLException, IOException{

    // Creating an object of URL class

    // Custom input URL is passed as an argument
    URL u = new URL("www.google.com");

    // Creating an object of URLConnection class to
    // communicate between application and URL
    URLConnection urlconnect = u.openConnection();

    // Creating an object of InputStream class
    // for our application streams to be read
    InputStream stream
        = urlconnect.getInputStream();

    BufferedReader in =  
        new BufferedReader(
            new InputStreamReader(stream));
    // Till the time URL is being read
    String line;
    while ((line = in.readLine()) != null) {

        // Continue printing the stream
        System.out.println(line);
    }
}