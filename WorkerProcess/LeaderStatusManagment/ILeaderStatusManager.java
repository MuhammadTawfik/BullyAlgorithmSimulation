package LeaderStatusManagment;


public interface ILeaderStatusManager {
  public boolean iAmLeader();
  public boolean leaderExists();
  public String getLeader();
  public void setLeader(String leader);
  public void setLastSeen(java.util.Date lastSeen);
  public boolean isElectionRunning();
  public void setElectionStatus(boolean running); 
}