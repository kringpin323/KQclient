package server.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import server.views.mainInterface.mainInterface;

import common.message.*;
/**
 * <p>
 * 将得到的personalInformation传给服务器，直到得到服务器响应
 * <p>
 * <p>
 * final int port = 10001;
	public int changed;   //过程状态
	public personalInfo personnalInformation;
	Socket client;
	public String getQQ;//申请得到的qq号码
	public String password;
 * <p>
 * */


public class applicateClientThread extends Thread
{
	final int port = 10001;
	public int changed;   //过程状态
	public personalInfo personnalInformation;
	Socket client;
	public String getQQ;//申请得到的qq号码
	public String password;
	
	public applicateClientThread(personalInfo personnalInformation)
	{
		super();
		this.personnalInformation = new personalInfo(personnalInformation);
		changed = 0;     //刚刚创建
		start();
	}
	
	public void run()
	{
		try
		{
			try
			{
				this.client = new Socket(mainInterface.ip,port);
				changed = 3; // 等待服务器响应中，3
			}
			catch(Exception e)
			{
				changed = 4;  //有错误 4
				return;
			}
			ObjectOutputStream oout = new ObjectOutputStream(client.getOutputStream());
			oout.writeObject(personnalInformation);
			ObjectInputStream oin = new ObjectInputStream(client.getInputStream());
			testMessage appInfo = (testMessage)oin.readObject(); //从服务器中收到的对象类型是testMessage
			if(appInfo != null)
			{
				getQQ = appInfo.qq;
				changed = 1;   // 服务器响应，成功申请到，大概是成功申请到的意思
			}
			else
			{
				changed = 2;   //服务器响应，但没得到应有的连接
			}
			client.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
}