package BackgroundWorkers;
import LeaderStatusManagment.*;
import Logger.*;
import Mailer.*;
import WorkerProcessRegistry.*;

public class LeaderHealthChecker extends IBackgroundWorker
{

    private ILeaderStatusManager _lsm;
    private ILogger _logger;
    private IMailerClient _mailer;
    private IWorkerRegistry _registry;
    private int timeBetweenHealthChecks = 500;
    private int timeToCheckOnElection = 4000;

    public LeaderHealthChecker(ILeaderStatusManager lsm, ILogger logger, IMailerClient mailer, IWorkerRegistry registry)
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
            if(_lsm.leaderExists())
            {
                _logger.info("leaderExists: " + _lsm.getLeader());
                try
                {
                    Thread.sleep(timeBetweenHealthChecks);
                }
                catch(InterruptedException e) {}
                continue;
            }
            else if(_lsm.isElectionRunning())
            {
                try
                {
                    Thread.sleep(timeToCheckOnElection);
                }
                catch(InterruptedException e) {}
                continue;
            }
            else
            {
                _logger.info("Starting Elections");
                ElectionStarter es = new ElectionStarter(_lsm, _logger, _mailer, _registry);
                es.start();

            }
        }

    }
}