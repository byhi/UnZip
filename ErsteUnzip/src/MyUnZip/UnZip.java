package MyUnZip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.log4j.Logger;

public class UnZip {
	final static Logger logger = Logger.getLogger(UnZip.class);


	public static List<String> getFileListFromZip(String filename) {
		List<String> result = new ArrayList<String>();

		try {
			File folder = new File(filename);
			if (!folder.exists()) {
				folder.mkdir();
			} else {
				ZipInputStream zis = new ZipInputStream( new FileInputStream(filename),Charset.forName("ISO-8859-2"));
				ZipEntry ze = zis.getNextEntry();

				while (ze != null) {
					result.add(ze.getName());	
						ze = zis.getNextEntry();					
				}
				zis.closeEntry();
				zis.close();

			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("File not exist! . . . " + filename, e);
		}
		return result;
	}

	public static void decompressionFile(Zip file) {
		byte[] buffer = new byte[2048];

		try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file.getZipFile()))) {

			ZipEntry ze = zis.getNextEntry();

			while (ze != null) {
				File newFile = new File(file.getTargetFolder() + File.separator + file.getZipElement());
				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();
				ze = zis.getNextEntry();
			}

		} catch (IOException e) {
			logger.error("File not exist! . . . " + file.getZipElement(), e);
		}
	}

	public static void decompressionAllFile(List<Zip> file2) {
		for (Zip file : file2) {
			decompressionFile(file);
		}
	}
}