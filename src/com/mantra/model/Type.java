package com.mantra.model;

public enum Type {
	isoTemplate(".iso"), isoImage(".iso"), ansi(".ansi"), raw(".raw"), bmp(".bmp"), wsq(".wsq");

	private String extension;

	private Type(String extension) {
		this.extension = extension;
	}

	public String getExtension() {
		return extension;
	}
}
