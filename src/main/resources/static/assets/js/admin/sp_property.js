var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {

    //lấy danh sách thuộc tính sản phẩm chi tiết từ api có product id tương ứng
    $scope.productproperty_detail = [];
    if($scope.id != null) {
        $http.get("../../productPropertydetail/list/" + $scope.id).then(function (response) {
            $scope.productproperty_detail = response.data;

            // phân trang cho danh sách sản phẩm
            $scope.pageCount = Math.ceil($scope.productproperty_detail.length / 8);
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
    }
    // alert($scope.id);
    $scope.productproperty_detail1= {};
// lấy danh sách thuộc tính sản phẩm từ api
    $scope.product_property = [];
    $http.get("../../../productproperty/list").then(function(response) {
        $scope.product_property = response.data;
    });
    // url cho các chức năng thêm, sửa, xóa
    $scope.urlinsert= "../../property/home/"+$scope.id;
    $scope.urlupdate= "../../property/update/"+$scope.id;
    $scope.urldelete= "../../property/delete/"+$scope.id;

    //function sử lí khi nhấp vào button cập nhập
    $scope.update = function (index) {
        for(var i = 0; i < $scope.productproperty_detail.length; i++){
            if( $scope.productproperty_detail[i].id == index){
                $scope.productproperty_detail1 = $scope.productproperty_detail[i];
            }
        }
        // $scope.productproperty_detail1 = $scope.productproperty_detail[index];
    }
    // $scope.begin = 0;
    // $scope.pageCount = Math.ceil($scope.productproperty_detail.length / 8);
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