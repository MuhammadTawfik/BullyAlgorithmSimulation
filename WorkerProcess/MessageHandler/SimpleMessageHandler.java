package MessageHandler;

import Mailer.IMessage;
import MessageHandler.MessageTypeHandlers.MessageTypeLeaderAck;
import MessageHandler.MessageTypeHandlers.IMessageTypeHandler;
import Logger.*;

public class SimpleMessageHandler implements IMessageHandler
{

    private ILogger _logger;
    public SimpleMessageHandler(ILogger logger)
    {
        _logger = logger;
    }
    public void handle(IMessage message)
    {
        _pickTypeHandler(message.type()).handle(message);
    }

    private IMessageTypeHandler _pickTypeHandler(String type)
    {
        switch(type)
        {
        case "LeaderAck":
            return new MessageTypeLeaderAck(_logger);

        default:
            return new MessageTypeLeaderAck(_logger);
        }

    }
}