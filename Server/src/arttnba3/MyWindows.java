package arttnba3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showConfirmDialog;

//Open in GBK, plz

public class MyWindows extends JFrame//�̳���JFrame�ࣨ��Ҫ������дһ�ѵ�JFrame����߻���
{
	public MyWindows(String title, int width, int height, int closeType)//���⣬���ߣ��ر�����
	{
		setTitle(title);//���ô������

		setCloseOperation(closeType);//���ô���ر�����
		
		setLocationRelativeTo(null);//���ô������
		
		setSize(width,height);//���ô���Ŀ����
		
		
		setVisible(true);//���ô���ɼ�
	}

	public MyWindows(String title, int width, int height, int closeType,int location)//���⣬���ߣ��ر����ͣ�����λ��(��ʱ����
	{
		setTitle(title);//���ô������

		setCloseOperation(closeType);//���ô���ر�����

		setLocationRelativeTo(null);//���ô������

		setSize(width,height);//���ô���Ŀ����

		setVisible(true);//���ô���ɼ�
	}

	public JMenu createFileMenu(String title, String[] items)//����ͨ��JMenu�ࣨ���õĳ���
	{
		JMenu menu = new JMenu(title);
		int num_items = items.length;
		for(int i = 0 ; i < num_items ; i++)
		{
			JMenuItem item = new JMenuItem(items[i]);
			menu.add(item);
		}
		return menu;
	}

	public void setLayout(int kind)//���ô����������������ͣ��빾����״̬
	{
		switch(kind)
		{
		case 0:
			setLayout(new BorderLayout());
			break;
		case 1:
			setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			errorWin(0);
			break;
		}
	}
	
	public void setCloseOperation(int type)//���ô���ر�����
	{
		switch(type)
		{
		case 0:
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر���������
			break;
		case 1:
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�ͷŵ�ǰ����
			break;
		case 2:
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//���ص�ǰ����
			break;
		case 3:
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//��Ч���
			break;
		default:
			errorWin(0x1919114);
			break;
		}
	}
	
	static public void errorWin(int code)//���󴰿�-int��
	{
		JOptionPane p = new JOptionPane();
		JOptionPane.showMessageDialog(p,"�������󣡴������Ϊ�� "+ "0x" + Integer.toHexString(code),"������ʾ",0);
		System.exit(1);
	}
	
	static public void errorWin(String message)//���󴰿�-string��
	{
		JOptionPane p = new JOptionPane();
		JOptionPane.showMessageDialog(p,"�������󣡴�������Ϊ�� "+ message,"������ʾ",0);
		System.exit(1);
	}

	static public void messageWin(String message, String title)//����ʽ��Ϣ����
	{
		JOptionPane p = new JOptionPane();
		JOptionPane.showMessageDialog(p,message,title,1);
	}

	static public void messageWin(String message, String title, int type)//����ʽ��Ϣ����-�Զ�����
	{
		JOptionPane p = new JOptionPane();
		JOptionPane.showMessageDialog(p,message,title,type);
	}

	static public JOptionPane messageWin(String message, String title,int width,int height, int type)//����ʽ��Ϣ����-�Զ�����
	{
		JOptionPane p = new JOptionPane();
		ColorModel cm = p.getColorModel();
		JOptionPane.showMessageDialog(p,message,title,type);
		p.setSize(width,height);
		return p;
	}

	static public int confirmWin(String message, String title, int optionType)//�򵥵�ȷ�ϴ���
	{
		return JOptionPane.showConfirmDialog(null,message,title,optionType);
	}
	
	public void simpleWin(String title, String args)//���״���
	{
		MyWindows simpleWindows = new MyWindows(title,80,40,1);
		JLabel jl = new JLabel(args);
		simpleWindows.add(jl);
		simpleWindows.setResizable(false);
		simpleWindows.setVisible(true);
	}
	
	public static MyWindows secretSpace()
	{
		MyWindows aboutWin = new MyWindows("���ߤ����ؿռ�",350,150,1);
    	aboutWin.setLocationRelativeTo(null);
    	aboutWin.setLayout(null);
    	
    	JLabel userLabel = new JLabel("User:");
        userLabel.setBounds(10,20,165,25);
        aboutWin.add(userLabel);
    	JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        aboutWin.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,165,25);
        aboutWin.add(passwordLabel);
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        aboutWin.add(passwordText);
        
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        aboutWin.add(loginButton);
    	
        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            	String user = userText.getText();
            	String password = passwordText.getText();
            	
            	if((user.length() == 0) || (password.length() == 0))
            		errorWin(0x1919810);
            	if(!user.equals("arttnba3") || !password.equals("xdsec"))
            		errorWin(0x114514);
            	MyWindows secretSpace = new MyWindows("���ߤ����ؿռ�",80,40,1);
            	secretSpace.add(new JLabel("          �����ǿյģ�ʲôҲû�У�������"));
            	secretSpace.setVisible(true);
            	secretSpace.setResizable(false);
            }
        });
        
    	aboutWin.setResizable(false);
    	aboutWin.setVisible(true);
    	
    	return aboutWin;
	}
	
	public static MyWindows myInfo()
    {
    	MyWindows aboutWin = new MyWindows("��������Ա��Ϣ",500,150,1);
    	aboutWin.setLocationRelativeTo(null);
    	aboutWin.setLayout(null);
    	JLabel intro = new JLabel("�����ߣ�arttnba3",JLabel.CENTER);
    	intro.setBounds(0,0,500,50);
    	JLabel intro2 = new JLabel("�������ӿƼ���ѧ   �������ѧ�뼼��ѧԺ  2019����С����_(:��)��)_ ",JLabel.CENTER);
    	intro2.setBounds(0,20,500,50);
    	JLabel intro3 = new JLabel("��ϵ��ʽ��1543127579@qq.com",JLabel.CENTER);
    	intro3.setBounds(0,40,500,50);
    	JLabel intro4 = new JLabel("All Rights Reserved",JLabel.CENTER);
    	intro4.setBounds(0,60,500,50);
    	
    	aboutWin.add(intro);
    	aboutWin.add(intro2);
    	aboutWin.add(intro3);
    	aboutWin.add(intro4);
    	
    	aboutWin.setResizable(false);
    	aboutWin.setVisible(true);
    	
    	return aboutWin;
    }
	
}