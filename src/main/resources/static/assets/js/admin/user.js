var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {

    //lấy danh sách sản phẩm từ api
    $scope.users = [];
    $http.get("../user/list").then(function(response) {
        $scope.users = response.data;

        // phân trang cho danh sách sản phẩm
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

//function sử lí khi nhấp vào button cập nhật
    $scope.user1= {};

    $scope.update = function (index) {
        for(var i = 0; i < $scope.users.length; i++){
            if( $scope.users[i].id == index){
                $scope.user1 = $scope.users[i];
            }
        }
    }
    // $scope.begin = 0;
    // $scope.pageCount = Math.ceil($scope.users.length / 8);
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