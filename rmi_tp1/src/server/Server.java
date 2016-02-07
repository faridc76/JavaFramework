package server;

import java.rmi.Naming;

public class Server {

	private static final String HOST = "localhost";
	
	public static void main(String[] args) {
		try {
			System.out.println("Creating server object ...");
			Talkable dog = new Dog();
			System.out.println("Reference in RMI Registry ...");
			Naming.rebind("rmi://" + HOST + "/Talkable", dog);
			System.out.println("Waiting invocations - CTRL-C to stop");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
