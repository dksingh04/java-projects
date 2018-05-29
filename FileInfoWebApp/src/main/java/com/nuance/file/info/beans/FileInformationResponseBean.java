package com.nuance.file.info.beans;

public class FileInformationResponseBean extends GenericResponseBean{
	
	private String fullPath;
	private String fileSize;
	private boolean isHidden;
	private boolean isExecutable;
	private String lastUpdateDate;
	private boolean isWritePermission;
	private boolean isReadPermission;
	private String fileName;

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	public boolean isExecutable() {
		return isExecutable;
	}

	public void setExecutable(boolean isExecutable) {
		this.isExecutable = isExecutable;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public boolean isWritePermission() {
		return isWritePermission;
	}

	public void setWritePermission(boolean isWritePermission) {
		this.isWritePermission = isWritePermission;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isReadPermission() {
		return isReadPermission;
	}

	public void setReadPermission(boolean isReadPermission) {
		this.isReadPermission = isReadPermission;
	}

}
