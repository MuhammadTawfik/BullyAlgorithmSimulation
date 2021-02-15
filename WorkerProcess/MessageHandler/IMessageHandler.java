package MessageHandler;

import Mailer.IMessage;
interface IMessageHandler {
  public void handle(IMessage message);
}