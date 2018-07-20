"use strict";

(function () {

    function TraineeDal (dal) {

        this.getTrainees = function () {
            console.log("getting trainees");
            return dal.http.GET("rest/trainees/json");
        };

        this.saveTrainee = function (traineeToSave) {
            return dal.http.POST("rest/trainees/json", traineeToSave);
        };

        this.updateTrainee = function (traineeToUpdate) {
            return dal.http.PUT("rest/trainees/json/", traineeToUpdate);
        };

        this.deleteTrainee = function (traineeToDelete) {
            return dal.http.DELETE("rest/trainees/json/", traineeToDelete);
        };
    }
    
    angular.module("traineeApp").service("TraineeDal", ["dal", TraineeDal]);
}());