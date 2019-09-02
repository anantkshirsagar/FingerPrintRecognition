package com.mantra.util;

import com.mantra.model.DeviceInformation;

import MFS100.MFS100;

public class DeviceInfoUtils {
	
	private DeviceInfoUtils() {

	}

	/**
	 * DeviceInfoUtils.getDeviceInformation method returns DeviceInformation
	 * 
	 * @param mfs
	 * @return DeviceInformation
	 */
	public static DeviceInformation getDeviceInformation(MFS100 mfs) {
		DeviceInformation deviceInformation = new DeviceInformation();
		deviceInformation.setConnected(mfs.IsConnected());
		deviceInformation.setVersion(mfs.GetSDKVersion());
		return deviceInformation;
	}
}
