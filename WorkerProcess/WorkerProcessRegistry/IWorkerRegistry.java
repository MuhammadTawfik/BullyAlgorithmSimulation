package WorkerProcessRegistry;


public interface IWorkerRegistry
{
    public void register(String processID);
    public  String[] listRegistered();
}