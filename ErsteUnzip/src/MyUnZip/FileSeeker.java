package MyUnZip;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileSeeker {
	final static Logger logger = Logger.getLogger(FileSeeker.class);
	
	public static List<File> getFileList(final File folder) {
		List<File> list = new LinkedList<File>();
		try {
			for (final File fileEntry : folder.listFiles()) {
				  if (fileEntry.isDirectory()) {
					  getFileList(fileEntry);
			        } else {
			        	if (isZip(fileEntry)) list.add(fileEntry);
			        }
			}
		} catch (NullPointerException e) {
			 logger.error("File not exist or incorre! . . . " + folder.getName(), e );		
		}
		
		return list;
	}
	
	public static String getExtension(File fileEntry){
		return fileEntry.getName().substring(fileEntry.getName().lastIndexOf('.') + 1, fileEntry.getName().length());
	}
	
	public static boolean isZip(File fileEntry){
		return getExtension(fileEntry).equals("zip");
	}
}
