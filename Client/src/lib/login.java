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
            arttnba3.MyWindows.messageWin(in.readUTF(),"���Է���˵���Ϣ",1);
        }
        catch(Exception event)
        {
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
