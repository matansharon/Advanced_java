import java.net.*;
import java.io.*;
/**
 * Write a description of class EchoThread here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EchoThread extends Thread
{
    private Socket socket=null;
    private String name;
    PrintWriter out;
    BufferedReader in;
    public EchoThread(Socket s,String n)
    {
        this.socket=s;
        name=n;
        try
        {
            out=new PrintWriter(socket.getOutputStream(),true);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch(IOException e)
        {
            System.out.println("couldn't open IO on connection");
        }
    }

    public void run()
    {
        String input;
        try
        {
            while((input=in.readLine()) !=null)
            {
                out.println(input);
            }
            out.close();
            in.close();
            socket.close();
        }
        catch(IOException e)
        {
            System.out.println("couldn't read from connection"); 
        }
    }
}

