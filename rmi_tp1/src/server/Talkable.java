package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Talkable extends Remote {
	public String sayHello() throws RemoteException;
}
