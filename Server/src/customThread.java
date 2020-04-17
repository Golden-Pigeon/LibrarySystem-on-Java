import arttnba3.MyWindows;

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
                DataInputStream in = new DataInputStream(server.getInputStream());//�ӿͻ��˽��ܵ�������
                DataOutputStream out = new DataOutputStream(server.getOutputStream());//��ͻ��˷��͵������
                //while(true)
                {
                    String str = "";
                    try
                    {
                        str = readMsg(in,server.getRemoteSocketAddress());
                    }
                    catch (Exception e)
                    {
                        try
                        {
                            sleep(1000);
                        }
                        catch (InterruptedException ex)
                        {
                            ex.printStackTrace();
                        }
                    }
                    if(str.equals("close"))
                        server.close();
                    else if(str.equals("login"))//�������
                    {
                        String[] info = new String[2];
                        for(int i=0;i<2;i++)
                        {
                            try
                            {
                                info[i] = readMsg(in,server.getRemoteSocketAddress());
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                                MyWindows.errorWin(0x10012003);
                            }
                        }
                        if(info[0].equals("arttnba3")&&info[1].equals("xdsec"))
                        {out.writeUTF("0");out.writeUTF("114514");}
                        else if(info[0].equals("arttnba3"))
                            out.writeUTF("2");
                        else
                            out.writeUTF("1");
                    }
                }
                server.close();
            }
            catch(SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                break;
            }
            catch (SocketException r)
            {
                System.out.println("���ӱ����ã�");
            }
            catch(IOException e)
            {
                e.printStackTrace();
                break;
            }

        }
    }
    public String readMsg(DataInputStream in, SocketAddress addr) throws IOException
    {
        String str = in.readUTF();
        System.out.println(addr+" : "+str);
        return str;
    }
}
