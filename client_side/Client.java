/**
 * AUTHOR: RONAK PANAHI
 * Date: December 2015
 * Problem: Implementing a Network Time Protocol look-alike. 
 * That’s a protocol that allows one computer to ask another 
 * computer what the time is so that they can keep synchronized 
 * and keep file and email timestamps consistent. 
 * Remote Method Invocation (RMI)
 */
 
package client_side;


import java.rmi.Naming;
import java.rmi.RMISecurityManager;

import server_side.CurrentTime;


@SuppressWarnings("deprecation")
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			// you have to have your policy file ready to use in here
			System.setProperty("java.security.policy","file:pp.policy"); 
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
