package MyUnZip;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

public class UnZipController {

	private static boolean isFeasible = true;
	private static List<Zip> fileList;
	private static List<ZipMap> zips;
	private static File folder;
	final static Logger logger = Logger.getLogger(UnZipController.class);
	

	public static void execute(String textFile, String directory) {
		folder = new File(directory);
		if (!folder.exists()) {
			logger.warn("Directory not exist! . . . " + folder.getAbsolutePath());
		} else {
			zips = ZipMap.getMap(FileSeeker.getFileList(folder));
			fileList = Zip.getList(TextReader.getListFromFile(textFile));

			if (fileList.size() > 0) {
				searchExistFilesInZips();
				if (isFeasible)
					UnZip.decompressionAllFile(fileList);				
			} else {
				logger.warn("Text file is empty! . . . " + textFile);
			}
		}
	}
	

	private static void searchExistFilesInZips() {
		for (Zip object : fileList) {

			Iterator<ZipMap> i2 = zips.iterator();
			boolean founded = false;
			while (!founded && isFeasible && i2.hasNext()) {
				ZipMap zip = i2.next();
				founded = zip.existInList(object.getZipElement());
				object.setDataIfExist(founded, new File(zip.getFileName()), folder.toString());
			}
			if (!founded){
				isFeasible = false;
				logger.warn("The file was not found! <- " + object);
			}
		}
	}

}
