package dataProvider;

import java.io.File;
import java.io.IOException;

public class DataProviderPath {

	/*
	 * get path from Folder
	 * @param : fileName
	 */
	public String getPropertiesFile(String nameFile) throws IOException {
		String path = System.getProperty("user.dir") + File.separator + "src" 
					  + File.separator + "test" +  File.separator +"resources" +  File.separator + nameFile;
		return path;
	}
}
