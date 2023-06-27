import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServer {
	public static void main(String[] args) throws Exception{
		 ServerSocket server=new ServerSocket(5000);		 
		 System.out.println("Server started"); 
         System.out.println("Waiting for a client ...");          
		 Socket socket = server.accept(); 		
		 System.out.println("Client has joined sharing ");		 
         DataInputStream  readInput   = new DataInputStream(socket.getInputStream());
	     DataOutputStream writeOutput     = new DataOutputStream(socket.getOutputStream());
	     
	     Scanner ip = new Scanner(System.in);	     
	     String lines=readInput.readUTF();	     
	     FileWriter myWriter = new FileWriter("/home/dcl/mytxt.txt");
	     myWriter.write(lines);
	     myWriter.close();	     
	     server.close();
	     socket.close();
	     writeOutput.close();
	     readInput.close();
	     ip.close();		
	}
}
