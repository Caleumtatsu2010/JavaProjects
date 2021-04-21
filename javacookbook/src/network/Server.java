
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server 
{
    public static void server()
    {
        ServerSocket serverSocket = null;
        try 
        {
            serverSocket = new ServerSocket(7);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted: " + socket);
            try {
                while(true)
                {
                    DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                    System.out.println("Write message to client: ");
                    Scanner s = new Scanner(System.in);
                    dout.writeUTF(s.nextLine());
                    dout.flush();
                    DataInputStream din = new DataInputStream(socket.getInputStream());
                    System.out.println("Client said: "+din.readUTF());
                }
            } catch (IOException e) 
            {
                System.out.println("Connection error!!");
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    public static void objectServer()
    {
        ServerSocket serverSocket = null;
        try 
        {
            serverSocket = new ServerSocket(1950);
            System.out.println("Server started: " + serverSocket);
            System.out.println("Waiting for a client ...");
            Socket socket = serverSocket.accept();
            System.out.println("Client accepted: " + socket);
            try {
                while(true)
                {
                    ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                    Student object = new Student(123, "john cena", "wrestling");
                    os.writeObject(object);
                }
            } catch (IOException e) 
            {
                System.out.println("Connection error!!");
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException
     {
        server();
        //objectServer();

    }
    
}