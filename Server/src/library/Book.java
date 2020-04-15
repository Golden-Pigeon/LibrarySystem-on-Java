package library;

import java.util.*;

public class Book
{
    final String name, press;
    final int identifier;
    ArrayList<String> author;
    boolean isLent;
    public Book(String name, ArrayList<String> author, String press, int identifier)
    {
        this.name = name;
        this.author = author;
        this.press = press;
        this.isLent = false;
        this.identifier = identifier;
    }

    public boolean lentBook()
    {
        if(this.isLent == false)
        {
            this.isLent = true;
            return true;
        }
        else
            return false;
    }

    public boolean returnBook()
    {
        if(this.isLent)
        {
            this.isLent = false;
            return true;
        }
        else
            return false;
    }
}
