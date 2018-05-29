var fileDir = angular.module('fileInfoApp', ['ngRoute']);

fileDir.controller('fileController', function ($scope, $http, $route, $routeParams, $location){
    $scope.formData = {};
	$scope.fileInfo = {};
	$scope.$route = $route;
    $scope.$location = $location;
    $scope.$routeParams = $routeParams;
	
    $scope.getFileInfo = function(path){
            $location.path( path );
			//alert("Called");
			
    };
    $scope.getDirInfo = function(path){
        $location.path( path );
		//alert("Called");
		
};
})
.controller('fileDetailController', function($scope, $routeParams, $http){
	//alert("fileDetailController");
	$http.get('/FileInfoWebApp/path-info/file', {params: $scope.formData, cache:false}, 
            {headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'*'
            }}).then(function(response) {
               
				   //console.log(response.data);
				   if (response.status == 200) {
						$scope.fileInfo = response.data;
				  }
              }, function(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
              })
	
})
.controller('dirDetailController', function($scope, $routeParams, $http){
	//alert("fileDetailController");
	$http.get('/FileInfoWebApp/path-info/dir', {params: $scope.formData, cache:false}, 
            {headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin':'*'
            }}).then(function(response) {
               
				   //console.log(response.data);
				   if (response.status == 200) {
						$scope.dirInfo = response.data;
				  }
              }, function(response) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
              })
	
})
.config(function($routeProvider, $locationProvider) {
  $routeProvider
   .when('/file', {
    templateUrl: '/FileInfoWebApp/fileInformation.html',
    controller: 'fileDetailController'
    
  })
  .when('/dir', {
    templateUrl: '/FileInfoWebApp/dirInformation.html',
    controller: 'dirDetailController'
    
  })
  
  });

