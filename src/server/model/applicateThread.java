package server.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import common.message.*;

public class applicateThread extends Thread
{
	final int port = 10001;
	public int changed;
	public personalInfo personnalInformation;
	Socket client;
	public String getQQ;//ÉêÇëµÃµ½µÄqqºÅÂë
	public String password;
	
	public applicateClientThread(personalInfo personnalInformation)
	{
		super();
		this.personnalInformation = new personalInfo(personnalInformation);
		changed = 0;
		start();
	}
	
	
}
