
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;
public class Client 
{
    public static void client()
    {
        Socket socket = null;
        try
        {
            socket = new Socket("127.0.0.1", 7); // Connect to server
            System.out.println("Connected: " + socket);
            while(true)
            {
                try {
                    DataInputStream din = new DataInputStream(socket.getInputStream());
                    System.out.println("Server said: "+din.readUTF());
                    DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                    System.out.println("Write message to server: ");
                    Scanner s = new Scanner(System.in);
                    dout.writeUTF(s.nextLine());
                    dout.flush();
                } catch (IOException e) 
                {
                    System.out.println("Connection error!!");
                }
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }
    public static void objectClient()
    {
        Socket socket = null;
        try
        {
            socket = new Socket("128.0.0.6", 1950); // Connect to server
            System.out.println("Connected: " + socket);
            while(true)
            {
                try 
                {
                    ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                   Student object = (Student) oi.readObject();
                   object.showDetails();
                } catch (IOException e) 
                {
                    System.out.println("Connection error!!");
                }catch(ClassNotFoundException e)
                {
                    System.out.println("class not found!");
                }
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void UDPClient()
    {
        
    }
    public static void main(String[] args)
    {
        client();
        //objectClient();

    }
}














