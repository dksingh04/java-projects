package com.nuance.file.info.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.nuance.file.info.beans.DirPathInfoResponseBean;
import com.nuance.file.info.beans.FileInformationResponseBean;
import com.nuance.file.info.service.IFileOrDirInformationService;
import com.nuance.file.info.util.FileOrDirInfoUtil;

@Service
public class FileOrDirInformationServiceImpl implements
		IFileOrDirInformationService {
	final static Logger logger = Logger
			.getLogger(FileOrDirInformationServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nuance.file.info.service.IFileOrDirInformationService#getPathInformation
	 * (java.lang.String)
	 */
	public DirPathInfoResponseBean getPathInformation(String path) {

		logger.info("Entry getPathInformation method with Path : " + path);

		DirPathInfoResponseBean response = FileOrDirInfoUtil
				.getDirPathInformaition(path);

		logger.info("Exit getPathInformation method with Path : " + path);

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nuance.file.info.service.IFileOrDirInformationService#getFileInformation
	 * (java.lang.String)
	 */
	public FileInformationResponseBean getFileInformation(String path) {

		logger.info("Entry getFileInformation method with Path : " + path);

		FileInformationResponseBean response = FileOrDirInfoUtil
				.getFileInformation(path);

		logger.info("Exit getFileInformation method with Path : " + path);
		return response;

	}
}
