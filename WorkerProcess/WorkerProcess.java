import Logger.SimpleFileLogger;
import Mailer.SimpleFileMailer;
import Mailer.SimpleStringMessage;
import WorkerProcessRegistry.FileWorkerRegistry;
import LeaderStatusManagment.*;
import MessageHandler.*;
import BackgroundWorkers.*;
public class WorkerProcess {
	public static void main(String[] args) {
		SimpleFileLogger logger = new SimpleFileLogger("/home/tawfik/BullyAlgorithmSimulation/data/logs/" + ProcessHandle.current().pid() + "");
    LeaderStatusManager leaderStatusManager = new LeaderStatusManager();
    // logger.info(ProcessHandle.current().pid() + "");

    SimpleFileMailer mailer = new SimpleFileMailer("/home/tawfik/BullyAlgorithmSimulation/data/mails/",ProcessHandle.current().pid() + "");
// SimpleStringMessage message = new SimpleStringMessage("anything for now", ProcessHandle.current().pid() + "" , "content", "test");
  // mailer.send(message);
    FileWorkerRegistry registry = FileWorkerRegistry.getInstance();
    registry.register(ProcessHandle.current().pid() + "");

// System.out.println("eeeeeeeeee" + f.listRegistered());
// (new SimpleMessageHandler(logger)).handle(message);

    LeaderHealthChecker k = new LeaderHealthChecker(leaderStatusManager, logger);
    Thread t1 =new Thread(k);
    t1.start(); 
	}
}