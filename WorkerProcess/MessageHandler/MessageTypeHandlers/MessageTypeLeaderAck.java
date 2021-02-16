package MessageHandler.MessageTypeHandlers;

import LeaderStatusManagment.*;
import Logger.*;
import Mailer.*;
import WorkerProcessRegistry.*;
import java.text.SimpleDateFormat;

public class MessageTypeLeaderAck implements IMessageTypeHandler
{

    private ILogger _logger;
    private ILeaderStatusManager _lsm;
    public MessageTypeLeaderAck( ILeaderStatusManager lsm, ILogger logger)
    {
        _lsm = lsm;
        _logger = logger;
    }
    public void handle(IMessage message)
    {
        _logger.info("My leader is: " + message.sender());
        _lsm.setLastSeen(message.date());

    }
}