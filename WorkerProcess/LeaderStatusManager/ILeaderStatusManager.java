package LeaderStatusManagment;


public interface ILeaderStatusManager {
  public boolean iAmLeader();
  public boolean leaderExists();
  public void setLastSeen(java.util.Date lastSeen);
}