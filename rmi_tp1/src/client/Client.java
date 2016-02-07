package client;


import java.rmi.Naming;

import server.Talkable;

public class Client {

	private static final String HOST = "10.20.36.56";
	
	public static void main(String[] args) {
		try {
			System.out.println("Searching talkable object in server...");
			Talkable hello = (Talkable)
					Naming.lookup("rmi://" + HOST + "/Talkable");
			System.out.println("Invocation of method sayHello ...");
			String result = hello.sayHello();
			System.out.println("Showing result:");
			System.out.println(result);
			System.exit(0);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
