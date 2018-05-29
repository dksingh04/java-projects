package com.nuance.file.info.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.nuance.file.info.beans.DirPathInfoResponseBean;
import com.nuance.file.info.beans.FileInformationResponseBean;
import com.nuance.file.info.beans.FileOrDirInformation;
import com.nuance.file.info.constant.PathInformationConstant;

public class FileOrDirInfoUtil {

	/**
	 * The method will return full description of given file in the path.
	 * 
	 * @param path
	 * @return FileInformationResponseBean
	 */

	public static FileInformationResponseBean getFileInformation(String path) {

		FileInformationResponseBean response = getPathFileDescription(path);
		return response;
	}

	/**
	 * The method will return descriptions of all the files and directories
	 * (recursively) for the given path to directory.
	 * 
	 * @param path
	 * @return DirPathInfoResponseBean
	 */
	public static DirPathInfoResponseBean getDirPathInformaition(String path) {
		List<FileOrDirInformation> pathInformation = new ArrayList<FileOrDirInformation>();
		DirPathInfoResponseBean response = getDirSubDirAndFileInformation(path,
				pathInformation);
		return response;
	}

	private static DirPathInfoResponseBean getDirSubDirAndFileInformation(
			String path, List<FileOrDirInformation> pathInformation) {

		DirPathInfoResponseBean response = new DirPathInfoResponseBean();
		File directory = new File(path);
		
		if (directory.exists() && directory.isDirectory()) {

			File[] fileList = directory.listFiles();

			for (File file : fileList) {
				FileOrDirInformation fileInfo = new FileOrDirInformation();
				if (file.isFile()) {

					fileInfo.setDir(false);
					fileInfo.setFileSize(String.valueOf(file.length()));
					fileInfo.setFullPath(file.getAbsolutePath());
					fileInfo.setFileName(file.getName());
					pathInformation.add(fileInfo);

				} else if (file.isDirectory()) {

					fileInfo.setDir(true);
					fileInfo.setFullPath(file.getAbsolutePath());
					fileInfo.setFileName(file.getName());
					pathInformation.add(fileInfo);
					
					getDirSubDirAndFileInformation(file.getAbsolutePath(),
							pathInformation);
				}

			}

			response.setPathInformation(pathInformation);
			response.setRespStatusCode(PathInformationConstant.SUCCESS_CODE);
			response.setMessage(PathInformationConstant.SUCCESS);
		} else {

			response.setRespStatusCode(PathInformationConstant.FAILURE_CODE);
			response.setMessage(PathInformationConstant.FAILURE);
			response.setErrorCode(PathInformationConstant.FOLDER_DOES_NOT_EXIST_CODE);
			response.setErrorDesc(PathInformationConstant.FOLDER_DOES_NOT_EXIST);
		}

		return response;
	}

	private static FileInformationResponseBean getPathFileDescription(
			String path) {
		FileInformationResponseBean response = new FileInformationResponseBean();
		File file = new File(path);
		if (file.exists() && file.isFile()) {

			response.setFileName(file.getName());
			response.setFileSize(String.valueOf(file.length()));
			response.setFullPath(file.getAbsolutePath());
			response.setExecutable(file.canExecute());
			response.setWritePermission(file.canWrite());
			response.setReadPermission(file.canRead());
			response.setHidden(file.isHidden());
			response.setLastUpdateDate(String.valueOf(file.lastModified()));
			response.setRespStatusCode(PathInformationConstant.SUCCESS_CODE);
			response.setMessage(PathInformationConstant.SUCCESS);

		} else {

			response.setRespStatusCode(PathInformationConstant.FAILURE_CODE);
			response.setMessage(PathInformationConstant.FAILURE);
			response.setErrorCode(PathInformationConstant.FILE_DOES_NOT_EXIST_CODE);
			response.setErrorDesc(PathInformationConstant.FILE_DOES_NOT_EXIST);
		}
		return response;
	}

}
