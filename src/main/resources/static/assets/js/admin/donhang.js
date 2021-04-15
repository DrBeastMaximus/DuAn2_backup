var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    // lấy dữ liệu api hóa đơn theo $scope,id_sttus
    $scope.invoice = [];
    if($scope.id_status != null) {
        $http.get("../../invoice/list/" + $scope.id_status).then(function (response) {

            $scope.invoice = response.data;
            // phân trang khi hiển thị lên table
            $scope.pageCount = Math.ceil($scope.invoice.length / 8);
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
    // thống kê số lượng đơn hàng của từng trạng thái
    $scope.count = [];
    $scope.xoa = 0;
    $scope.chapnhan = 0;
    $scope.cho=0;
    $scope.dang =0;
    $scope.hoanthanh = 0;
    $http.get("../../invoice/count/list").then(function (response) {
        $scope.count = response.data;
        for( var i = 0;i < $scope.count.length;i++){
            $scope.ketqua = $scope.count[i];
            if($scope.ketqua[0] == 0){
                $scope.chapnhan = $scope.ketqua[1];
            }
            if($scope.ketqua[0] == 1){
                $scope.cho = $scope.ketqua[1];
            }
            if($scope.ketqua[0] == 2){
                $scope.dang = $scope.ketqua[1];
            }
            if($scope.ketqua[0] == 3){
                $scope.hoanthanh = $scope.ketqua[1];
            }
            if($scope.ketqua[0] == 4){
                $scope.xoa = $scope.ketqua[1];
            }
        }
    });

    // for(var i = 0;i < $scope.count;i++){
    //     $scope.test = $scope.count[]
    // }

    // alert($scope.id);
    // function hiển thị chi tiết hóa đơn
    $scope.invoice1= {};

    $scope.chitiet = function (index) {
        for(var i = 0; i < $scope.invoice.length; i++){
            if( $scope.invoice[i].invoice.id == index){

                $scope.invoice_detail = $scope.invoice[i].invoidetail;
                // phân trang cho chi tiết hóa đơn
                $scope.pageCount1 = Math.ceil($scope.invoice_detail.length / 8);
                $scope.begin1 = 0;

                $scope.first1 = function() {
                    $scope.begin1 = 0;
                }
                $scope.prev = function() {
                    if ($scope.begin1 > 0) {
                        $scope.begin1 -= 8;
                    }
                }
                $scope.next1 = function() {
                    if ($scope.begin1 < ($scope.pageCount1 - 1) * 8) {
                        $scope.begin1 += 8;
                    }
                }
                $scope.last = function() {
                    $scope.begin1 = ($scope.pageCount1 - 1) * 8;
                }
            }
        }
        // $scope.invoice_detail = $scope.invoice[index].invoidetail;
    }

    //các url status khi cập nhật trạng thái đơn hàng
    $scope.url = "";
    $scope.tuchoi = function (){
        $scope.url = "./cho-xac-nhan";
        $scope.status = 4;
    }
    $scope.xacnhan = function (){
        $scope.url = "./cho-xac-nhan";
        $scope.status = 1;
    }
    $scope.chovanchuyen = function (){
        $scope.url = "./cho-van-chuyen";
        $scope.status = 2;
    }
    $scope.dangvanchuyen = function (){
        $scope.url = "./dang-van-chuyen";
        $scope.status = 3;
    }

    // $scope.begin = 0;
    // $scope.pageCount = Math.ceil($scope.invoice.length / 8);
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
// nhận dữ liệu từ input xuống angular
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