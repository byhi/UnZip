package MyUnZip;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZipMap {
	private String fileName;
	private List<String> filesInZip;

	public ZipMap(String fileName, List<String> filesInZip) {
		super();
		this.fileName = fileName;
		this.filesInZip = filesInZip;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getFilesInZip() {
		return filesInZip;
	}

	public void setFilesInZip(List<String> filesInZip) {
		this.filesInZip = filesInZip;
	}

	public void name(String file) {
		this.filesInZip.add(file);
	}

	public boolean existInList(String fileName) {
		ArrayList<String> list = (ArrayList<String>) this.filesInZip;
		return list.contains(fileName);
	}

	public static List<ZipMap> getMap(List<File> list) {
		List<ZipMap> zips = new ArrayList<>();
		Iterator<File> i = list.iterator();
		while (i.hasNext()) {
			String zipName = i.next().getPath();
			zips.add(new ZipMap(zipName, UnZip.getFileListFromZip(zipName)));
		}
		return zips;
	}

	@Override
	public String toString() {
		return "Zip [fileName=" + fileName + ", filesInZip=" + filesInZip + "]";
	}

}
