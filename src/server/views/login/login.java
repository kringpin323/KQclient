package server.views.login;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;

public class login extends JFrame implements MouseListener
{
	/*
	 * 
	 * */
	private static final long 	serialVersionUID = 1L; 
	//	����������˼��
	private JPanel				jp_login;
	private JTextField 			jt_user;
	private JPasswordField 		jp_password; //ԭ�팣�T���@��һ��passwordField
	private JButton  			jb_login;
	private JLabel				jl_logo, jl_user, jl_password, jl_apply, jl_rember, jl_status;
	private JComboBox  			jco_status;
	private JCheckBox  			jch_rember,  jch_login;
	private Dimension  			screenSize;

	public login()
	{
		Image image = Toolkit.getDefaultToolkit().getImage("pic//headpic.jpg");
		setIconImage(image);
		//��ȡ��ǰ��Ļ��С
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//��ȡ��ǰ���ڴ�С
		this.setLocation(screenSize.width/3,screenSize.height/3);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		//������
		//logo
		jl_logo = new JLabel();
		jl_logo.setIcon(new ImageIcon("pic/logo.gif"));
		c.add(jl_logo,BorderLayout.NORTH);
		//̎���в�
		//center
		jp_login = new JPanel();
		jp_login.setLayout(null);
		//QQ�~̖
		jl_user = new JLabel();
		jl_user.setText("qq�~̖");
		jl_user.setBounds(10,30,50,20);
		jl_user.setFont(new Font("���w",Font.ROMAN_BASELINE,12));
		jp_login.add(jl_user);
		//QQ�~̖��ꑿ�
		jt_user = new JTextField();
		jt_user.setHorizontalAlignment(JTextField.LEFT);
		jt_user.setBounds(70,30,160,20);
		jp_login.add(jt_user);
		//��Ո�~̖
		jl_apply = new JLabel();
		jl_apply.setText("��Ո�~̖");
		jl_apply.setBounds(250, 30, 80, 20);
		jl_apply.setFont(new Font("���w",Font.LAYOUT_NO_START_CONTEXT,12));
		jl_apply.setForeground(Color.green);
		jl_apply.addMouseListener(this);
		jp_login.add(jl_apply);

		//QQ�ܴa
		jl_password = new JLabel();
		jl_password.setText("QQ�ܴa");
		jl_password.setBounds(10,60,50,20);
		jl_password.setFont(new Font("���w",Font.CENTER_BASELINE,12));
		jp_login.add(jl_password);

		//QQ�ܴa��ꑿ�
		jp_password = new JPasswordField();
		jp_password.setBounds(70,60,160,20);
		jp_password.setHorizontalAlignment(JTextField.LEFT);
		jp_login.add(jp_password);
		// ����I�P�¼�
		jp_password.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e){}
			
			public void keyReleased(KeyEvent e){}
			
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
//					try{}
				}
			}
		});

		//��ӛ�ܴa
		jl_rember = new JLabel();
		jl_rember.setText("�����ܴa");
		jl_rember.setFont(new Font("���w",Font.PLAIN,12));
		jl_rember.setBounds(250, 60, 70, 20);
		jl_rember.setForeground(Color.blue);
		jl_rember.setBackground(Color.red);
		jl_rember.addMouseListener(this);
		jp_login.add(jl_rember);
		//��B
		jl_status = new JLabel();
		jl_status.setText("��B��");
		jl_status.setFont(new Font("���w",Font.PLAIN,12));
		jl_status.setBounds(40,110,40,20);
		jl_status.setForeground(Color.black);
		jp_login.add(jl_status);
		jco_status = new JComboBox();
		jco_status.addItem("�ھ�");
		jco_status.addItem("�x�_");
		jco_status.addItem("�[��");
		jco_status.addItem("æµ");
		jco_status.addItem("Ո���_");
		jco_status.setBounds(80, 110, 60, 20);
		jco_status.setFont(new Font("���w",Font.PLAIN,13));
		jp_login.add(jco_status);
		
		//ӛ��ܴa
		jch_rember = new JCheckBox();
		jch_rember.setText("ӛס�ܴa");
		jch_rember.setBounds(145, 110, 80, 20);
		jch_rember.setFont(new Font("���w",Font.PLAIN,13));
		jp_login.add(jch_rember);
		
		// �Ԅӵ��
		jch_login = new JCheckBox();
		jch_login.setText("�Ԅӵ��");
		jch_login.setFont(new Font("���w",Font.PLAIN,13));
		jch_login.setBounds(230,110,80,20);
		jp_login.add(jch_login);
		
		//���
		jb_login = new JButton();
		jb_login.setIcon(new ImageIcon("pic//login.gif"));
		jb_login.setBounds(240,140,65,20);
		jp_login.add(jb_login);
		c.add(jp_login,BorderLayout.CENTER);
		// 푑�
		jb_login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					jb_loginactionPerformed(e);
				}
				catch(Exception e1){}
			}
			
		});
		setResizable(false);
		setSize(348,250);
		setVisible(true);
		setTitle("KQ2014 matherfucker");
		
		
		
		
	}
	
	private void jb_loginactionPerformed(ActionEvent e)throws UnknownHostException, IOException,InterruptedException
	{
		if(jt_user.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Ոݔ���~̖����","motherkisser ��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(jt_user.getText().length()<6 || jt_user.getText().length() > 20)
		{
			JOptionPane.showMessageDialog(null, "Ոݔ�����_���~̖���~̖���Ԟ锵�ֻ���Email��ַ", "�ā�]���^�����@�ӵĸ��X", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else
		{
//			login_message lmessage = new login_message(jt_user.get)
//		�@�ǿ��Ե�䛵���Ϣ���@�e�Ȳ���̎��
		}
			
	}
	
	private void jb_loginactionPerformed(KeyEvent e) throws UnknownHostException, IOException,InterruptedException
	{
		if(jt_user.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Ոݔ���~̖�ٵ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if(jt_user.getText().length()<6 || jt_user.getText().length()>20)
		{
			JOptionPane.showMessageDialog(null, "Ոݔ�����_���~̖���6λС�20λ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			
		}
		else
		{
//			�ɹ�ͨ�^�z�y�����䛣����ģ�K�Ͳ��ǬF�ڌ�
		}
	}

	public void mouseReleased(MouseEvent e){}

	public void mousePressed(MouseEvent e){}

	public void mouseEntered(MouseEvent e){}

	public void mouseExited(MouseEvent e){}

	public void mouseClicked(MouseEvent e)
	{
		JLabel jl = (JLabel)e.getSource();
		if(jl == jl_rember)
		{
			if(jt_user.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Ո��ݔ���~̖","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{

			}
		}
		else if(jl == jl_apply)
		{
			//			apply a= new apply();
			//��̎��Ո�µ�QQ�~̖
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		login application = new login();
	}
}
