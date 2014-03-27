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
 * ���õ���personalInformation������������ֱ���õ���������Ӧ
 * <p>
 * <p>
 * final int port = 10001;
	public int changed;   //����״̬
	public personalInfo personnalInformation;
	Socket client;
	public String getQQ;//����õ���qq����
	public String password;
 * <p>
 * */


public class applicateClientThread extends Thread
{
	final int port = 10001;
	public int changed;   //����״̬
	public personalInfo personnalInformation;
	Socket client;
	public String getQQ;//����õ���qq����
	public String password;
	
	public applicateClientThread(personalInfo personnalInformation)
	{
		super();
		this.personnalInformation = new personalInfo(personnalInformation);
		changed = 0;     //�ոմ���
		start();
	}
	
	public void run()
	{
		try
		{
			try
			{
				this.client = new Socket(mainInterface.ip,port);
				changed = 3; // �ȴ���������Ӧ�У�3
			}
			catch(Exception e)
			{
				changed = 4;  //�д��� 4
				return;
			}
			ObjectOutputStream oout = new ObjectOutputStream(client.getOutputStream());
			oout.writeObject(personnalInformation);
			ObjectInputStream oin = new ObjectInputStream(client.getInputStream());
			testMessage appInfo = (testMessage)oin.readObject(); //�ӷ��������յ��Ķ���������testMessage
			if(appInfo != null)
			{
				getQQ = appInfo.qq;
				changed = 1;   // ��������Ӧ���ɹ����뵽������ǳɹ����뵽����˼
			}
			else
			{
				changed = 2;   //��������Ӧ����û�õ�Ӧ�е�����
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