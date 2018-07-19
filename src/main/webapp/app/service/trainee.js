"use strict";

(function () {

    
    function TraineeService (TraineeDal) {

        this.getTrainees = function()
        {
            console.log("calling traineeService get trainees")
        	return TraineeDal.getTrainees();
        };
        
    }
    
    angular.module("traineeApp").service("TraineeService", ['TraineeDal', TraineeService]);

}());