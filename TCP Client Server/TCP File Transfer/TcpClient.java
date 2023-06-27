import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
	public static void main(String arg[]) throws Exception {				
		System.out.println("Attempting to connect...");		
		Socket socket=new Socket("localhost",5000);
		DataInputStream  readInput   = new DataInputStream(socket.getInputStream());
	    DataOutputStream writeOutput     = new DataOutputStream(socket.getOutputStream());
	    Scanner ip=new Scanner(System.in);	    
	    System.out.println("Start transfering");	    
	    String transfer="";	  
	    BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"/home/dcl/filetcp/mytxt.txt"));
			String line = reader.readLine();
			while (line != null) {
				transfer=transfer+line+"\n";
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
   	    writeOutput.writeUTF(transfer);	    
	    System.out.println("Transfer done!\nClosing connection"); 	     
	     socket.close(); 
	     readInput.close();
	     writeOutput.close();
	     ip.close();
	     
	}
}

