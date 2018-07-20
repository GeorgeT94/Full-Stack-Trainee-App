"use strict";

(function () {

    
    function TraineeService (TraineeDal) {

        this.getTrainees = function()
        {
            console.log("calling traineeService get trainees")
        	return TraineeDal.getTrainees();
        };
        this.deleteTrainee = function(trainee)
        {
            console.log("calling traineeService delete trainee")
            return TraineeDal.deleteTrainee(trainee);
        };
        
    }
    
    angular.module("traineeApp").service("TraineeService", ['TraineeDal', TraineeService]);

}());