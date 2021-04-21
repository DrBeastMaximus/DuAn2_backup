
    var app = angular.module("myapp", []);
    app.controller("myctrl", function($scope, $http) {
    $scope.storage = [];
    $http.get("../storage/list").then(function(response) {
    $scope.storage = response.data;
});
    $scope.product = [];
    $http.get("../product/list").then(function(response) {
    $scope.product = response.data;
});

    $scope.provider = [];
    $http.get("../provider/list").then(function(response) {
    $scope.provider = response.data;
});

    $scope.storage1= {};

    $scope.update = function (index) {
    $scope.storage1 = $scope.storage[index];
}
    $scope.begin = 0;
    $scope.pageCount = Math.ceil($scope.storage.length / 8);
    $scope.first = function() {
        $scope.begin = 0;
    }
    $scope.prev = function() {
        // if ($scope.begin > 0) {

        // }
        if($scope.begin >=0){

        }else{
            $scope.begin -= 8;
        }
    }
    $scope.next = function() {
        if ($scope.begin < ($scope.pageCount - 1) * 8) {
            $scope.begin += 8;
        }else{
            if($scope.begin == 0){
                // $scope.begin += 8;
            }  $scope.begin = ($scope.pageCount - 1) * 8;
        }

    }
    $scope.last = function() {
        $scope.begin = ($scope.pageCount - 1) * 8;
    }


});
