package LeaderStatusManagment;


public class LeaderStatusManager implements ILeaderStatusManager {
	private String leaderID; 
	private java.util.Date _LeaderlastSeen; 
	private boolean electionRunning = false;
	private int _leaderDelayThreshold = 2000;
  public boolean iAmLeader(){
  	// return (leaderID == (ProcessHandle.current().pid() + ""));
    return true;
  }

  public boolean leaderExists(){
  	if(leaderID == null) {return false;}
  		java.util.Date timeNow = new java.util.Date();
  	return (Math.abs(timeNow.getTime() - _LeaderlastSeen.getTime()) >  _leaderDelayThreshold);
  }

  public String getLeader() {
  	return leaderID;
  }

  public void setLastSeen(java.util.Date lastSeen){
  	_LeaderlastSeen = lastSeen;
  }

  public boolean isElectionRunning() {
  	return electionRunning;
  }

  public void setElectionStatus(boolean running) {
  	electionRunning = running;
  }

}