package MessageHandler.MessageTypeHandlers;

import LeaderStatusManagment.*;
import Logger.*;
import Mailer.*;
import WorkerProcessRegistry.*;

public class MessageTypeLeadershipRecAck implements IMessageTypeHandler
{

    private IMailerClient _mailer;
    private ILogger _logger;
    private ILeaderStatusManager _lsm;

    public MessageTypeLeadershipRecAck(ILeaderStatusManager lsm, IMailerClient mailer, ILogger logger)
    {
        _logger = logger;
        _mailer = mailer;
        _lsm = lsm;
    }
    public void handle(IMessage message)
    {

        if(Integer.parseInt(message.sender()) > Integer.parseInt(_lsm.getLeader()))
        {
            _lsm.setLeader(message.sender());
        }
        _lsm.setElectionStatus(false);

    }
}