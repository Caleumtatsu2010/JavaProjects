import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTest
{
    public static void main(String[] args) throws UnknownHostException
    {
        InetAddress adr=null;
        System.out.println(adr.getLocalHost());
        System.out.println(adr.getByName("www.microsoft.com"));
        
        
    }
}