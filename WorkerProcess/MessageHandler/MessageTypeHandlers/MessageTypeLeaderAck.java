package MessageHandler.MessageTypeHandlers;

import Mailer.IMessage;
import Logger.*;
public class MessageTypeLeaderAck implements IMessageTypeHandler {

	private ILogger _logger;
	public MessageTypeLeaderAck(ILogger logger) {
		_logger = logger;
	}
  	public void handle(IMessage message){
  		_logger.info("My leader is: " + message.sender());
  	}
}