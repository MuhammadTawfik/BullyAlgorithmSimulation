package Mailer;


interface IMailerClient {
  public void send(IMessage message);
  public void handleNewMessages(IMessageHandler handler);

}