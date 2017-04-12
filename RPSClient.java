import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author msamatar0
 */
public class RPSClient{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try(Socket client = new Socket("cim.saddleback.edu", 5000);
            PrintWriter out = new PrintWriter(client.getOutputStream());
            Scanner sc = new Scanner(client.getInputStream());){
            System.out.println("Enter your Name: ");
            String userInput = in.next();
            out.println(userInput);
            out.flush();
            System.out.println("Enter rock paper scssors quit: ");
            while(true){
                userInput = in.next();
                out.println(userInput);
                out.flush();
                if(userInput.equals("quit"))
                    break;
                String response = sc.nextLine();
                if(response.equals("quit")){
                    System.out.println(response);
                    break;
                }
                System.out.println(response);                
            }
            for(int i = 0; i < 3; ++i)
                System.out.println(sc.nextLine());
        }
        catch(IOException e){
                System.out.println("Connection Error");
        }
    }
}
