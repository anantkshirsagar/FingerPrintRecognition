package com.mantra.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import com.mantra.manager.FingerPrintEventManager;

public class FileWriterUtils {
	private static final Logger LOG = Logger.getLogger(FingerPrintEventManager.class.getName());
	
	private FileWriterUtils() {

	}

	public static boolean writeFile(String filename, byte[] data, String folderPath) throws IOException {
		LOG.info("In writeFile!");
		if(folderPath == null || folderPath.isEmpty()){
			throw new FileNotFoundException("Please provide a path!");
		}
		File file = new File(folderPath);
		if (!file.exists()) {
			LOG.warning("Directory created");
			file.mkdir();
		}
		folderPath += File.separator + filename;
		FileOutputStream fos = new FileOutputStream(folderPath);
		fos.write(data);
		LOG.info("File created sucessfully to path: " +folderPath);
		fos.close();
		return true;
	}
}
