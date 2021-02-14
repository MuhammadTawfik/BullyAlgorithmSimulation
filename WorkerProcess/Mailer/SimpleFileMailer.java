package Mailer;


import java.io.File;  
import java.io.IOException;  
import java.io.FileWriter;

public class SimpleFileMailer implements IMailerClient {

  private String _inboxFilePath;
	private String baseInboxDirectory = "/home/tawfik/BullyAlgorithmSimulation/data/mails/";


	public SimpleFileMailer(String inboxID) {
		_inboxFilePath = baseInboxDirectory + inboxID + ".inbox" ;
	}
  public void send(IMessage message) {
  	String receiverInbox = baseInboxDirectory + message.receiver() + ".inbox";
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