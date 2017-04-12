import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author msamatar0
 */
public class RPSServer{
    public static void main(String[] args){
        int port;
        if(args.length == 1)
            port = Integer.parseInt(args[0]);
        
        Scanner in = new Scanner(System.in);
        try{
            ServerSocket server = new ServerSocket(5000);
            
        }
        catch(IOException ex){
            ex.getMessage();
        }
        
    }
}
