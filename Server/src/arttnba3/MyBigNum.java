package arttnba3;
import java.util.*;
import java.lang.*;

public class MyBigNum
{
    public ArrayList<Integer> intg = new ArrayList<Integer>();//Interger part
    public ArrayList<Integer> dcml = new ArrayList<Integer>();//Decimal part
    public boolean isNega  = false;//whether this num is a negative num
    public boolean isReal = false;
    public final static MyBigNum ZERO = new MyBigNum("0");
    public final static MyBigNum MAX_VALUE = new MyBigNum(0);
    public final static MyBigNum MIN_VALUE = new MyBigNum(1);
    private int length = 114514;

    public int length()
    {
        return intg.size() + dcml.size();
    }

    public MyBigNum(String value)//SimpleVersion, complete later...
    {
        this.length = 0;
        int len = value.length();
        /*if(len>MAX_VALUE.length)
        {
            MyWindows.errorWin(0x10001004);
        }*/
        if(len > 114514)
            MyWindows.errorWin(0x10001004);
        int num;//temporary variable

        for(int i=value.length()-1;i>=0;i--)//default Integer part
        {
            if(value.charAt(i) == '.' && i != 0)//to judge whether it's a real num or not
            {
                this.isReal = true;
                break;
            }
            if(value.charAt(i) == '-')//to judge whether it's a negative num or not
            {
                this.isNega = true;
                continue;
            }
            else if(value.charAt(i) == '+')
            {
                this.isNega = false;
                continue;
            }
            num = value.charAt(i)-'0';
            if(num<0||num>10)
                MyWindows.errorWin(0x10001001);
            this.intg.add(num);
            this.length++;
        }

        if(this.isReal)//the decimal part
        {
            for(int i=length+1;i>=0;i--)
            {
                if(value.charAt(i) == '-' && i!=length+1)//to judge whether it's a negative num or not
                {
                    this.isNega = true;
                    continue;
                }
                else if(value.charAt(i) == '+' && i!=length+1)
                {
                    this.isNega = false;
                    continue;
                }
                num = value.charAt(i)-'0';
                if(num<0||num>10)
                    MyWindows.errorWin(0x10001001);
                this.dcml.add(num);
                length++;
            }
        }
    }

    public MyBigNum()
    {
        this.length = 2;
        this.intg.add(0);
        this.dcml.add(0);
    }

    private MyBigNum(int mode)
    {
        if(mode == 0)
            this.isNega = false;
        else
            this.isNega = true;
    }

    public void addIntg(MyBigNum num)//P+P,N+N,P-N,N-P
    {
        if(ZERO.equals(this))
        {
            this.intg = num.intg;
            this.isNega = num.isNega;
            return ;
        }
        if(ZERO.equalIntg(num))
            return ;
        if(num.isNega != this.isNega)
        {
            num.isNega = this.isNega;
            this.subIntg(num);
            return ;
        }
        int len1 = this.intg.size();
        int len2 = num.intg.size();
        if(len1 < len2)
        {
            ArrayList<Integer> temp = this.intg;
            this.intg = num.intg;
            num.intg = temp;
        }
        for(int i = 0, len = Integer.min(len1,len2), lenm = Integer.max(len1,len2);i < len;i++)//len is the minimum, lenm is the maximum`
        {
            this.intg.set(i,this.intg.get(i)+num.intg.get(i));
            /*if(this.intg.get(i)>10)
            {
                int n = this.intg.get(i)/10;
                this.intg.set(i,this.intg.get(i)%10);
                if(i+1 == lenm)
                    this.intg.add(n);
                else
                    this.intg.set(i+1, this.intg.get(i+1)+n);
            }*/
        }
        for(int i = 0, len = this.intg.size();i < len;i++)//health check
        {
            if(this.intg.get(i)>=10)
            {
                int n = this.intg.get(i)/10;
                this.intg.set(i,this.intg.get(i)%10);
                if(i+1 == len)
                    this.intg.add(n);
                else
                    this.intg.set(i+1, this.intg.get(i+1)+n);
            }
        }
        for(int i=this.intg.size()-1;i>0;i--)
            if(this.intg.get(i)==0)
                this.intg.remove(i);
            else
                break;
    }

    public void subIntg(MyBigNum num)//P-P,N-N
    {
        if(ZERO.equals(this))
        {
            this.intg = num.intg;
            this.isNega = !num.isNega;
            return ;
        }
        if(ZERO.equalIntg(num))
            return ;
        if(num.isNega != this.isNega)
        {
            num.isNega = this.isNega;
            this.addIntg(num);
            return ;
        }
        if(this.equalIntg(num))
        {
            this.intg = new ArrayList<Integer>();
            this.intg.add(0);
            this.isNega = false;
            return ;
        }
        boolean flags = false;
        int len1 = this.intg.size();
        int len2 = num.intg.size();
        if(compIntg(num)<0)
        {
            ArrayList<Integer> temp = this.intg;
            this.intg = num.intg;
            num.intg = temp;
            flags= !flags;
        }
        for(int i = 0, len = Integer.min(len1,len2), lenm = Integer.max(len1,len2);i < len;i++)//len is the minimum, lenm is the maximum
        {
            int n = /*this.intg.set(i,*/this.intg.get(i)-num.intg.get(i);//);
            if(n<0)
            {
                this.intg.set(i,n+10);
                if(i+1 == lenm)//lend the higher num
                {
                    this.intg.add(9);
                    flags = true;
                }
                else
                    this.intg.set(i+1,this.intg.get(i+1)-1);
            }
            else
                this.intg.set(i,n);
        }
        if(flags)
            this.isNega = !this.isNega;
        for(int i=this.intg.size()-1;i>0;i--)
            if(this.intg.get(i)==0)
                this.intg.remove(i);
            else
                break;
    }

    public void mulIntg(MyBigNum num)
    {
        if(ZERO.equalIntg(num))
        {
            this.intg = new ArrayList<Integer>();
            this.dcml = new ArrayList<Integer>();
            this.intg.add(0);
            this.dcml.add(0);
            return ;
        }
        if(this.isNega != num.isNega)//++or--get+, +-or-+get-
            this.isNega = true;
        int len1 = this.intg.size();
        int len2 = num.intg.size();
        if(len1 < len2)
        {
            ArrayList<Integer> temp = this.intg;
            this.intg = num.intg;
            num.intg = temp;
        }
        int[] cal;
        int[] sum = new int[this.intg.size()+num.intg.size()];
        int leng = 0;
        for(int i = 0, len = Integer.min(len1,len2), lenm = Integer.max(len1,len2);i < len;i++)//len is the minimum, lenm is the maximum
        {
            cal = new int[this.intg.size() + 2];
            for (int j = 0; j < lenm; j++)
            {
                cal[j] += this.intg.get(j) * num.intg.get(i);
                if (cal[j] > 9)
                {
                    cal[j + 1] += cal[j] / 10;
                    cal[j] %= 10;
                }
            }
            for(int k=0;k<lenm+1;k++)
            {
                sum[k+i] += cal[k];
                leng=k+i;
                if(sum[k+i] > 9)
                {
                    sum[k+i+1] += sum[k+i] / 10;
                    sum[k+i] %=10;
                    leng = k+i+1;
                }
            }
        }
        this.intg.clear();
        for(int i=leng;i>0;i--)
            if(sum[i] == 0)
                leng--;
            else
                break;
        for(int i=0;i<=leng;i++)
        {
            this.intg.add(sum[i]);
        }
    }

    public void divIntg(MyBigNum num)
    {
        if(ZERO.equalIntg(num))
            MyWindows.errorWin("除数不能为0！");
        if(this.equals(ZERO))
            return ;
        int flag = this.compIntg(num);
        if(flag != 1)
        {
            this.intg.clear();
            if(flag == -1)
                this.intg.add(0);
            else if(flag == 0)
                this.intg.add(1);
            else
                MyWindows.errorWin(0x1000100A);
            return ;
        }
        boolean flags = this.isNega;
        if(this.isNega != num.isNega)
        {
            flags = this.isNega?this.isNega:num.isNega;
        }
        this.isNega = num.isNega = false;
        MyBigNum div;
        MyBigNum result = new MyBigNum("0");
        int len = this.intg.size() - num.intg.size();
        String str = "1";
        for(int i=0;i<len;i++)
            str += "0";
        for(int i=0;i<=len;i++)
        {
            if(i==0)
                result.intg.clear();
            else
                result.mulIntg(new MyBigNum("10"));
            div = new MyBigNum(str);
            div.mulIntg(copyIntg(num));
            int count = 0;
            while(this.compIntg(div) >= 0)
            {
                this.subIntg(div);
                count++;
            }
            str = str.substring(0,str.length()-1);
            if(i==0)
                result.intg.add(0,count);
            else
                result.intg.set(0,count+result.intg.get(0));
        }
        this.intg = result.intg;
        this.isNega = flags;
        return ;
    }

    public boolean equalIntg(MyBigNum num)
    {
        if(this.intg.size() != num.intg.size())
            return false;
        for(int i = this.intg.size()-1;i>=0;i--)
            if(this.intg.get(i) != num.intg.get(i))
                return false;
        return true;
    }

    public boolean equalDcml(MyBigNum num)
    {
        if(this.dcml.size() != num.dcml.size())
            return false;
        for(int i = this.dcml.size()-1;i>=0;i--)
            if(this.dcml.get(i) != num.dcml.get(i))
                return false;
        return true;
    }

    public boolean equals(MyBigNum num)
    {
        if(this.equalIntg(num) && this.equalDcml(num))
            return true;
        else
            return false;
    }

    protected String toStringIntg()
    {
        String str = new String("");
        int n;
        boolean flag = true;
        for(int i=intg.size()-1;i>=0;i--)
        {
            n = intg.get(i);
            if(flag)
            {
                if(n==0)
                    continue;
                else
                    flag = false;
            }
            str += new String(String.valueOf(n));
        }
        if(str.equals(""))
            str = "0";
        return str;
    }

    protected String toStringDcml()
    {
        String str = new String("");
        for(int i=intg.size();i>=0;i--)
            str += new String(String.valueOf(dcml.get(i)));
        return str;
    }

    /*public String toString()
    {
        if(this.isNega)
            return "-" + this.toStringIntg() + "." + this.toStringDcml();
        else
            return this.toStringIntg() + "." + this.toStringDcml();
    }*/

    public int compIntg(MyBigNum num)//whether this > num or not
    {
        if(this.intg.size()>num.intg.size())
            return 1;
        if(this.intg.size()<num.intg.size())
            return -1;
        for(int i=this.intg.size()-1;i>=0;i--)
            if(this.intg.get(i)>num.intg.get(i))
                return 1;
            else if(this.intg.get(i)<num.intg.get(i))
                return -1;
            else
                continue;
        return 0;
    }

    public MyBigNum copyIntg(MyBigNum num)
    {
        MyBigNum copy = new MyBigNum();
        copy.intg.clear();
        for(int i=0;i<num.intg.size();i++)
            copy.intg.add(num.intg.get(i));
        copy.isNega = num.isNega;
        return copy;
    }
}

