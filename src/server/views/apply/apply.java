package server.views.apply;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.event.*;

import server.views.login.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.event.*;

import server.model.applicateClientThread;

import common.message.personalInfo;

/**
 * �������
 * 
 * */

public class apply extends JFrame{
	class judgeThread extends Thread
	{
		int changed =0;//δ��ʼ״̬
		applicateClientThread t;

		public judgeThread(applicateClientThread t)
		{
			this.t = t;
		}

		public void run()
		{
			try
			{
				Thread.sleep(120000);  //˯��120�룬�ν⣿
				//�ȴ� 120 ��󣬻����޷��ͷ�������ͨ���޷��õ��������Ļظ�
				if(t.changed == 0) // Ϊ��ʼ״̬ �ոմ���״̬
				{
					t.stop();  //ֹͣ�̣߳�����ȫ����
					changed = 1;   //  ���changed������judgeThread��changed������t��applicateClientThread����changed
								// ��������1 �����ɹ���
					this.stop();  //���apply�����߳�ֹͣ
				}
			}
			catch(InterruptedException e){}
		}
	}

	private JPanel  jp1,jp2,jp3,card;
	private JLabel  jl_star;
	private JLabel			jl_nickname, jl_birthday, jl_sex, jl_password1, jl_password2, jl_address, jl_year, jl_month, jl_day, jl_1, jl_accept, jl_wait, jl3_1, jl3_2, jl3_3, jl3_4, jl3_5, jl3_6,
	jl3_7, jl3_8;
	private JTextField		jt_nickname;
	private JPasswordField	jt_password1, jt_password2;
	private JRadioButton	jr_man, jr_woman;
	private JComboBox		jc_year, jc_month, jc_day, jc_country, jc_province, jc_city;
	private JButton			jb_sure, jb_login;
	private ButtonGroup		radiogroup;
	private String			item_country[]		= { "�й�", "����", "����", "����", "�ձ�", "���ɱ�", "Խ��", "����", "����կ", "�Ĵ�����", "̩��", "�Ϸ�", "Ӣ��", "����", "�¹�", "������", "������", "�����", "����˹", "����͢", "����", "ī����" };
	private String			item_province[]		= { "ɽ��", "����", "�ӱ�", "ɽ��", "���ɹ�", "����", "����", "������", "�Ϻ�", "����", "�㽭", "����", "����", "����", "���", "����", "����", "����", "�㶫", "����", "����", "����", "�Ĵ�", "����",
			"����", "����", "����", "����", "�ຣ", "����", "�½�", "���", "����", "̨��" };
	private String			item_province1[]	= { "��ɼ�", "��˹��", "ŦԼ", "֥�Ӹ�", "��ʢ��", "����ͼ", "�ɽ�ɽ", "�ѳ�", "��������" };
	private String			item_city[]			= { "�Ͳ�", "�ൺ", "����", "��ׯ", "��Ӫ", "��̨", "Ϋ��", "����", "̩��", "����", "����", "����", "����", "����", "�ĳ�", "����", "����" };
	private String			item_city1[]		= { "������", "������", "������", "˳����", "ʯ��ɽ��", "������", "��̨��" };
	private JCheckBox		jc; // ����Ǻν⣿ checkBox?
	private CardLayout		cardl;  //  ��Ƭ����
	private int				year, month, day;
	private String			QQ					= "", nickname = "", password = "", sex = "", country = "", province = "", city = "";

	public apply()
	{
		Image image = Toolkit.getDefaultToolkit().getImage("pic//headpic.jpg");
		setIconImage(image);
		Container container = getContentPane();
		// ���ñ���ͼƬ
		JLabel jl_down = new JLabel();
		// �ѱ���ͼƬ��ʾ��һ����ǩ����
		jl_down.setIcon(new ImageIcon("pic//background//2.jpg"));
		jl_down.setSize(700, 500);
		// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
		JPanel c = (JPanel) container;
		c.add(jl_down);
		c.setOpaque(false);
		c.setLayout(null);
		cardl = new CardLayout();
		card = new JPanel();
		card.setBounds(0, 0, 700, 500);
		card.setOpaque(false);
		card.setLayout(cardl);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		card.add("ע��", jp1);
		card.add("�ȴ�", jp2);
		card.add("�ɹ�", jp3);
		c.add(card);

		// ���1
		jp1.setLayout(null);
		jp1.setOpaque(false);
		int l = 50;
		for (int i = 1; i <= 6; i++)
		{
			jl_star = new JLabel();
			jl_star.setText("*");
			jl_star.setForeground(Color.red);
			jl_star.setBounds(75, l * i, 10, 20);
			jl_star.setFont(new Font("����", Font.PLAIN, 18));
			jp1.add(jl_star);
		}
		// �ǳ�
		jl_nickname = new JLabel();
		jl_nickname.setText("�ǳ�:");
		jl_nickname.setBounds(85, 50, 90, 20);
		jl_nickname.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jl_nickname);
		// �ǳƿ�
		jt_nickname = new JTextField();
		jt_nickname.setBounds(175, 50, 150, 20);
		jt_nickname.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jt_nickname);
		// ����
		jl_birthday = new JLabel();
		jl_birthday.setText("���գ�");
		jl_birthday.setBounds(85, 100, 90, 20);
		jl_birthday.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jl_birthday);
		// ����--��
		jc_year = new JComboBox();
		for (int i = 1892; i <= 2012; i++)
		{
			jc_year.addItem(String.valueOf(i));
		}
		jc_year.setBounds(175, 100, 70, 20);
		jc_year.setFont(new Font("����", Font.PLAIN, 15));
		jp1.add(jc_year);
		jl_year = new JLabel();
		jl_year.setText("��");
		jl_year.setBounds(250, 100, 20, 20);
		jl_year.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jl_year);
		// ����--��
		jc_month = new JComboBox();
		for (int i = 1; i <= 12; i++)
		{
			jc_month.addItem(String.valueOf(i));
		}
		jc_month.setBounds(270, 100, 50, 20);
		jc_month.setFont(new Font("����", Font.PLAIN, 15));
		jp1.add(jc_month);
		jl_month = new JLabel();
		jl_month.setText("��");
		jl_month.setBounds(320, 100, 20, 20);
		jl_month.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jl_month);
		// ����--��
		jc_day = new JComboBox();
		for (int i = 1; i <= 31; i++)
		{
			jc_day.addItem(String.valueOf(i));
		}
		jc_day.setBounds(340, 100, 50, 20);
		jc_day.setFont(new Font("����", Font.PLAIN, 15));
		jp1.add(jc_day);
		jl_day = new JLabel();
		jl_day.setText("��");
		jl_day.setBounds(390, 100, 20, 20);
		jl_day.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jl_day);
		// �Ա�
		jl_sex = new JLabel();
		jl_sex.setText("�Ա�");
		jl_sex.setBounds(85, 150, 90, 20);
		jl_sex.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jl_sex);
		// �Ա�--��Ů
		radiogroup = new ButtonGroup();
		jr_man = new JRadioButton("��");
		jr_man.setSelected(true);
		jr_man.setBounds(175, 150, 40, 20);
		jr_woman = new JRadioButton("Ů");
		jr_woman.setBounds(215, 150, 40, 20);
		radiogroup.add(jr_man);
		radiogroup.add(jr_woman);
		jp1.add(jr_man);
		jp1.add(jr_woman);
		// ����
		jl_password1 = new JLabel();
		jl_password1.setText("���룺");
		jl_password1.setBounds(85, 200, 90, 20);
		jl_password1.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jl_password1);
		// �����
		jt_password1 = new JPasswordField();
		jt_password1.setBounds(175, 200, 150, 20);
		jt_password1.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jt_password1);
		// ����Ҫ��
		jl_1 = new JLabel();
		jl_1.setText("( 6-20���ַ���ɣ����ִ�Сд )");
		jl_1.setBounds(330, 200, 600, 20);
		jl_1.setForeground(Color.red);
		jl_1.setFont(new Font("����", Font.PLAIN, 12));
		jp1.add(jl_1);
		// ȷ������
		jl_password2 = new JLabel();
		jl_password2.setText("ȷ�����룺");
		jl_password2.setBounds(85, 250, 90, 20);
		jl_password2.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jl_password2);
		// ȷ�������
		jt_password2 = new JPasswordField();
		jt_password2.setBounds(175, 250, 150, 20);
		jt_password2.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jt_password2);
		// ��ַ
		jl_address = new JLabel();
		jl_address.setText("��ַ��");
		jl_address.setBounds(85, 300, 90, 20);
		jl_address.setFont(new Font("����", Font.PLAIN, 18));
		jp1.add(jl_address);
		// ��ַ--����
		jc_country = new JComboBox();
		for (int i = 0; i < 22; i++)
		{
			jc_country.addItem(item_country[i]);
		}
		jc_country.setBounds(175, 300, 70, 20);
		jc_country.setFont(new Font("����", Font.PLAIN, 13));
		jp1.add(jc_country);
		// ��ַ--ʡ��
		jc_province = new JComboBox();
		for (int i = 0; i < 34; i++)
		{
			jc_province.addItem(item_province[i]);
		}
		jc_province.setBounds(250, 300, 70, 20);
		jc_province.setFont(new Font("����", Font.PLAIN, 13));
		jp1.add(jc_province);
		// ��ַ--����
		jc_city = new JComboBox();
		for (int i = 0; i < 17; i++)
		{
			jc_city.addItem(item_city[i]);
		}
		jc_city.setBounds(325, 300, 70, 20);
		jc_city.setFont(new Font("����", Font.PLAIN, 13));
		jp1.add(jc_city);
		// ͬ����ط�������
		jc = new JCheckBox();
		jc.setBounds(180, 350, 20, 20);
		jc.setSelected(true);
		jp1.add(jc);
		jl_accept = new JLabel();
		jl_accept.setBounds(200, 350, 200, 20);
		jl_accept.setText("�����Ķ���ͬ����ط�������");
		jl_accept.setFont(new Font("����", Font.PLAIN, 14));
		jp1.add(jl_accept);
		// ע��
		jb_sure = new JButton();
		jb_sure.setIcon(new ImageIcon("pic//zhuce.gif"));
		jb_sure.setBounds(180, 380, 69, 22);
		jp1.add(jb_sure);
		
		//���2
		jp2.setLayout(null);
		jp2.setOpaque(false);
		jl_wait= new JLabel();
		jl_wait.setText("����������........");
		jl_wait.setFont(new Font("����", Font.PLAIN, 16));
		jl_wait.setBounds(200, 100, 300, 20);
		jp2.add(jl_wait);
		
		// ���3
		jp3.setLayout(null);
		jp3.setOpaque(false);
		jl3_1 = new JLabel();
		jl3_1.setIcon(new ImageIcon("pic//apply//success.gif"));
		jl3_1.setBounds(100, 50, 60, 50);
		jp3.add(jl3_1);
		jl3_2 = new JLabel();
		jl3_2.setText("����ɹ�");
		jl3_2.setBounds(160, 50, 100, 20);
		jl3_2.setFont(new Font("����", Font.PLAIN, 20));
		jp3.add(jl3_2);
		jl3_3 = new JLabel();
		jl3_3.setText("���ú����ǣ�");
		jl3_3.setBounds(160, 80, 200, 20);
		jl3_3.setFont(new Font("����", Font.PLAIN, 20));
		jp3.add(jl3_3);

		// QQ��
		jl3_4 = new JLabel();
		jl3_4.setBounds(300, 80, 200, 20);
		jl3_4.setFont(new Font("����", Font.PLAIN, 25));
		jl3_4.setForeground(Color.RED);
		jp3.add(jl3_4);
		// ����
		jl3_5 = new JLabel();
		jl3_5.setBounds(160, 110, 140, 20);
		jl3_5.setFont(new Font("����", Font.PLAIN, 20));
		jp3.add(jl3_5);
		jl3_6 = new JLabel();
		jl3_6.setBounds(300, 110, 100, 20);
		jl3_6.setFont(new Font("����", Font.PLAIN, 20));
		jl3_6.setForeground(Color.RED);
		jp3.add(jl3_6);
		jl3_7 = new JLabel();
		jl3_7.setBounds(380, 110, 100, 20);
		jl3_7.setFont(new Font("����", Font.PLAIN, 20));
		jp3.add(jl3_7);

		// ��½QQ
		jb_login = new JButton();
		jb_login.setBounds(160, 170, 180, 39);
		jb_login.setIcon(new ImageIcon("pic//apply//login.jpg"));
		jp3.add(jb_login);
		// ���
		jl3_8 = new JLabel();
		jl3_8.setBounds(160, 230, 290, 220);
		jl3_8.setIcon(new ImageIcon("pic//apply//ad.jpg"));
		jp3.add(jl3_8);

		//��Ӧ
		//ע�ᰴť
		jb_sure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				jb_sureactionPerformed(e);
			}
		});
		jb_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				jb_loginactionPerformed(e);
			}
		});
		jc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				jcitemStateChanged(e);
			}
		});
		jc_country.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				jc_countryItemStateChanged(e);
			}
		});
		// ʡ��ѡ��
		jc_province.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				jc_provinceItemStateChanged(e);
			}
		});
		
		getLayeredPane().setLayout(null);
		// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
		getLayeredPane().add(jl_down, new Integer(Integer.MIN_VALUE));
		Toolkit tk = this.getToolkit();// �õ����ڹ�����
		Dimension dm = tk.getScreenSize();
		setLocation((int) (dm.getWidth() / 5.5), (int) (dm.getHeight() / 5.5));
		setResizable(false);
		setSize(700, 500);
		setVisible(true);
		setTitle("����QQ�˺�");		
	}
	
	// ����ѡ��
	private void jc_countryItemStateChanged(ItemEvent e)
	{
		for (int i = 0; i < 22; i++)
		{
			if (e.getItem() == "�й�")
			{
				jc_province.setEnabled(true);
				jc_city.setEnabled(true);
				jc_province.removeAllItems();
				for (int j = 0; j < 34; j++)
				{
					jc_province.addItem(item_province[j]);
				}
			}
			else if (e.getItem() == "����")
			{
				jc_province.setEnabled(true);
				jc_city.setEnabled(false);
				jc_province.removeAllItems();
				for (int j = 0; j < 9; j++)
				{
					jc_province.addItem(item_province1[j]);
				}
			}
			else
			{
				jc_province.setEnabled(false);
				jc_city.setEnabled(false);
			}
		}
	}

	// ʡ��ѡ��
	private void jc_provinceItemStateChanged(ItemEvent e)
	{
		for (int i = 0; i < 34; i++)
		{
			if (e.getItem() == "ɽ��")
			{
				jc_city.setEnabled(true);
				jc_city.removeAllItems();
				for (int j = 0; j < 17; j++)
				{
					jc_city.addItem(item_city[j]);
				}
			}
			else if (e.getItem() == "����")
			{
				jc_city.setEnabled(true);
				jc_city.removeAllItems();
				for (int j = 0; j < 7; j++)
				{
					jc_city.addItem(item_city1[j]);
				}
			}
			else
			{
				jc_city.setEnabled(false);
			}
		}
	}
	
	//���ˣ������Ѿ�д�á�����
	
	private void jb_loginactionPerformed(ActionEvent e)
	{
		login l = new login();
//		l.setUser(QQ);  setUser��ʱ��
	}
	
	// ���û�ע��
	private void jb_sureactionPerformed(ActionEvent e)
	{
		if(jt_nickname.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "�������ǳƣ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(jt_password1.getText().length()>=20 || jt_password1.getText().length() < 6)
		{
			JOptionPane.showMessageDialog(null, "�������6-20���ַ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			jt_password1.setText("");
			jt_password2.setText("");
		}
		else if(!jt_password1.getText().equals(jt_password2.getText()))
		{
			JOptionPane.showMessageDialog(null, "�����������벻һ��", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
			jt_password1.setText("");
			jt_password2.setText("");
		}
		else
		{
			// ��ȡע����Ϣ
			nickname = jt_nickname.getText();
			year = jc_year.getSelectedIndex()+1892;
			month = jc_month.getSelectedIndex()+1;
			day = jc_day.getSelectedIndex()+1;
			if(jr_man.isSelected())
			{
				sex = "��";
			}
			else
			{
				sex = "Ů";
			}
			password = jt_password1.getText();
			country = item_country[jc_country.getSelectedIndex()];
			if (country.equals("�й�"))
			{
				province = item_province[jc_province.getSelectedIndex()];
				if (province.equals("ɽ��"))
				{
					city = item_city[jc_city.getSelectedIndex()];
				}
				else if (province.equals("����"))
				{
					city = item_city1[jc_city.getSelectedIndex()];
				}
			}
			else if (country.equals("����"))
			{
				province = item_province1[jc_province.getSelectedIndex()];
				city = null;
			}
			cardl.show(card,"�ȴ�");
			
			// ++++++++++++++++++++�����Ǵ���Ľ��沿��++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
			personalInfo person = new personalInfo(password, nickname, sex, year+"", month+"", day+"", country, province, city);
			applicateClientThread appliate;
			try
			{
				appliate = new applicateClientThread(person);
				judgeThread judge = new judgeThread(appliate);
				judge.start();
				appliate.join(15000);//�����̵߳ȴ�����߳�15�룬15��������߳�û���������̼߳���ִ��
				if(appliate.changed == 1) // ��������Ӧ�������Ѿ����뵽��״̬
				{
					QQ = appliate.getQQ;
					jl3_4.setText(QQ);
					jl3_5.setText("��������ǣ�");
					jl3_6.setText(password);
					jl3_7.setText("  ���μǣ�");
					cardl.show(card, "�ɹ�");
				}
				else if(appliate.changed == 2)
				{
					jl_wait.setText("�Բ���ͬһ��IP�������");
				}
				else if(appliate.changed == 4)  // 4���׳�������ʾ������û����Ҳû����
				{
					jl_wait.setText("�Բ��𣬷�������û�п���........");
				}
				else   // �޷����ʹ��󡣡���
				{
					jl_wait.setText("�Բ���ϵͳ��æ��.........");
				}
			}
			catch(Exception ex)
			{}
		}
		
	}
	
	// ͬ����ط�������
	public void jcitemStateChanged(ItemEvent e)
	{
		if(e.getStateChange() != e.SELECTED)
		{
			jb_sure.setEnabled(false);
		}
		else
		{
			jb_sure.setEnabled(true);
		}
	}
	
	
	
	

}
