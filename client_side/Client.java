package client_side;


import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import server_side.CurrentTime;


@SuppressWarnings("deprecation")
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			System.setProperty("java.security.policy","file:E:\\UIS\\Eclipse\\RMI_Project\\pp.policy");
			System.setSecurityManager(new RMISecurityManager());
			
			
			CurrentTime obj = (CurrentTime) Naming.lookup( "rmi://localhost" + 
			"/GetTime");//object name in registry
			
			System.out.println(obj.getTime()); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 System.err.println("Client exception: " + e.getMessage()); 
			 e.printStackTrace(); 
		}
	}


}
