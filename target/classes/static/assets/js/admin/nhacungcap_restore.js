var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    // lấy danh sách nhà cung cấp đã xóa từ api
    $scope.supplier = [];
    $http.get("../trashcon/supplier").then(function(response) {
        $scope.supplier = response.data;

        // phân trang cho danh sách nhà cung cấp đã xóa
        $scope.pageCount = Math.ceil($scope.supplier.length / 8);
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