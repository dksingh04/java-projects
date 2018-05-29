1. Run Maven build with goal "package", it will create the FileInfoWebApp.war in target folder.
2. To run Test cases, execute the test case in test Folder.
2. Deploy this war file in tomcat server.
3. Since UI is tested on Chrome and Firefox, Please test application on Chrome and FireFox browsers.
4. On Browser type URL http://localhost:8080/FileInfoWebApp/path-info/
5. On Directory Information Tab input Directory path click on GO button, The UI will display Directory/File Information recursivily in Table.
6. To get File Information go to File Information Tab, input File Path in text box click on GO button, The UI will display File Description.
7. To get the JSON response directly on Browser for Directory use URL http://localhost:8080/FileInfoWebApp/path-info/dir?dirpath=<Path to Directory> 
8. To get the JSON response directly on Browser for File use URL http://localhost:8080/FileInfoWebApp/path-info/file?path=<Path to File>
