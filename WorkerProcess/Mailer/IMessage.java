package Mailer;


public interface IMessage
{
    public String toString();
    public String sender();
    public String receiver();
    public String type();
}