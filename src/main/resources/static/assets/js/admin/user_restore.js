var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    // lấy danh sách user có trạng thái chưa xóa từ api
    $scope.users = [];
    $http.get("../trashcon/user").then(function(response) {
        $scope.users = response.data;

        // phân trang cho danh sách user
        $scope.pageCount = Math.ceil($scope.users.length / 8);
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