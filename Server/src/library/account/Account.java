package library.account;

import arttnba3.MyWindows;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public abstract class Account
{
    final public int AUTHORIZATION;
    final public int ID;
    final public int MAX_LENT;
    String username;
    String password_hash;

    protected Account(int authorization, int id, int lentNum, String username, String password)
    {
        this.ID = id;
        this.AUTHORIZATION = authorization;
        this.MAX_LENT = lentNum;
        setUsername(username);
        setPassword(password);
    }

    protected String getPasswordHash(@NotNull String password)
    {
        String password_hash = "";
        if(password.equals(""))
        {
            MyWindows.errorWin(0x10012002);
        }
        long ch1,ch2;
        for(int i = 0, n = password.length(); i < n;i++)
        {
            ch1 = (long)password.charAt(i)*(long)(n-i)*114L*514L*1919L*810L%128L;
            ch2 = (long)password.charAt(i)*(long)(i)*114L*514L*1919L*810L%128L;
            password_hash += String.valueOf(ch1);
            password_hash += String.valueOf(ch2);
        }
        for(int i=0;password_hash.length()>16;i++)
        {
            password_hash
                    = password_hash.substring(0,password_hash.length()-2)
                    + String.valueOf(password_hash.charAt(password_hash.length()-1)
                                    *password_hash.charAt(password_hash.length()-2)
                                    *114514L
                                    *i
                                    %128L);
        }
        for(int i=0;password_hash.length()<16;i++)
        {
            password_hash
                    = password_hash
                    + String.valueOf(password_hash.charAt(password_hash.length()-1)
                                    *password_hash.charAt(password_hash.length()-2)
                                    *114514L
                                    *i
                                    %128L);
        }
        return password_hash;
    }

    protected void setPassword(String password)
    {
        this.password_hash = getPasswordHash(password);
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

}
