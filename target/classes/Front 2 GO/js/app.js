var app = angular.module('myApp', ['ngRoute']);


app.config (function ($routeProvider) {
    $routeProvider
        .when('/home', {
            templateUrl:'pages/home.html',
            controller: 'homeCtrl'
        })
        .when('/ambulatorium', {
            templateUrl: 'pages/ambulatorium.html',
            controller: 'ambulatoriumCtrl'
        })
        .when('/medycynaPracy', {
            templateUrl: 'pages/medycynaPracy.html',
            controller: 'medycynaPracyCtrl'
        })
        .when('/home1', {
            templateUrl: 'pages/home1.html',
            controller: 'home1Ctrl'
        })



});
