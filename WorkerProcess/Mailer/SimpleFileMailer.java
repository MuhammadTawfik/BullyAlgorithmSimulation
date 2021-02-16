package Mailer;


import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import MessageHandler.IMessageHandler;

public class SimpleFileMailer implements IMailerClient
{

    private String _inboxFilePath;
    private String _baseInboxDirectory;
    private IMessageHandler _handler;


    public SimpleFileMailer( String baseInboxDirectory, String inboxID, IMessageHandler handler)
    {
        _baseInboxDirectory = baseInboxDirectory;
        _inboxFilePath = _baseInboxDirectory + inboxID + ".inbox" ;
        _handler = handler;
        Inbox inbox = new Inbox(_inboxFilePath, _handler);
        inbox.start();
    }
    public void send(IMessage message)
    {
        String receiverInbox = _baseInboxDirectory + message.receiver() + ".inbox";
        try
        {
            FileWriter myWriter = new FileWriter(receiverInbox, true);
            myWriter.write(message.toString() + "\n");
            myWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}