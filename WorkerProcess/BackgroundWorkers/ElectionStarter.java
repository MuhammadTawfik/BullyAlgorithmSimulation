package BackgroundWorkers;

import LeaderStatusManagment.*;
import Logger.*;
import Mailer.*;
import WorkerProcessRegistry.*;

public class ElectionStarter extends IBackgroundWorker
{

    private ILeaderStatusManager _lsm;
    private ILogger _logger;
    private IMailerClient _mailer;
    private IWorkerRegistry _registry;
    private int timeToFinishElections = 500;

    public ElectionStarter(ILeaderStatusManager lsm, ILogger logger, IMailerClient mailer, IWorkerRegistry registry)
    {
        _lsm = lsm;
        _logger = logger;
        _mailer = mailer;
        _registry = registry;
    }

    public void run()
    {
        if(!_lsm.leaderExists())
        {
            String [] followers = _registry.listRegistered();
            long selfID =  ProcessHandle.current().pid();
            _lsm.setLeader(selfID + "");
            _lsm.setElectionStatus(true);
            // notify all processes that can be a leader
            for(String follower : followers)
            {
                System.out.println(follower + " : " + (Integer.parseInt(follower) > selfID));
                if(Integer.parseInt(follower) > selfID)
                {
                    SimpleStringMessage message = new SimpleStringMessage(selfID + "", follower,  "", "ProbableLeader");
                    _mailer.send(message);
                }
            }
            // wait for elections to be finished
            try
            {
                Thread.sleep(timeToFinishElections);
            }
            catch(InterruptedException e) {}

            // check wheather some process stepped up or not
            if(_lsm.isElectionRunning())
            {
                _lsm.setElectionStatus(false);
                // do leader work
            }
        }
    }

    public void start()
    {
        Thread t1 = new Thread(this);
        t1.start();
    }
}