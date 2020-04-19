import library.*;

import java.util.*;
import java.io.*;

public class mainServer
{
    public mainServer()
    {

    }
    public static void main(String[] args)
    {
        //Library lib = new Library();
        int n = 0;
        while(true)
        {
            try
            {
                Thread t = new customThread(1919,n);
                t.run();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            n++;
        }
    }
}