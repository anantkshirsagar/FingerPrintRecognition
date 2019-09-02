package com.mantra.model;

import java.util.Arrays;

public class ScannedData {
	private byte[] fingerPrintData;
	private String encodedScannedData;

	public byte[] getFingerPrintData() {
		return fingerPrintData;
	}

	public void setFingerPrintData(byte[] fingerPrintData) {
		this.fingerPrintData = fingerPrintData;
	}

	public String getEncodedScannedData() {
		return encodedScannedData;
	}

	public void setEncodedScannedData(String encodedScannedData) {
		this.encodedScannedData = encodedScannedData;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScannedData [fingerPrintData=");
		builder.append(Arrays.toString(fingerPrintData));
		builder.append(", encodedScannedData=");
		builder.append(encodedScannedData);
		builder.append("]");
		return builder.toString();
	}
}
