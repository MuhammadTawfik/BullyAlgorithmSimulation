package Mailer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import MessageHandler.*;
import java.text.SimpleDateFormat;
import MessageHandler.IMessageHandler;
import java.io.File;
import java.util.Arrays;

public class Inbox implements Runnable
{

    private String _inboxFilePath;
    private int timeToCheckInbox = 100;

    public Inbox( String inboxFilePath)
    {
        _inboxFilePath = inboxFilePath; // "/home/tawfik/BullyAlgorithmSimulation/data/mails/18740.inbox";
    }

    public void run()
    {

        int numberOfLinesRead = 0;
        // System.out.println(_inboxFilePath);
        List<String[]> msgList = new ArrayList<>();
        while(true)
        {
            // check first if file exists
            File f = new File(_inboxFilePath);
            if(!f.exists() || f.isDirectory())
            {
                try
                {
                    Thread.sleep(timeToCheckInbox);
                }
                catch(InterruptedException e) {}
                continue;
            }
            // read the messages form inbox file
            try (Stream <String> lines = Files.lines(Paths.get(_inboxFilePath)))
            {
                msgList = lines
                          .skip(numberOfLinesRead)
                          .map(s -> s.toString().split("\\|"))
                          // this line never worked !!
                          // .map(m ->  new SimpleStringMessage(m[1], "", m[3], m[2], formatDate(m[0])))
                          .collect(Collectors.toList());

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            for(String[]  msg : msgList)
            {
                ++numberOfLinesRead;
                // System.out.println(Arrays.toString(msg));
                if (msg.length <= 1)
                {
                    continue;
                }

                SimpleStringMessage msgObject;

                try
                {
                    SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
                    msgObject =  new SimpleStringMessage(msg[1], "", msg[3], msg[2], formatter.parse(msg[0]));
                }
                catch (Exception e)
                {
                    msgObject =  new SimpleStringMessage(msg[1], "", msg[3], msg[2]);
                }
                // System.out.println(msgObject.toString());
            }
            try
            {
                Thread.sleep(timeToCheckInbox);
            }
            catch(InterruptedException e) {}
            continue;
        }
    }

    public void start()
    {
        Thread t1 = new Thread(this);
        t1.start();
    }

}