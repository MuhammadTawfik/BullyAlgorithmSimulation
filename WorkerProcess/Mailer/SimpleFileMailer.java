package Mailer;


import java.io.File;  
import java.io.IOException;  
import java.io.FileWriter;

public class SimpleFileMailer implements IMailerClient {

  private String _inboxFilePath;
	private String baseInbox = ""


	public SimpleFileMailer(String inboxID) {
		_inboxFilePath = baseInbox + inboxID + ".inbox" ;
	}
  public void send(IMessage message) {
  	try {
      FileWriter myWriter = new FileWriter(_inboxFilePath, true);
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