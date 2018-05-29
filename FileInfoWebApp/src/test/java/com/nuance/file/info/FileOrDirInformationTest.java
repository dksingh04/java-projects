package com.nuance.file.info;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;

import com.nuance.file.info.beans.DirPathInfoResponseBean;
import com.nuance.file.info.beans.FileInformationResponseBean;
import com.nuance.file.info.beans.FileOrDirInformation;
import com.nuance.file.info.constant.PathInformationConstant;
import com.nuance.file.info.service.IFileOrDirInformationService;

/**
 * Unit test for simple App.
 */

public class FileOrDirInformationTest extends TestCase {

	private Mockery context;
	private IFileOrDirInformationService fileOrDirInfoService;

	@Before
	public void setup() {

		context = new JUnit4Mockery();
		fileOrDirInfoService = context.mock(IFileOrDirInformationService.class);
	}

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public FileOrDirInformationTest(String testName) {
		super(testName);

	}

	// Writing test cases using Mock just for the usage of Jmock framework,
	// otherwise this test case doesn't make any sense and not executing the
	// part of code where actual logic of File Information retrieval code is
	// written.

	public void testDirInformationWhenCorrectFolderPathIsPassed() {
		setup();
		final DirPathInfoResponseBean response = createDirPathInfoResponseBeanWhenCorrectFolderPath();

		context.checking(new Expectations() {
			{
				oneOf(fileOrDirInfoService).getPathInformation("C:\\TEST");
				will(returnValue(response));

			}
		});

		assertNotNull(response);
		assertTrue(response.getPathInformation().size() == 1);
		assertEquals(PathInformationConstant.SUCCESS_CODE,
				response.getRespStatusCode());
		assertEquals(PathInformationConstant.SUCCESS, response.getMessage());

	}

	public void testDirInformationWhenInCorrectFolderPathIsPassed() {
		setup();
		final DirPathInfoResponseBean response = createDirPathInfoResponseBeanWhenInCorrectFolderPath();
		context.checking(new Expectations() {
			{
				oneOf(fileOrDirInfoService).getPathInformation(
						"C:\\TEST\\test.txt");
				will(returnValue(response));

			}
		});

		assertNotNull(response);
		assertTrue(response.getPathInformation().size() == 0);
		assertEquals(PathInformationConstant.FAILURE_CODE,
				response.getRespStatusCode());
		assertEquals(PathInformationConstant.FAILURE, response.getMessage());
		assertEquals(PathInformationConstant.FOLDER_DOES_NOT_EXIST_CODE,
				response.getErrorCode());

	}

	public void testFileInformationWhenCorrectFilePathIsPassed() {
		setup();
		final FileInformationResponseBean response = createFilePathInfoResponseBeanWhenCorrectFilePath();
		context.checking(new Expectations() {
			{
				oneOf(fileOrDirInfoService).getPathInformation(
						"C:\\TEST\\test.txt");
				will(returnValue(response));

			}
		});

		assertNotNull(response);

		assertEquals(PathInformationConstant.SUCCESS_CODE,
				response.getRespStatusCode());
		assertEquals(PathInformationConstant.SUCCESS, response.getMessage());
		assertFalse(response.isHidden());
		assertTrue(response.isExecutable());

	}
	
	public void testFileInformationWhenInCorrectFilePathIsPassed(){
		setup();
		final FileInformationResponseBean response = createFilePathInfoResponseBeanWhenInCorrectFilePath();
		context.checking(new Expectations() {
			{
				oneOf(fileOrDirInfoService).getPathInformation(
						"C:\\TEST");
				will(returnValue(response));

			}
		});

		assertNotNull(response);

		assertEquals(PathInformationConstant.FAILURE_CODE,
				response.getRespStatusCode());
		assertEquals(PathInformationConstant.FAILURE, response.getMessage());
		assertEquals(PathInformationConstant.FILE_DOES_NOT_EXIST_CODE, response.getErrorCode());
		

	}

	private DirPathInfoResponseBean createDirPathInfoResponseBeanWhenCorrectFolderPath() {

		DirPathInfoResponseBean response = new DirPathInfoResponseBean();
		List<FileOrDirInformation> pathInformation = new ArrayList<FileOrDirInformation>();
		FileOrDirInformation fileOrDirInfo = new FileOrDirInformation();
		fileOrDirInfo.setDir(true);
		fileOrDirInfo.setFileName("TEST");
		fileOrDirInfo.setFileSize("245");
		fileOrDirInfo.setFullPath("C:\\TEST");
		pathInformation.add(fileOrDirInfo);

		response.setPathInformation(pathInformation);
		response.setMessage(PathInformationConstant.SUCCESS);
		response.setRespStatusCode(PathInformationConstant.SUCCESS_CODE);

		return response;

	}

	private DirPathInfoResponseBean createDirPathInfoResponseBeanWhenInCorrectFolderPath() {

		DirPathInfoResponseBean response = new DirPathInfoResponseBean();
		List<FileOrDirInformation> pathInformation = new ArrayList<FileOrDirInformation>();

		response.setPathInformation(pathInformation);
		response.setMessage(PathInformationConstant.FAILURE);
		response.setRespStatusCode(PathInformationConstant.FAILURE_CODE);
		response.setErrorCode(PathInformationConstant.FOLDER_DOES_NOT_EXIST_CODE);
		response.setErrorDesc(PathInformationConstant.FOLDER_DOES_NOT_EXIST);

		return response;

	}

	private FileInformationResponseBean createFilePathInfoResponseBeanWhenCorrectFilePath() {
		FileInformationResponseBean response = new FileInformationResponseBean();
		response.setFileName("test.txt");
		response.setExecutable(true);
		response.setFileSize("456");
		response.setFullPath("C:\\TEST\\test.txt");
		response.setLastUpdateDate("7678678");
		response.setHidden(false);
		response.setReadPermission(true);
		response.setWritePermission(false);
		response.setRespStatusCode(PathInformationConstant.SUCCESS_CODE);
		response.setMessage(PathInformationConstant.SUCCESS);

		return response;
	}

	private FileInformationResponseBean createFilePathInfoResponseBeanWhenInCorrectFilePath() {
		FileInformationResponseBean response = new FileInformationResponseBean();

		response.setRespStatusCode(PathInformationConstant.FAILURE_CODE);
		response.setMessage(PathInformationConstant.FAILURE);
		response.setErrorCode(PathInformationConstant.FILE_DOES_NOT_EXIST_CODE);
		response.setErrorDesc(PathInformationConstant.FILE_DOES_NOT_EXIST);

		return response;
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {

		return new TestSuite(FileOrDirInformationTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	/*
	 * public void testApp() { assertTrue( true ); }
	 */
}
