var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    //lấy danh sách sản phẩm từ api
    $scope.product = [];
    $http.get("../product/list").then(function(response) {
        $scope.product = response.data;
// phân trang cho danh sách sản phẩm
        $scope.pageCount = Math.ceil($scope.product.length / 8);
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
// lấy danh sách nhà cung cấp
    $scope.supplier = [];
    $http.get("../supplier/list").then(function(response) {
        $scope.supplier = response.data;
    });

    //function sử lí khi nhấp vào button cập nhật
    $scope.product1= {};

    $scope.update = function (index) {
        for(var i = 0; i < $scope.product.length; i++){
            if( $scope.product[i].id == index){
                $scope.product1 = $scope.product[i];
            }
        }
    }
    // function sử lí khi nhấp vào button hiện content
    $scope.content= "";
    $scope.contentid = function (index) {
        for(var i = 0; i < $scope.product.length; i++){
            if( $scope.product[i].id == index){
                $scope.content = $scope.product[i].description;
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