package com.cherry.thomas.lib.filedata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DataFile
{
    File file = null;
    RandomAccessFile data = null;
    long pos = 0;
    DataRow current_row = null;
    
    public DataFile(File in)
    {
        this.file = in;
        try
        {
            if (!this.file.exists()){this.file.createNewFile();}
            this.data = new RandomAccessFile(this.file, "rw");
        }
        catch (/*FileNotFoundException |*/ IOException e)
        {
            e.printStackTrace();
        }
        
        if (this.data!=null)
        {
            
        }
    }
    
    String readToEndOfLine()
    {
        StringBuffer line = new StringBuffer();
        try
        {
            //line.append(this.data.readLine());
            char letter = (char)this.data.readByte();
            while (-1<letter && letter!='\n')
            {
                line.append(letter);
                letter = (char)this.data.readByte();
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
        return line.toString();
    }
    
    
    public String read(String key, String column){return null;}
    public void write(String key, String column, String value){}
    public void close()
    {
        try
        {
            this.data.close();
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
    }
}