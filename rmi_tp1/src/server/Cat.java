package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Cat extends UnicastRemoteObject implements Talkable {
	
	private static final long serialVersionUID = 8526714156601606078L;

	protected Cat() throws RemoteException {
		super();
	}

	@Override
	public String sayHello() throws RemoteException {
		String result = "MiaoMiaoMiao~~~（ΦωΦ）";
		System.out.println("Method sayHello invoked... " + result);
		return result;
	}
}
