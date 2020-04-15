package library;

import arttnba3.MyWindows;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class Account
{
    final int AUTHORIZATION;
    final int ID;
    final int MAX_LENT;
    String password_hash;
    ArrayList<Integer> bookLent = new ArrayList<>();

    protected Account(int authorization, int id, int lentNum,String password)
    {
        this.ID = id;
        this.AUTHORIZATION = authorization;
        this.MAX_LENT = lentNum;
        setPassword(password);
    }

    protected String getPasswordHash(@NotNull String password)
    {
        String password_hash = "";
        if(password.equals(""))
        {
            MyWindows.errorWin(0x10012002);
        }
        for(int i = 0, n = password.length(); i < n;i++)
        {

        }
        return password_hash;
    }

    protected boolean setPassword(String password_hash)
    {
        try
        {
            this.password_hash = password_hash;
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
