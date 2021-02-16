package MessageHandler;

import MessageHandler.MessageTypeHandlers.*;
import LeaderStatusManagment.*;
import Logger.*;
import Mailer.*;
import WorkerProcessRegistry.*;

public class SimpleMessageHandler implements IMessageHandler
{

    private ILogger _logger;
    private IMailerClient _mailer;
    private IWorkerRegistry _registry;
    private ILeaderStatusManager _lsm;
    public SimpleMessageHandler(ILeaderStatusManager lsm, ILogger logger, IMailerClient mailer, IWorkerRegistry registry)
    {
        _lsm = lsm;
        _logger = logger;
        _mailer = mailer;
        _registry = registry;
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
            return new MessageTypeLeaderAck(_lsm, _logger);
        case "ProbableLeader":
            return new MessageTypeProbableLeader(_lsm, _mailer, _logger);
        case "LeadershipRecAck":
            return new MessageTypeLeadershipRecAck(_lsm, _mailer, _logger);
        default:
            return new MessageTypeLeaderAck(_lsm, _logger);
        }

    }
}