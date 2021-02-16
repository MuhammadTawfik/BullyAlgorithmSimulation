package MessageHandler.MessageTypeHandlers;

import LeaderStatusManagment.*;
import Logger.*;
import Mailer.*;
import WorkerProcessRegistry.*;

public class MessageTypeProbableLeader implements IMessageTypeHandler
{

    private IMailerClient _mailer;
    private ILogger _logger;
    private ILeaderStatusManager _lsm;

    public MessageTypeProbableLeader(ILeaderStatusManager lsm, IMailerClient mailer, ILogger logger)
    {
        _logger = logger;
        _mailer = mailer;
        _lsm = lsm;
    }
    public void handle(IMessage message)
    {
        SimpleStringMessage msg = new SimpleStringMessage(ProcessHandle.current().pid() + "", message.sender(), " ", "LeadershipRecAck");
        _mailer.send(msg);
    }
}