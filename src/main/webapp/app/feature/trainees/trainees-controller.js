(function() {

    var TraineesController =  function(TraineeService, dataService, $state, $log) {

        var vm = this;

        vm.selectedTrainee = dataService.getData();

        function init() {
            TraineeService.getTrainees().then(function (results) {
                vm.trainees = results;
                $log.log("In the account controller the value of the result promise is ");
                $log.log(JSON.stringify(vm.accounts));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();

        vm.passTrainee = function (data) {
                console.log("passtrainee function");
                console.log(data);
                vm.selectedTrainee = data;
                dataService.setData(data);
                $state.go("traineeinfo");
        }

        vm.deleteTrainee = function (trainee){
            console.log("deleting trainee : " + trainee);
            TraineeService.deleteTrainee(trainee).then(function (response) {
                vm.response = response;
                $log.log("In the account controller the value of the result promise is ");
                $log.log(JSON.stringify(vm.response));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }


    };

    angular.module('traineeApp').controller('traineesController', ['TraineeService', 'dataService', '$state', '$log', TraineesController]);
}());