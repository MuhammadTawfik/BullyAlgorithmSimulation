package MessageHandler.MessageTypeHandlers;

import Mailer.IMessage;
public class MessageTypeLeaderAck implements IMessageTypeHandler {
  public void handle(IMessage message){
  	System.out.println("My leader is: " + message.sender());
  }
}