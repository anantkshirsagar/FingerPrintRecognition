package com.mantra.model;

public class DeviceInformation {
	private String version;
	private boolean isConnected;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DeviceInformation [version=");
		builder.append(version);
		builder.append(", isConnected=");
		builder.append(isConnected);
		builder.append("]");
		return builder.toString();
	}
}
