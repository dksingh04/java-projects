package com.nuance.file.info.service;

import com.nuance.file.info.beans.DirPathInfoResponseBean;
import com.nuance.file.info.beans.FileInformationResponseBean;

public interface IFileOrDirInformationService {
	
	/**
	 * The method will return descriptions of all the files and directories (recursively)
	 * for the given path to directory.
	 * 
	 * @param path
	 * @return DirPathInfoResponseBean
	 */
	public DirPathInfoResponseBean getPathInformation(
			String path);
	
	/**
	 * The method will return full description of given file in the path.
	 * @param path
	 * @return FileInformationResponseBean
	 */
	public FileInformationResponseBean getFileInformation(
			String path);
}
