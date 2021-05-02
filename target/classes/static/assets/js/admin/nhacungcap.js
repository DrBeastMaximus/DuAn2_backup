var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {

    //lấy danh sách api từ nhà cung cấp
    $scope.supplier = [];
    $http.get("../supplier/list").then(function(response) {
        $scope.supplier = response.data;

        // phân trang cho danh sách nhà cung cấp
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

// function sử lí khi nhấp vào buuton cập nhật
    $scope.provider1= {};

    $scope.update = function (index) {
        for(var i = 0; i < $scope.supplier.length; i++){
            if( $scope.supplier[i].id == index){
                $scope.provider1 = $scope.supplier[i];
            }
        }
    }


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