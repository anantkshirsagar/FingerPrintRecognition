package com.mantra.model;

public class ExportData {
	private Data isoTemplateData;
	private Data bmpData;
	private Data isoImageData;
	private Data ansiTemplateData;
	private Data rawData;
	private Data wsqData;

	public Data getIsoTemplateData() {
		return isoTemplateData;
	}

	public void setIsoTemplateData(Data isoTemplateData) {
		this.isoTemplateData = isoTemplateData;
	}

	public Data getBmpData() {
		return bmpData;
	}

	public void setBmpData(Data bmpData) {
		this.bmpData = bmpData;
	}

	public Data getIsoImageData() {
		return isoImageData;
	}

	public void setIsoImageData(Data isoImageData) {
		this.isoImageData = isoImageData;
	}

	public Data getAnsiTemplateData() {
		return ansiTemplateData;
	}

	public void setAnsiTemplateData(Data ansiTemplateData) {
		this.ansiTemplateData = ansiTemplateData;
	}

	public Data getRawData() {
		return rawData;
	}

	public void setRawData(Data rawData) {
		this.rawData = rawData;
	}

	public Data getWsqData() {
		return wsqData;
	}

	public void setWsqData(Data wsqData) {
		this.wsqData = wsqData;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExportData [isoTemplateData=");
		builder.append(isoTemplateData);
		builder.append(", bmpData=");
		builder.append(bmpData);
		builder.append(", isoImageData=");
		builder.append(isoImageData);
		builder.append(", ansiTemplateData=");
		builder.append(ansiTemplateData);
		builder.append(", rawData=");
		builder.append(rawData);
		builder.append(", wsqData=");
		builder.append(wsqData);
		builder.append("]");
		return builder.toString();
	}
}
