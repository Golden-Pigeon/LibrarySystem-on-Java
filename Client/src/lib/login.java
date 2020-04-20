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
                    mainUI mui = new mainUI(client,in.readUTF());//传递socket的引用和从服务器读取来的UID
                    break;
                case 1:
                    arttnba3.MyWindows.messageWin("用户名错误或不存在！","错误信息",0);
                    client.close();
                    break;
                case 2:
                    arttnba3.MyWindows.messageWin("密码错误！","错误信息",0);
                    client.close();
                    break;
                default:
                    arttnba3.MyWindows.messageWin("服务端异常！","错误信息",0);
                    client.close();
                    break;
            }
        }
        catch(Exception event)
        {
            event.printStackTrace();
            arttnba3.MyWindows.messageWin("无法连接至服务器！","错误信息",0);
        }
    }

    public boolean getInfo(String username, String password)
    {
        if(username.equals("")||username==null||password.equals("")||password==null)
        {
            arttnba3.MyWindows.messageWin("用户名或密码为空！","错误提示",0);
            return false;
        }
        this.username = username;
        this.password = password;
        return true;
    }
}
