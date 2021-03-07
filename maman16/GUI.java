import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*; 
import java.io.*;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI extends JFrame 
{
    JFrame serverFrame,clientFrame;
    JButton cmdNewClient,cmdExit;
    JPanel panel;
    private MultiServer server;
    public GUI()throws IOException
    {

        serverFrame=new JFrame("Server");
        serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverFrame.setSize(500, 500);
        panel=new JPanel();
        panel.setLayout(null);
        cmdExit=new JButton("exit");
        //cmdExit.addActionListener(new exitListener());
        //cmdExit.setBounds(50,50,150,50);
        //panel.add(cmdExit);
        cmdNewClient=new JButton("new client");
        cmdNewClient.addActionListener(new newClientListener());
        cmdNewClient.setBounds(50,50,150,50);
        panel.add(cmdNewClient);
        serverFrame.add(panel);
        serverFrame.setVisible(true);
        server=new MultiServer();
    }

    private class exitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

        }

    }
    private class newClientListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            
        }

    }
}

