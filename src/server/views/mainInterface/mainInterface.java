package server.views.mainInterface;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.lang.InterruptedException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.tree.*;
import javax.swing.*;


public class mainInterface extends JFrame implements ActionListener
{
	private static final long serialVersionUID  = 1L;
	static public String ip = "127.0.0.1";
	//	������ip��ַ�����룩

	HashMap<String, String>   map_qq  = new HashMap<String,String>();
	//���������������������ָʲô��
	String b2 = ".jpg";
	String b1 = "images//main//";
	JLabel imgLabel1  = new JLabel();
	JLabel imgLabel2 = new JLabel();
	JMenuBar jmb1, jmb2;
	JMenu jm1,jm2;
	JMenuItem jm1_online, jm1_hiden,jm1_leave,jm2_sysedit,jm2_editpw,jm2_help,jm2_exit;
	JPanel top, top_1,top_2,bottom,bottom_1,bottom_2,middle1,middle2,middle3;
	JLabel headimg , name ,jl_down;
	JButton add,sysseting, Safe, skin;
	JButton q_zone, blog, email, friend_net, wallet , soso, news ,messagebox, shopping;
	JTabbedPane jtp;
	JScrollPane jsp1 , jsp2, jsp3;
	JComboBox jcb;
	JTree jt;
	JPopupMenu popupMenu;
	JPopupMenu popupMenugp;
	JPopupMenu popupMenuchild;
	JFrame login_jf;
	JPanel login_jp;
	JLabel login_jl;
	JButton login_jb;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode[] Node = new DefaultMutableTreeNode[20];


	static public Container c_temp_main = null;  // �Ự��Ϣ���½ǵ���
	static public mainInterface main_frame = null;
	static public int status; //��ǰ״̬
	static public String text_leave = "2000000���ã������߲��ڣ�matherfucker����������";
	static public String text_busy = "20000 ���ã� �Һ�æ����������";
	static public Date LastExceptionTime = null;   //��¼�����쳣
	static public int heartbeatJudge =0;
	static public int heartbeatFrequency = 6; // ����Ƶ��
	static public int changed =0; // �ж��Ƿ���ܹ�mInfo
	String back = "main_background.jpg";
	final static Integer temp = new Integer(1);
	Dimension dm = null;

	public mainInterface()  //public MainInterface(login_message lmessage)
	{
		//		status = lmessage.status;
		main_frame = this;
		c_temp_main = this.getContentPane();
		//		this.lmessage = lmessage;


		//		һϵ�е��߳�����
		//���������ͼ

		login_jf = new JFrame();
		Toolkit tk = this.getToolkit();// �õ����ڹ�����
		dm  =  tk.getScreenSize();
		login_jf.setLocation((int)(dm.getWidth()-315), 20);
		login_jp = new JPanel();
		login_jp.setLayout(null);
		login_jp.setOpaque(false);
		login_jb = new JButton("ȡ��");
		login_jb.setFont(new Font("����",Font.PLAIN,15));
		login_jb.setActionCommand("ȡ����¼");
		login_jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(e.getActionCommand() == "ȡ����¼")
				{
					System.exit(0);//ֹͣ�Է����������룬Ϊʲô�����ַ�ʽ��ֱ��mouse_clicked ������
				}
			}
		});
		login_jl = new JLabel(new ImageIcon("images/logining_Vip.gif"));
		//������
		login_jl.setBounds(0, 100, 295, 150);
		login_jb.setBounds(100, 300, 80, 30);
		//		login_jp.add(login_jl);
		//		login_jp.add(login_jb);
		//		login_jf.add(login_jp);
		//���ñ���ͼƬ
		final Container c1 = login_jf.getContentPane();
		ImageIcon img1 = new ImageIcon("images/loginingBg.jpg");
		imgLabel2.setIcon(img1);
		imgLabel2.setBounds(0,0,img1.getIconHeight(), img1.getIconHeight());
		((JPanel)login_jf.getContentPane()).setOpaque(false);
		login_jf.getLayeredPane().add(imgLabel2, new Integer(Integer.MIN_VALUE));
		login_jf.getLayeredPane().add(login_jl, new Integer(Integer.MAX_VALUE));
		login_jf.getLayeredPane().add(login_jb, new Integer(Integer.MAX_VALUE));
		// ����ͼ�������
		// ��������
		login_jf.setTitle("KQ2014kingpinMatherFucker");
		Image icon = Toolkit.getDefaultToolkit().getImage("pic\\headpic.jpg");
		login_jf.setIconImage(icon);
		login_jf.setMinimumSize(new Dimension(295,450));
		login_jf.setResizable(false);
		login_jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_jf.setVisible(true);
		//		login.start();

		try
		{
			Thread thread = Thread.currentThread();
			thread.sleep(7000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}

		refresh();



		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){

				//				try{
				//					System.exit(0);
				//				}
				//				catch(InterruptedException e1)
				//				{}
			}
		});


	}

	public void actionPerformed(ActionEvent e)
	{

	}

	public void refresh()
	{
		//�������
		//���ñ���ͼƬ
		ImageIcon img1 = new ImageIcon("main_background.jpg");
		imgLabel1.setIcon(img1);
		imgLabel1.setBounds(0,0, img1.getIconWidth(), img1.getIconHeight());
		((JPanel)getContentPane()).setOpaque(false);
		// getLayeredPane().add(imgLabel1, new Integer(Integer.M
		//		���ñ���ͼƬ���
		//		�������
		GridLayout gl1 = new GridLayout(2,1);
		top = new JPanel(gl1);
		top.setOpaque(false);
		FlowLayout top_f1 = new FlowLayout(FlowLayout.LEFT);
		top_1 = new JPanel(top_f1);
		top_1.setOpaque(false);
		FlowLayout top_f2 = new FlowLayout(FlowLayout.LEFT);
		top_2 = new JPanel(top_f2);
		top_2.setOpaque(false);
		GridLayout gl2 = new GridLayout(2,1);
		bottom = new JPanel(gl2);
		bottom.setOpaque(false);
		FlowLayout f1 = new FlowLayout(FlowLayout.LEFT);
		f1.setHgap(0);
		bottom_1 = new JPanel(f1);
		bottom_1.setOpaque(false);
		FlowLayout f2  = new FlowLayout(FlowLayout.LEFT);
		f1.setHgap(0);
		bottom_2 = new JPanel(f2);
		bottom_2.setOpaque(false);
		//Ϊÿһ����������һ�����
		JMenuItem popInformation  = new JMenuItem("�鿴����",new ImageIcon("images/operation_friend/information.jpg"));
		JMenuItem popChange = new JMenuItem("�޸ĺ��ѱ�ע",new ImageIcon("images/operation_friend/change.jpg"));
		JMenuItem popDelete = new JMenuItem("ɾ������",new ImageIcon("images/operation_friend/delete.jpg"));
		JMenuItem popEmail = new JMenuItem("�����ѷ��ʼ�",new ImageIcon("images/operation_friend/email.jpg"));
		JMenuItem popMove = new JMenuItem("�������ƶ���...");
		//		
		//		popInformation.addActionListener(eee);
		//		popChange.addActionListener(eee);
		//		popEmail.addActionListener(eee);
		//		popMove.addActionListener(eee);
		popInformation.setActionCommand("�鿴��������");
		popChange.setActionCommand("�޸ĺ��ѱ�ע");
		popDelete.setActionCommand("ɾ������");
		popEmail.setActionCommand("���ʼ�");
		popMove.setActionCommand("����������������");
		popInformation.setFont(new Font("������Ů����w5(p)", Font.PLAIN, 15));
		popChange.setFont(new Font("������Ů����w5(p)", Font.PLAIN, 15));
		popDelete.setFont(new Font("������Ů����w5(p)", Font.PLAIN, 15));
		popEmail.setFont(new Font("������Ů����w5(p)", Font.PLAIN, 15));
		popMove.setFont(new Font("������Ů����w5(p)", Font.PLAIN, 15));
		popupMenu = new JPopupMenu();
		popupMenugp  = new JPopupMenu();
		popupMenuchild = new JPopupMenu();
		popupMenu.add(popInformation);
		popupMenu.add(popDelete);
		popupMenu.add(popEmail);
		popupMenu.add(popChange);
		popupMenu.add(popMove);
		//������ÿ������ĵ���
		JMenuItem pop_addgp = new JMenuItem("��ӷ���");
		JMenuItem pop_deletegp = new JMenuItem("ɾ������");
		JMenuItem pop_updategp = new JMenuItem("�޸ķ���");
		//		pop_addgp.addActionListener(eee);
		//		pop_deletegp.addActionListener(eee);
		//		pop_updategp.addActionListener(eee);
		pop_addgp.setActionCommand("��ӷ���");
		pop_deletegp.setActionCommand("ɾ������");
		pop_updategp.setActionCommand("�޸ķ���");
		popupMenugp.add(pop_addgp);
		popupMenugp.add(pop_deletegp);
		popupMenugp.add(pop_updategp);

		//����������
		root = new DefaultMutableTreeNode();

		// -----------------------------���ô���------------------------------------
		this.setTitle("QQ2012");
		Image icon = Toolkit.getDefaultToolkit().getImage("pic\\headpic.jpg");
		this.setIconImage(icon);
		this.setSize(295, 589);
		this.setMinimumSize(new Dimension(295, 450));
		this.setLocation(main_frame.getLocation().x, main_frame.getLocation().y);// ��ʾ����Ļ����
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		login_jf.dispose();



	}


	public static void main(String[] args)throws Exception
	{
		mainInterface news = new mainInterface();
	}

}





