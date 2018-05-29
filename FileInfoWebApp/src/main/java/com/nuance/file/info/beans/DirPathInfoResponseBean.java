package com.nuance.file.info.beans;

import java.util.List;

public class DirPathInfoResponseBean extends GenericResponseBean{
	List<FileOrDirInformation> pathInformation;

	public List<FileOrDirInformation> getPathInformation() {
		return pathInformation;
	}

	public void setPathInformation(List<FileOrDirInformation> pathInformation) {
		this.pathInformation = pathInformation;
	}
	

}
