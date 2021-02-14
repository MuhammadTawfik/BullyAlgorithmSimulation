package Mailer;


interface IMessageHandler {
  public void handle(String sender, String type, String content, java.util.Date timeStamp);
}