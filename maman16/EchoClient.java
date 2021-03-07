import java.net.*; 
import java.io.*;
public class EchoClient {
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;         
    String host="localhost";
    String name;
    public EchoClient()  throws IOException 
    {
        
        try {             
            echoSocket = new Socket(host, 7777);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } 
        catch (UnknownHostException e) 
        {             
            System.out.println("Don't know about host: "+host);
            System.exit(1);
        } catch (IOException e) 
        {             
            System.out.println("Couldn't get I/O for the connection to: "+host);
            System.exit(1);
        }             
        System.out.println("after connections");
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while ((userInput = stdIn.readLine()) != null)
        {      
            out.println(userInput); 
            System.out.println("from server: " + in.readLine());
        }  
        out.close();
        in.close(); 
        stdIn.close();
        echoSocket.close(); 
    }
} 

