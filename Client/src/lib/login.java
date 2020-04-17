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
            out.writeUTF("login");
            out.writeUTF(username);
            out.writeUTF(password);
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            arttnba3.MyWindows.messageWin(in.readUTF(),"来自服务端的消息",1);
        }
        catch(Exception event)
        {
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
