import java.net.*;
import java.io.*;
import javax.swing.*;
/**
 * Write a description of class MultiServer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MultiServer
{
    ServerSocket ss=null;
    boolean listening=true;
    public MultiServer() throws IOException
    {

        try
        {
            ss=new ServerSocket(7777);
        }
        catch(IOException e)
        {
            System.out.println("couldn't open port: 7777");
            System.exit(1);
        }
        System.out.println("server ready");
        Socket socket=null;
        while(listening)
        {
            try
            {
                socket=ss.accept();
                String name=JOptionPane.showInputDialog("enter your name");
                new EchoThread(socket,name).start();
                System.out.println("connection succes");
            }
            catch(IOException e)
            {
                System.out.println("Accept failed");
                System.exit(1);
            }

        }
        ss.close();
    }

    public void setListening(boolean l)
    {
        this.listening=l;
    }

    public ServerSocket getServerSocket()
    {
        return this.ss;
    }
}
