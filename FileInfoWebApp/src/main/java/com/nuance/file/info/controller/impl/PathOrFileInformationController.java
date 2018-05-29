package com.nuance.file.info.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nuance.file.info.beans.DirPathInfoResponseBean;
import com.nuance.file.info.beans.FileInformationResponseBean;
import com.nuance.file.info.controller.IPathOrFileInformationController;
import com.nuance.file.info.service.IFileOrDirInformationService;

@Controller
@RequestMapping("/path-info")
public class PathOrFileInformationController implements
		IPathOrFileInformationController {

	@Autowired
	private IFileOrDirInformationService fileOrDirInformationServiceImpl;

	
	
	/* (non-Javadoc)
	 * @see com.nuance.file.info.controller.IPathOrFileInformationController#getPathInformation(java.lang.String)
	 */
	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/dir")
	public @ResponseBody
	DirPathInfoResponseBean getPathInformation(@RequestParam("dirpath") String path) {

		DirPathInfoResponseBean response = fileOrDirInformationServiceImpl
				.getPathInformation(path);

		return response;
	}

	/* (non-Javadoc)
	 * @see com.nuance.file.info.controller.IPathOrFileInformationController#getFileInformation(java.lang.String)
	 */
	
	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/file")
	public @ResponseBody
	FileInformationResponseBean getFileInformation(
			@RequestParam("path") String path) {
		FileInformationResponseBean response = fileOrDirInformationServiceImpl
				.getFileInformation(path);
		
		return response;
	}

	@Override
	@RequestMapping("/")
	public String loadIndexFile() {
		// TODO Auto-generated method stub
		System.out.println("In LoadIndex File");
		return "index";
	}
}
