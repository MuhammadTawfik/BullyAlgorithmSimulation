package MessageHandler.MessageTypeHandlers;

import LeaderStatusManagment.*;
import Logger.*;
import Mailer.*;
import WorkerProcessRegistry.*;

public class MessageTypeLeaderAck implements IMessageTypeHandler
{

    private ILogger _logger;
    public MessageTypeLeaderAck(ILogger logger)
    {
        _logger = logger;
    }
    public void handle(IMessage message)
    {
        _logger.info("My leader is: " + message.sender());
    }
}