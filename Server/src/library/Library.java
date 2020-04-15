package library;

import java.io.*;
import java.util.*;
import arttnba3.*;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class Library
{
    HashMap system = new HashMap();
    int book_num = 0;
    int account_num = 0;
    public Library()
    {
        initializeSystem();
        readBookdata(book_num);
        readAccountdata(account_num);
    }

    private void initializeSystem()
    {
        File settings = new File("Settings.ini");
        InputStream sInput;
        try
        {
            sInput = new FileInputStream(settings);
        } catch (FileNotFoundException e)
        {
            int option =  showConfirmDialog
                    (
                    null,
                    "�޷���ȡ�����ļ����Ƿ����´�����ͼ��ݣ�",
                    "������ʾ",
                    YES_NO_OPTION
                    );
            switch(option)
            {
                case 0:
                    try
                    {
                        settings.createNewFile();
                        DataOutputStream sOutput = new DataOutputStream(new FileOutputStream(settings));
                        sOutput.writeBytes("[Books]\nNumber = 0\n[Account]\nNumber = 0");
                    }
                    catch (IOException ex)
                    {
                        MyWindows.messageWin
                                (
                                "�޷����������ļ�������ϵϵͳ����Ա��",
                                "������Ϣ",
                                200,
                                100,
                                ERROR_MESSAGE
                                );
                        System.exit(-1);
                    }
                    break;
                case 1:
                    System.exit(0);
                    break;
                default:
                    MyWindows.errorWin(0x10012001);
            }
        }
        //sInput.read();
    }

    private void readBookdata(int book_num)
    {

    }

    private void readAccountdata(int account_num)
    {

    }
}
