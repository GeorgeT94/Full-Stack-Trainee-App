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


    };

    angular.module('traineeApp').controller('traineesController', ['TraineeService', 'dataService', '$state', '$log', TraineesController]);
}());