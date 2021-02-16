package BackgroundWorkers;

import LeaderStatusManagment.*;
import Logger.*;
import Mailer.*;
import WorkerProcessRegistry.*;

public class LeaderChildPinger extends IBackgroundWorker
{

    private ILeaderStatusManager _lsm;
    private ILogger _logger;
    private IMailerClient _mailer;
    private IWorkerRegistry _registry;
    private int timeBetweenPings = 500;

    public LeaderChildPinger(ILeaderStatusManager lsm, ILogger logger, IMailerClient mailer, IWorkerRegistry registry)
    {
        _lsm = lsm;
        _logger = logger;
        _mailer = mailer;
        _registry = registry;
    }

    public void run()
    {
        while(true)
        {
            if(_lsm.iAmLeader())
            {
                String [] followers = _registry.listRegistered();
                System.out.println(followers);
                for(String follower : followers)
                {
                    SimpleStringMessage message = new SimpleStringMessage(ProcessHandle.current().pid() + "", follower,  "", "LeaderAck");
                    _mailer.send(message);
                }

                try
                {
                    Thread.sleep(timeBetweenPings);
                }
                catch(InterruptedException e) {}
                continue;
            }
        }
    }
}