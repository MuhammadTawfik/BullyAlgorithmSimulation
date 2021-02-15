package LeaderStatusManagment;


public class LeaderStatusManager implements ILeaderStatusManager {
	private String leaderID; 
	private java.util.Date _LeaderlastSeen; 

  public boolean iAmLeader(){
  	return (leaderID == (ProcessHandle.current().pid() + ""));
  }
  public boolean leaderExists(){
  	return leaderID != null;
  }
  public void setLastSeen(java.util.Date lastSeen){
  	_LeaderlastSeen = lastSeen;
  }

}