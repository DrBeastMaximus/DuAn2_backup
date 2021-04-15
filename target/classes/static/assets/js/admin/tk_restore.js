var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    //api lấy danh sách tài khoản đã xóa từ api
    $scope.admins = [];
    $http.get("../trashcon/admin").then(function(response) {
        $scope.admins = response.data;
    // phân trang cho danh sách tài khoản
        $scope.pageCount = Math.ceil($scope.admins.length / 8);
        $scope.begin = 0;

        $scope.first = function() {
            $scope.begin = 0;
        }
        $scope.prev = function() {
            if ($scope.begin > 0) {
                $scope.begin -= 8;
            }
        }
        $scope.next = function() {
            if ($scope.begin < ($scope.pageCount - 1) * 8) {
                $scope.begin += 8;
            }
        }
        $scope.last = function() {
            $scope.begin = ($scope.pageCount - 1) * 8;
        }
    });


    // $scope.admin1= {};
    //
    // $scope.update = function (index) {
    //     $scope.admin1 = $scope.admins[index];
    // }
    // $scope.begin = 0;
    // $scope.pageCount = Math.ceil($scope.admins.length / 8);
    // $scope.first = function() {
    //     $scope.begin = 0;
    // }
    // $scope.prev = function() {
    //     // if ($scope.begin > 0) {
    //
    //     // }
    //     if($scope.begin >=0){
    //
    //     }else{
    //         $scope.begin -= 8;
    //     }
    // }
    // $scope.next = function() {
    //     if ($scope.begin < ($scope.pageCount - 1) * 8) {
    //         $scope.begin += 8;
    //     }else{
    //         if($scope.begin == 0){
    //             // $scope.begin += 8;
    //         }  $scope.begin = ($scope.pageCount - 1) * 8;
    //     }
    //
    // }
    // $scope.last = function() {
    //     $scope.begin = ($scope.pageCount - 1) * 8;
    // }
    // }

});
app.directive('input', ['$parse', function ($parse) {
    return {
        controller: 'myctrl',
        restrict: 'E',
        require: '?ngModel',
        link: function (scope, element, attrs) {
            if(attrs.value) {
                $parse(attrs.ngModel).assign(scope, attrs.value);
            }
        }
    };
}]);