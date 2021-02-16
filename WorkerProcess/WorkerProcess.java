import Logger.SimpleFileLogger;
import Mailer.*;
import WorkerProcessRegistry.FileWorkerRegistry;
import LeaderStatusManagment.*;
import MessageHandler.*;
import BackgroundWorkers.*;
public class WorkerProcess
{
    public static void main(String[] args)
    {
        SimpleFileLogger logger = new SimpleFileLogger("/home/tawfik/BullyAlgorithmSimulation/data/logs/" + ProcessHandle.current().pid() + "");
        LeaderStatusManager leaderStatusManager = new LeaderStatusManager();
        SimpleFileMailer mailer = new SimpleFileMailer("/home/tawfik/BullyAlgorithmSimulation/data/mails/", ProcessHandle.current().pid() + "");
        FileWorkerRegistry registry = FileWorkerRegistry.getInstance();

        SimpleMessageHandler smh = new SimpleMessageHandler(leaderStatusManager, logger, mailer, registry);

        String _inboxFilePath = "/home/tawfik/BullyAlgorithmSimulation/data/mails/" + ProcessHandle.current().pid() + ".inbox" ;

        registry.register(ProcessHandle.current().pid() + "");
        Inbox inbox = new Inbox(_inboxFilePath, smh);
        inbox.start();

        LeaderHealthChecker k = new LeaderHealthChecker(leaderStatusManager, logger, mailer, registry);
        k.start();
    }
}