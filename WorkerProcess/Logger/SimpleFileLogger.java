package Logger;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class SimpleFileLogger implements ILogger
{

    private String loggingFilePath;

    public SimpleFileLogger(String logFilePath)
    {
        loggingFilePath = logFilePath;
    }

    public void info(String string)
    {
        String logString = "INFO: " + new java.util.Date() + " : " + string;
        write(logString);
    }

    public void error(String string)
    {
        String logString = "ERROR: " + new java.util.Date() + " : " + string;
        write(logString);
    }

    private void write(String string)
    {
        try
        {
            FileWriter myWriter = new FileWriter(loggingFilePath, true);
            myWriter.write(string + "\n");
            myWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}