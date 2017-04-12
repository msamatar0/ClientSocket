import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author msamatar0
 */
public class ClientSocket{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 0;
        try(
            Socket cs = new Socket("cim.saddleback.edu", 5000);
            DataInputStream cin = new DataInputStream(cs.getInputStream());
            DataOutputStream cout = new DataOutputStream(cs.getOutputStream());){
            while(n != -1){
                n = in.nextInt();
                cout.writeInt(n);
                if(n != -1)
                    System.out.println(cin.readInt());
            }
        }
        catch(IOException ex){
            System.out.println("ex");
            ex.getMessage();
        }
        
    }
}
