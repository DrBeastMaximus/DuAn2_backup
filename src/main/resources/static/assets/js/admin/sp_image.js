var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    //lấy danh sách image từ api có id product tương ứng
    $scope.productimage = [];
    if($scope.id != null) {
        $http.get("../../productimage/list/" + $scope.id).then(function (response) {
            $scope.productimage = response.data;
// phân trang cho danh sách image đó
            $scope.pageCount = Math.ceil($scope.productimage.length / 8);
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
    //function sử lý khi nhấp vào button cập nhật
    $scope.productimage1= {};
    $scope.update = function (index) {
        for(var i = 0; i < $scope.productimage.length; i++){
            if( $scope.productimage[i].id == index){
                $scope.productimage1 = $scope.productimage[i];
                // đọc hình ảnh có trang api
                $scope.urlimage= "/api/image/getImagesByID/"+$scope.productimage[i].id;
            }
        }
        // $scope.productimage1 = $scope.productimage[index];

    }
// các url cho các chức năng thêm, sửa, xóa
    $scope.urlinsert= "../../image/insert/"+$scope.id;
    $scope.urlupdate= "../../image/update/"+$scope.id;
    $scope.urldelete= "../../image/delete/"+$scope.id;
    $scope.urlimage = null;

    // $scope.begin = 0;
    //
    // $scope.pageCount = Math.ceil($scope.productimage.length / 8);
    // $scope.first = function() {
    //     $scope.begin = 0;
    //
    // }
    // $scope.prev = function() {
    //
    //     if($scope.begin >=0){
    //
    //     }else{
    //         $scope.begin -= 8;
    //
    //     }
    // }
    // $scope.next = function() {
    //     if ($scope.begin < ($scope.pageCount - 1) * 8) {
    //         $scope.begin += 8;
    //
    //     }else{
    //         if($scope.begin == 0){
    //
    //
    //         }  $scope.begin = ($scope.pageCount - 1) * 8;
    //
    //     }
    //
    // }
    // $scope.last = function() {
    //     $scope.begin = ($scope.pageCount - 1) * 8;
    //
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