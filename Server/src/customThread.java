import java.net.*;
import java.io.*;

public class customThread extends Thread
{
    private ServerSocket serverSocket;

    public customThread(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
        //serverSocket.setSoTimeout(1145141919810);
    }
    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                System.out.println("�ȴ�Զ�����ӣ��˿ں�Ϊ��" + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();
                System.out.println("Զ��������ַ��" + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("��IP�Ѿ���¶�ˣ�" + server.getLocalSocketAddress() + "\n��������ҹ���ĸ�ͷ��");
                server.close();
            }catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }catch(IOException e)
            {
                e.printStackTrace();
                break;
            }
        }
    }
}
