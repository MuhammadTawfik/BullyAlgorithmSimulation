package MessageHandler;

import Mailer.IMessage;
import MessageHandler.MessageTypeHandlers.MessageTypeLeaderAck;
import MessageHandler.MessageTypeHandlers.IMessageTypeHandler;

public class SimpleMessageHandler implements IMessageHandler {
  public void handle(IMessage message){
    _pickTypeHandler(message.type()).handle(message);
  }

  private IMessageTypeHandler _pickTypeHandler(String type) {
  	switch(type) {
  case "LeaderAck":
    return new MessageTypeLeaderAck();

  default:
   return new MessageTypeLeaderAck();
}

  }
}