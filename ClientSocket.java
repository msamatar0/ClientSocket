import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author msamatar0
 */
public class ClientSocket{
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        Socket cs = new Socket("cim.saddleback.edu", 2000);
        DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
        DataInputStream dis = new DataInputStream(cs.getInputStream());
        ServerSocket ss = new ServerSocket(5000);
        //int read = 0;
        dos.writeInt(dis.readInt());
        while(true){
            Socket c = ss.accept();
            new Client(c);
        }
    }
}

class Client extends Thread{
        Client(Socket s){
            start();
        }
}
