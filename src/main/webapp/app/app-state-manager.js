"use strict";

(function () {

    angular.module('traineeApp').config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise("/dashboard");

        $stateProvider.state("dashboard", {
            url: "/dashboard",
            templateUrl: "app/feature/dashboard/dashboard.html"
        }).state("trainees", {
                url: "/trainees",
                templateUrl: "app/feature/trainees/trainees.html"
        }).state("traineeinfo", {
            url: "/traineeinfo",
            templateUrl: "app/feature/traineeinfo/traineeInfo.html"
        })
    });
}());