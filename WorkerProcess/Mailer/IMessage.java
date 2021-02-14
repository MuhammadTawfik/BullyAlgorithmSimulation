package Mailer;


interface IMessage {
  public String toString();
  public String sender();
  public String receiver();
}