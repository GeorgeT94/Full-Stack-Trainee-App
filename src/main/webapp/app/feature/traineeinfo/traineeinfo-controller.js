(function() {

    var TraineeInfoController =  function(TraineeService, dataService, $state, $log) {

        var vm = this;

        vm.selectedTrainee = dataService.getData();



        vm.deleteTrainee = function (trainee){
            console.log("deleting trainee : " + trainee);
            TraineeService.deleteTrainee(trainee).then(function (response) {
                vm.response = response;
                $log.log("In the account controller the value of the result promise is ");
                $log.log(JSON.stringify(vm.response));
                $state.go('trainees');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }


    };

    angular.module('traineeApp').controller('traineeInfoController', ['TraineeService', 'dataService', '$state', '$log', TraineeInfoController]);
}());