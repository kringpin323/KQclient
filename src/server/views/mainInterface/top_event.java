package server.views.mainInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class top_event implements ActionListener
{
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="QQ�ռ�")
		{
			JOptionPane.showMessageDialog(null,"δ��ͨ�ռ䣡","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand()=="΢��")
		{
			JOptionPane.showMessageDialog(null,"΢��Ҳû��ͨ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand()=="����")
		{
			JOptionPane.showMessageDialog(null,"�����һ����ٿ�ͨ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand()=="������")
		{
			JOptionPane.showMessageDialog(null,"������û��ͨ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand()=="Ǯ��")
		{
			JOptionPane.showMessageDialog(null,"Ǯ��δ��ͨ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand()=="����")
		{
			JOptionPane.showMessageDialog(null,"����δ��ͨ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand()=="��Ѷ")
		{
			JOptionPane.showMessageDialog(null,"����Ѷ���ݣ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand()=="���ﳵ")
		{
			JOptionPane.showMessageDialog(null,"���ﳵ���Ὺͨ�ģ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand()=="��Ϣ����")
		{
			JOptionPane.showMessageDialog(null,"��û����Ϣ��","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}
		else{}
	}
}
