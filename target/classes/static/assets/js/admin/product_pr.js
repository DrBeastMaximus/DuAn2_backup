var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    // lấy danh sách thuộc tính sản phẩm
    $scope.product_property = [];
    $http.get("../productproperty/list").then(function(response) {
        $scope.product_property = response.data;

        // phân trang cho danh sách thuộc tính sản phẩm
        $scope.pageCount = Math.ceil($scope.product_property.length / 8);
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


    // function sử lí khu nhấp vào button update
    $scope.product_property1= {};

    $scope.update = function (index) {
        for(var i = 0; i < $scope.product_property.length; i++){
            if( $scope.product_property[i].id == index){
                $scope.product_property1 = $scope.product_property[i];
            }
        }
    }
    // $scope.begin = 0;
    // $scope.pageCount = Math.ceil($scope.product_property.length / 8);
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