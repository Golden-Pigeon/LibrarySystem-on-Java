package lib;

import javafx.application.Application;
import javafx.stage.Stage;

import java.net.*;
import java.io.*;

public class login extends Application
{
    String username="",password="";
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try
        {
            Socket client = new Socket("localhost", 1919);
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("login:"+username+password);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            int n = Integer.valueOf(in.readUTF());
            switch (n)
            {
                case 0:
                    mainUI mui = new mainUI(client,in.readUTF());//����socket�����úʹӷ�������ȡ����UID
                    break;
                case 1:
                    arttnba3.MyWindows.messageWin("�û�������򲻴��ڣ�","������Ϣ",0);
                    client.close();
                    break;
                case 2:
                    arttnba3.MyWindows.messageWin("�������","������Ϣ",0);
                    client.close();
                    break;
                default:
                    arttnba3.MyWindows.messageWin("������쳣��","������Ϣ",0);
                    client.close();
                    break;
            }
        }
        catch(Exception event)
        {
            event.printStackTrace();
            arttnba3.MyWindows.messageWin("�޷���������������","������Ϣ",0);
        }
    }

    public boolean getInfo(String username, String password)
    {
        if(username.equals("")||username==null||password.equals("")||password==null)
        {
            arttnba3.MyWindows.messageWin("�û���������Ϊ�գ�","������ʾ",0);
            return false;
        }
        this.username = username;
        this.password = password;
        return true;
    }
}
