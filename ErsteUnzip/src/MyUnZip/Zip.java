package MyUnZip;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Zip {
	private File zipFile;
	private String zipElement;
	private String targetFolder;

	public Zip(File zipFile, String zipElement, String targetFolder) {
		super();
		this.zipFile = zipFile;
		this.zipElement = zipElement;
		this.targetFolder = targetFolder;
	}

	public Zip(String zipElement) {
		this.zipElement = zipElement;
	}

	public File getZipFile() {
		return zipFile;
	}

	public void setZipFile(File zipFile) {
		this.zipFile = zipFile;
	}

	public String getZipElement() {
		return zipElement;
	}

	public void setZipElement(String zipElement) {
		this.zipElement = zipElement;
	}

	public String getTargetFolder() {
		return targetFolder;
	}

	public void setTargetFolder(String targetFolder) {
		this.targetFolder = targetFolder;
	}

	@Override
	public String toString() {
		return "Zip [zipFile=" + zipFile + ", zipElement=" + zipElement + ", targetFolder=" + targetFolder + "]";
	}

	public static List<Zip> getList(List<String> list) {
		List<Zip> file2 = new ArrayList<>();
		for (String object : list) {
			file2.add(new Zip(object));
		}
		return file2;
	}

	public void setDataIfExist(boolean founded, File zipFile, String targetFolder) {
		if (founded) {
			this.zipFile = zipFile;
			this.targetFolder = targetFolder;
		}
	}

}
