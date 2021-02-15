package BackgroundWorkers;

import LeaderStatusManagment.*;
import Logger.*;

public class LeaderHealthChecker extends IBackgroundWorker {

	private ILeaderStatusManager _lsm;
  	private ILogger _logger;
  	private int timeBetweenHealthChecks = 500;
  	private int timeToCheckOnElection = 4000;

    public LeaderHealthChecker(ILeaderStatusManager lsm, ILogger logger) {
    	_lsm = lsm;
    	_logger = logger;
    }

	public void run(){
		while(true) {
			if(_lsm.leaderExists()) {
				_logger.info("leaderExists: " + _lsm.getLeader());
				try {
					Thread.sleep(timeBetweenHealthChecks);
				} catch(InterruptedException e){}
				continue;
			} else if(_lsm.isElectionRunning()){
				try {
					Thread.sleep(timeToCheckOnElection);
				} catch(InterruptedException e){}
				continue;
			}else {
				// run election
			}
		}
	}  
 
}