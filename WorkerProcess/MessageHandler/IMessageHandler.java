package MessageHandler;

import Mailer.IMessage;
public interface IMessageHandler
{
    public void handle(IMessage message);
}