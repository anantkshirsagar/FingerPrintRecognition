package com.mantra.service;

import java.util.logging.Logger;

import com.mantra.manager.FingerPrintEventManager;

import MFS100.FingerData;
import MFS100.MFS100;

public class BiometricService {
	private static final Logger LOG = Logger.getLogger(BiometricService.class.getName());
	private final MFS100 mfs100;
	
	public BiometricService(FingerPrintEventManager fingerPrintEventManager) {
		mfs100 = new MFS100(fingerPrintEventManager);
		getMfs100().Init();
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
		int status = getMfs100().StartCapture(quality, timeOut, showPreview);
		LOG.info("Status: " +status);
		
		return status;
	}

	public int autoCapture(FingerData fingerData, int timeOut, boolean showPreview, boolean isDetectFinger) {
		LOG.info("In autoCapture");
		return getMfs100().AutoCapture(fingerData, timeOut, showPreview, isDetectFinger);
	}

	public MFS100 getMfs100() {
		return mfs100;
	}
}
