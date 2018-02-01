package MyUnZip;

import org.apache.log4j.Logger;

public class UnZipMain {
	final static Logger logger = Logger.getLogger(UnZipMain.class);

	public static void main(String[] args) {
		
		if (inputIsCorrect(args)) {
			UnZipController.execute(args[0], args[1]);
		}
	}
	
	private static boolean inputIsCorrect(String[] args) {
		boolean isCorrect = true;
		if (args.length == 0) {
			logger.warn("Missing input parameters ! ");
			isCorrect = false;
		} else {
			if (args[0].equals("") && args[0] != null) {
				logger.warn("Value of directory is not correct! . . . " + args[0]);
				isCorrect = false;
			}
			if (args[1].equals("") && args[1] != null) {
				logger.warn("Value is not correct! . . . " + args[1]);
				isCorrect = false;
			}
		}
		return isCorrect;
	}
}