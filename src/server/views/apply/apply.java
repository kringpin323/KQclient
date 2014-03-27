package server.views.apply;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.event.*;

import server.views.login.*;

import server.model.applicateClientThread;

import common.message.personalInfo;

/**
 * 申请界面
 * 
 * */

public class apply extends JFrame{
	class judgeThread extends Thread
	{
		int changed =0;//未开始状态
		applicateClientThread t;
		
		public judgeThread(applicateClientThread t)
		{
			this.t = t;
		}
		
		public void run()
		{
			try
			{
				Thread.sleep();
			}
		}
	}
}
