package com.mantra.manager;

import java.util.logging.Logger;

import com.mantra.model.Data;
import com.mantra.model.ExportData;
import com.mantra.util.FilenameConstants;

import MFS100.FingerData;
import MFS100.MFS100Event;

public abstract class FingerPrintEventManager implements MFS100Event {
	private static final Logger LOG = Logger.getLogger(FingerPrintEventManager.class.getName());

	public FingerPrintEventManager() {
	}

	@Override
	public void OnCaptureCompleted(boolean arg0, int arg1, String arg2, FingerData fingerData) {
		LOG.info("Inside OnCaptureCompleted");
		capturedData(getExportData(fingerData));
	}

	@Override
	public void OnPreview(FingerData fingerData) {
	}

	public ExportData getExportData(FingerData fingerData) {
		ExportData exportData = new ExportData();
		exportData.setAnsiTemplateData(getData(fingerData.ANSITemplate(), FilenameConstants.ANSI_TEMPLATE));
		exportData.setIsoTemplateData(getData(fingerData.ISOImage(), FilenameConstants.ISO_TEMPLATE));
		exportData.setIsoImageData(getData(fingerData.ISOImage(), FilenameConstants.ISO_IMAGE));
		exportData.setBmpData(getData(fingerData.FingerImage(), FilenameConstants.BMP));
		exportData.setRawData(getData(fingerData.RawData(), FilenameConstants.RAW));
		exportData.setWsqData(getData(fingerData.WSQImage(), FilenameConstants.WSQ));
		return exportData;
	}

	private Data getData(byte[] data, String filename) {
		Data templateData = new Data();
		templateData.setData(data);
		templateData.setFilename(filename);
		return templateData;
	}

	public abstract void capturedData(ExportData exportData);
}
