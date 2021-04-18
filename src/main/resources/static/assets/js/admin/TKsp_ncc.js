var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    // $scope.time = new Date();
    $scope.year_show = new Date().getFullYear();
    $scope.month_show = (new Date().getMonth()+1)+"-"+new Date().getFullYear();
    //tông đơn hàng và doanh thu
    $scope.totalbill = [];
    $http.get("../statistical/totalbill").then(function(response) {
        $scope.totalbill = response.data;
        $scope.totalbill1 =  $scope.totalbill[0];
    });
    $scope.count_User = [];
    $http.get("../statistical/countuser").then(function(response) {
        $scope.count_User = response.data;
        // $scope.User =  $scope.count_User[0];
    });

    $scope.User_newYear = [];
    $http.get("../statistical/countusernewyear").then(function(response) {
        $scope.User_newYear = response.data;
        // $scope.User =  $scope.count_User[0];
    });


    $scope.product = [];
    $scope.supplier =[];
    // alert($scope.year_top);
    if($scope.year_top != null){
        if($scope.year_top.length == 4){
            $http.get("../statistical/productbyyear/"+$scope.year_top).then(function(response) {
                $scope.product = response.data;
                // for(var i = 0; i < $scope.product.length; i++){
                //     if($scope.topproduct_chart.length <= $scope.product.length) {
                //         $scope.toppro_index =  $scope.topproduct[i];
                //         $scope.topproduct_chart.push([$scope.toppro_index[0],$scope.toppro_index[2]]);
                //     }
                // }
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
            $http.get("../statistical/supplierbyyear/"+$scope.year_top).then(function(response) {
                $scope.supplier = response.data;

                $scope.pageCount1 = Math.ceil($scope.supplier.length / 8);
                $scope.begin1 = 0;

                $scope.first1 = function() {
                    $scope.begin1 = 0;
                }
                $scope.prev1 = function() {
                    if ($scope.begin1 > 0) {
                        $scope.begin1 -= 8;
                    }
                }
                $scope.next1 = function() {
                    if ($scope.begin1 < ($scope.pageCount1 - 1) * 8) {
                        $scope.begin1 += 8;
                    }
                }
                $scope.last1 = function() {
                    $scope.begin1 = ($scope.pageCount1 - 1) * 8;
                }

            });

        }else{
            if($scope.year_top.length = 7){
                $http.get("../statistical/productbymonthyear/"+$scope.year_top).then(function(response) {
                    $scope.product = response.data;
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
                $http.get("../statistical/supplierbymonthyear/"+$scope.year_top).then(function(response) {
                    $scope.supplier = response.data;

                    $scope.pageCount1 = Math.ceil($scope.supplier.length / 8);
                    $scope.begin1 = 0;

                    $scope.first1 = function() {
                        $scope.begin1 = 0;
                    }
                    $scope.prev1 = function() {
                        if ($scope.begin1 > 0) {
                            $scope.begin1 -= 8;
                        }
                    }
                    $scope.next1 = function() {
                        if ($scope.begin1 < ($scope.pageCount1 - 1) * 8) {
                            $scope.begin1 += 8;
                        }
                    }
                    $scope.last1 = function() {
                        $scope.begin1 = ($scope.pageCount1 - 1) * 8;
                    }
                });

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