package com.cherry.thomas.lib.filedata;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

/**
Unit test for simple App.
*/
public class DataFileTest extends TestCase
{
    /**
    Create the test case
    @param testName name of the test case
    */
    public DataFileTest( String testName )
    {
        super( testName );
    }

    /**
    @return the suite of tests being tested
    */
    public static Test suite()
    {
        return new TestSuite( DataFileTest.class );
    }

    /**
    Rigorous Test :-)
    */
    public void testApp()
    {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sample.csv").getFile());
        DataFile df = new DataFile(file);
        
        System.out.printf("\n%s:\n%s\n", file.getAbsolutePath()
            , df.readToEndOfLine());
        
        assertTrue( df!=null );
        
        
        df.close();
    }
}
