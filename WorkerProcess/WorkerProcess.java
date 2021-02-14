import Logger.SimpleFileLogger;

public class WorkerProcess {
	public static void main(String[] args) {
		SimpleFileLogger logger = new SimpleFileLogger("/home/tawfik/test/m.txt");
    logger.info("testtesttestttestteestttteestttst");
	}
}