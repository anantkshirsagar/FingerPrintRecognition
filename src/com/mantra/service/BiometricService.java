package com.mantra.service;

import java.util.logging.Logger;

import com.mantra.manager.FingerPrintEventManager;
import com.mantra.model.Data;
import com.mantra.model.ExportData;
import com.mantra.util.FilenameConstants;

import MFS100.FingerData;
import MFS100.MFS100;

public class BiometricService {
	private static final Logger LOG = Logger.getLogger(FingerPrintEventManager.class.getName());
	private FingerPrintEventManager fingerPrintEvent;
	private final MFS100 mfs100;

	public BiometricService() {
		fingerPrintEvent = new FingerPrintEventManager();
		mfs100 = new MFS100(getFingerPrintEvent());
		mfs100.Init();
		LOG.info("Scanner initialized!");
	}

	/**
	 * This method is used to capture finger print data. <strong>if</strong>
	 * showPreview is true then it first calls OnPreview() method & after
	 * OnCaptureCompleted() method, <strong>else</strong> OnCaptureCompleted()
	 * method is called.
	 * 
	 * @param quality
	 * @param timeOut
	 * @param showPreview
	 * @return
	 * @throws InterruptedException
	 */
	public int startCapture(int quality, int timeOut, boolean showPreview) {
		LOG.info("In startCapture");
		int status = mfs100.StartCapture(quality, timeOut, showPreview);
		return status;
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

	public int autoCapture(FingerData fingerData, int timeOut, boolean showPreview, boolean isDetectFinger) {
		LOG.info("In autoCapture");
		return mfs100.AutoCapture(fingerData, timeOut, showPreview, isDetectFinger);
	}

	public FingerPrintEventManager getFingerPrintEvent() {
		return fingerPrintEvent;
	}
}
