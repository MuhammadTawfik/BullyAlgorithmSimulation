package WorkerProcessRegistry;


interface IWorkerRegistry {
  public void register(String processID);
  public  String[] listRegistered();
}