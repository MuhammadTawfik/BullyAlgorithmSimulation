package Mailer;


import java.io.File;  
import java.io.IOException;  
import java.io.FileWriter;

public class SimpleFileMailer implements IMailerClient {

  private String _inboxFilePath;
	private String _baseInboxDirectory;


	public SimpleFileMailer( String baseInboxDirectory, String inboxID) {
     _baseInboxDirectory = baseInboxDirectory;
		_inboxFilePath = _baseInboxDirectory + inboxID + ".inbox" ;
	}
  public void send(IMessage message) {
  	String receiverInbox = _baseInboxDirectory + message.receiver() + ".inbox";
  	try {
      FileWriter myWriter = new FileWriter(receiverInbox, true);
      myWriter.write(message.toString() + "\n");
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public void handleNewMessages(IMessageHandler handler) {

  }

}