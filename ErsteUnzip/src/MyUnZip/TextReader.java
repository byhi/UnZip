package MyUnZip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

public class TextReader {
	final static Logger logger = Logger.getLogger(TextReader.class);
	List<String> fileList;
	
//	
	
	public TextReader(String fileName) {
		super();
		this.fileList = new LinkedList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.equals("")) this.fileList.add(line);
			}
			br.close();
		} catch ( java.io.IOException e) {
			 logger.error("File not exist or incorrect! . . . " + fileName, e );			
			this.fileList = null;
		}
	}

	@Override
	public String toString() {
		String text = "";
		StringBuffer br = new StringBuffer(text);
		for (String str : fileList) {
			br.append("TextReader [fileList=" + str + "] \n") ;
		}		
		return text.equals("") ? text : "File is empty!";	
	}

	public List<String> getList()  {
		return this.fileList;
	}

	public static List<String> getListFromFile(String fileName) {
		LinkedList<String> fileList = new LinkedList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {			
				if (!line.equals("")) fileList.add(line);
			}

		} catch ( java.io.IOException e) {
			 logger.error("File not exist! . . . " + fileName, e );			
		}
			
		return fileList;
	}



	
	

}
