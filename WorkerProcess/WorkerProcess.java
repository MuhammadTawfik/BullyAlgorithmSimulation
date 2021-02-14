import Logger.SimpleFileLogger;
import Mailer.SimpleFileMailer;
import Mailer.SimpleStringMessage;
public class WorkerProcess {
	public static void main(String[] args) {
		// SimpleFileLogger logger = new SimpleFileLogger("/home/tawfik/BullyAlgorithmSimulation/data/logs");
    // logger.info(ProcessHandle.current().pid() + "");

    SimpleFileMailer mailer = new SimpleFileMailer(ProcessHandle.current().pid() + "");
SimpleStringMessage message = new SimpleStringMessage("anything for now", ProcessHandle.current().pid() + "" , "content", "test");
  mailer.send(message);
	}
}