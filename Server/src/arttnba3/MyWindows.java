package arttnba3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorModel;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import static javax.swing.JOptionPane.showConfirmDialog;

//Open in GBK, plz

public class MyWindows extends JFrame//继承自JFrame类（主要是懒得写一堆的JFrame（左边划掉
{
	public MyWindows(String title, int width, int height, int closeType)//标题，宽，高，关闭类型
	{
		setTitle(title);//设置窗体标题

		setCloseOperation(closeType);//设置窗体关闭类型
		
		setLocationRelativeTo(null);//设置窗体居中
		
		setSize(width,height);//设置窗体的宽与高
		
		
		setVisible(true);//设置窗体可见
	}

	public MyWindows(String title, int width, int height, int closeType,int location)//标题，宽，高，关闭类型，窗体位置(暂时无用
	{
		setTitle(title);//设置窗体标题

		setCloseOperation(closeType);//设置窗体关闭类型

		setLocationRelativeTo(null);//设置窗体居中

		setSize(width,height);//设置窗体的宽与高

		setVisible(true);//设置窗体可见
	}

	public JMenu createFileMenu(String title, String[] items)//创建通用JMenu类（无用的尝试
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

	public void setLayout(int kind)//设置窗体容器管理器类型，半咕咕咕状态
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
	
	public void setCloseOperation(int type)//设置窗体关闭类型
	{
		switch(type)
		{
		case 0:
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭整个程序
			break;
		case 1:
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//释放当前窗体
			break;
		case 2:
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//隐藏当前窗体
			break;
		case 3:
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//无效点击
			break;
		default:
			errorWin(0x1919114);
			break;
		}
	}
	
	static public void errorWin(int code)//错误窗口-int型
	{
		JOptionPane p = new JOptionPane();
		JOptionPane.showMessageDialog(p,"参数错误！错误代码为： "+ "0x" + Integer.toHexString(code),"错误提示",0);
		System.exit(1);
	}
	
	static public void errorWin(String message)//错误窗口-string型
	{
		JOptionPane p = new JOptionPane();
		JOptionPane.showMessageDialog(p,"参数错误！错误类型为： "+ message,"错误提示",0);
		System.exit(1);
	}

	static public void messageWin(String message, String title)//弹出式消息窗口
	{
		JOptionPane p = new JOptionPane();
		JOptionPane.showMessageDialog(p,message,title,1);
	}

	static public void messageWin(String message, String title, int type)//弹出式消息窗口-自定义型
	{
		JOptionPane p = new JOptionPane();
		JOptionPane.showMessageDialog(p,message,title,type);
	}

	static public JOptionPane messageWin(String message, String title,int width,int height, int type)//弹出式消息窗口-自定义型
	{
		JOptionPane p = new JOptionPane();
		ColorModel cm = p.getColorModel();
		JOptionPane.showMessageDialog(p,message,title,type);
		p.setSize(width,height);
		return p;
	}

	static public int confirmWin(String message, String title, int optionType)//简单的确认窗口
	{
		return JOptionPane.showConfirmDialog(null,message,title,optionType);
	}
	
	public void simpleWin(String title, String args)//简易窗口
	{
		MyWindows simpleWindows = new MyWindows(title,80,40,1);
		JLabel jl = new JLabel(args);
		simpleWindows.add(jl);
		simpleWindows.setResizable(false);
		simpleWindows.setVisible(true);
	}
	
	public static MyWindows secretSpace()
	{
		MyWindows aboutWin = new MyWindows("作者の神秘空间",350,150,1);
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
            	MyWindows secretSpace = new MyWindows("作者の神秘空间",80,40,1);
            	secretSpace.add(new JLabel("          这里是空的，什么也没有（滑稽）"));
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
    	MyWindows aboutWin = new MyWindows("开发者人员信息",500,150,1);
    	aboutWin.setLocationRelativeTo(null);
    	aboutWin.setLayout(null);
    	JLabel intro = new JLabel("开发者：arttnba3",JLabel.CENTER);
    	intro.setBounds(0,0,500,50);
    	JLabel intro2 = new JLabel("西安电子科技大学   计算机科学与技术学院  2019级的小萌新_(:з)∠)_ ",JLabel.CENTER);
    	intro2.setBounds(0,20,500,50);
    	JLabel intro3 = new JLabel("联系方式：1543127579@qq.com",JLabel.CENTER);
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