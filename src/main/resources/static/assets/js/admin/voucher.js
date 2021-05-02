var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    // lấy danh sách voucher từ api
    $scope.voucher = [];
    $http.get("../voucher/list").then(function(response) {
        $scope.voucher = response.data;
    //phân trang cho danh sách voucher
        $scope.pageCount = Math.ceil($scope.voucher.length / 8);
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


    // function sử lí khi nhất vào button cập nhật
    $scope.voucher1= {};

    $scope.update = function (index) {
        for(var i = 0; i < $scope.voucher.length; i++){
            if( $scope.voucher[i].id == index){
                $scope.voucher1 = $scope.voucher[i];
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