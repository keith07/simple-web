package edu.keith.demo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject implements IHello {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected HelloImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String helloWorld() throws RemoteException {
		return "Hello World!";
	}

}
