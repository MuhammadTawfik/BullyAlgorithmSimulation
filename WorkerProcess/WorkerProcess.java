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
        // logger.info(ProcessHandle.current().pid() + "");
        SimpleFileMailer mailer = new SimpleFileMailer("/home/tawfik/BullyAlgorithmSimulation/data/mails/", ProcessHandle.current().pid() + "");
        FileWorkerRegistry registry = FileWorkerRegistry.getInstance();

        SimpleMessageHandler smh = new SimpleMessageHandler(leaderStatusManager, logger, mailer, registry);

        // SimpleStringMessage message = new SimpleStringMessage("anything for now", ProcessHandle.current().pid() + "" , "content", "test");
        // mailer.send(message);
        String _inboxFilePath = "/home/tawfik/BullyAlgorithmSimulation/data/mails/" + ProcessHandle.current().pid() + ".inbox" ;

        registry.register(ProcessHandle.current().pid() + "");
        Inbox inbox = new Inbox(_inboxFilePath, smh);
        inbox.start();
        // System.out.println("eeeeeeeeee" + f.listRegistered());
        // (new SimpleMessageHandler(logger)).handle(message);

        // ElectionStarter k = new ElectionStarter(leaderStatusManager, logger, mailer, registry);
        // k.start();
        // Thread t1 =new Thread(k);
        // t1.start();
    }
}