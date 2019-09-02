package com.mantra.manager;

import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;

import com.mantra.model.ScannedData;

import MFS100.FingerData;
import MFS100.MFS100Event;

public final class FingerPrintEventManager implements MFS100Event {
	private static final Logger LOG = Logger.getLogger(FingerPrintEventManager.class.getName());
	private final ScannedData scannedData;
	private FingerData fingerData;

	public FingerPrintEventManager() {
		LOG.info("Initialized scanned data!");
		scannedData = new ScannedData();
	}

	@Override
	public void OnCaptureCompleted(boolean arg0, int arg1, String arg2, FingerData fingerData) {
		LOG.info("Inside OnCaptureCompleted");
		byte[] fingerPrintData = fingerData.ANSITemplate();
		String encodedScannedData = Base64.encodeBase64String(fingerPrintData);

		scannedData.setFingerPrintData(fingerPrintData);
		scannedData.setEncodedScannedData(encodedScannedData);
		this.fingerData = fingerData;
		
		LOG.info("Scanned finger data: " + encodedScannedData);
	}

	@Override
	public void OnPreview(FingerData fingerData) {
	}

	public FingerData getFingerData() {
		return fingerData;
	}

	public ScannedData getScannedData() {
		return scannedData;
	}

}
