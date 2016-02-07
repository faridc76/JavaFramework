package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Dog extends UnicastRemoteObject implements Talkable {
	
	private static final long serialVersionUID = -2785856556383989812L;

	protected Dog() throws RemoteException {
		super();
	}

	@Override
	public String sayHello() throws RemoteException {
		String result = "WoWoWo!!!ฅ^•ﻌ•^ฅ";
		System.out.println("Method sayHello invoked... " + result);
		return result;
	}
}
