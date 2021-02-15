package MessageHandler.MessageTypeHandlers;

import Mailer.IMessage;
public interface IMessageTypeHandler {
  public void handle(IMessage message);
}