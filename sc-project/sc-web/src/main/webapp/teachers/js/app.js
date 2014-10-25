var app = angular.module('teachers', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'html/teacherList.html',
		controller : 'TeacherListController',
		controllerAs : 'teacherCtrl'
	}).when('/:id', {
		templateUrl : 'html/teacherProfile.html',
		controller : 'TeacherProfileController',
		controllerAs : 'teacherCtrl'
	});

	}])

app.controller('TeacherListController', ['$http', function($http) {
	var ctrl = this;
	$http.get('/sc-web/rest/teachers')
		.success(function(data){
			ctrl.teachers = data;
		});
//		.error(function(data){
//		});
}]);

app.controller('TeacherProfileController', function($http, $routeParams) {
	var ctrl = this;
	$http.get('/sc-web/rest/teachers/' + $routeParams.id)
	.success(function(data){
		ctrl.teacher = data;
	});
});
