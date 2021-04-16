var app = angular.module("myapp", []);
app.controller("myctrl", function($scope, $http) {
    //lấy ngày và tháng hiện tại
    $scope.year_show = new Date().getFullYear();
    $scope.month_show = (new Date().getMonth()+1)+"-"+new Date().getFullYear();

    //lấy tổng số lượng đơn hàng và doanh thu từ api
    $scope.totalbill = [];
    $http.get("../statistical/totalbill").then(function(response) {
        $scope.totalbill = response.data;
        $scope.totalbill1 =  $scope.totalbill[0];
    });

    //lấy tổng số lượng user có trong db
    $scope.count_User = [];
    $http.get("../statistical/countuser").then(function(response) {
        $scope.count_User = response.data;
        // $scope.User =  $scope.count_User[0];
    });
    // lấy tổng số lượng user đã đăng kí trong năm hiện tại
    $scope.User_newYear = [];
    $http.get("../statistical/countusernewyear").then(function(response) {
        $scope.User_newYear = response.data;
        // $scope.User =  $scope.count_User[0];
    });

    // thống kê tổng đơn hàng từ api
    $scope.QuantityInvoiceYear = [];
    $scope.yearHD = [];
    $scope.QuantityYear = []


    if($scope.year != null) {
        $http.get("../statistical/quantityinvoicebyyear/"+$scope.year).then(function(response) {
            $scope.QuantityInvoiceYear = response.data;
            for(var i = 0; i < $scope.QuantityInvoiceYear.length; i++){
                if($scope.yearHD.length < $scope.QuantityInvoiceYear.length) {
                    //đưa dữ liệu vào mảng để đưa vào biểu đồ
                    $scope.totalIndex =  $scope.QuantityInvoiceYear[i];
                    $scope.yearHD.push(angular.copy($scope.totalIndex[0]));
                    $scope.QuantityYear.push(angular.copy($scope.totalIndex[1]));
                }
            }
            // biểu đồ thống kê số lượng đơn hàng
            var data = {
                labels: $scope.yearHD,
                series: [
                    $scope.QuantityYear
                ]
            };
            var options = {
                seriesBarDistance: 10
            };
            new Chartist.Bar('#chart2', data, options,);
        });

    }
    //thống kê tổng doanh thu của từng tháng theo năm
    $scope.TotalInvoiceYear = [];
    $scope.yearDT = [];
    $scope.TotalYear = []
    $scope.toptalinvoice_chart= [];
    $scope.toptalinvoice_chart.push( ['Month', 'TT']);
    if($scope.year != null) {

        $http.get("../statistical/totalinvoicebyyear/"+$scope.year).then(function(response) {
            $scope.TotalInvoiceYear = response.data;
            for(var i = 0; i < $scope.TotalInvoiceYear.length; i++){
                if($scope.toptalinvoice_chart.length <= $scope.TotalInvoiceYear.length) {
                    //đưa dử liệu từ api vào mảng để đua lên biểu đồ
                    $scope.toptalinvoice_chart.push(angular.copy( $scope.TotalInvoiceYear[i]));
                    // $scope.totalIndex =  $scope.TotalInvoiceYear[i];
                    // $scope.yearDT.push(angular.copy($scope.totalIndex[0]));
                    // $scope.TotalYear.push(angular.copy($scope.totalIndex[1]));
                }
            }
            // new Chartist.Line('#chart3', {
            //     labels: $scope.yearDT,
            //     series: [
            //         $scope.TotalYear,
            //     ]
            // }, {
            //     fullWidth: true,
            //     chartPadding: {
            //         right: 40
            //     }
            // });
            // alert($scope.toptalinvoice_chart)
                // biểu đồ thống kê từng sản phẩm theo năm
            google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable(

                    $scope.toptalinvoice_chart
                );

                var options = {
                    title: 'Doanh Thu',
                    hAxis: {title: 'Month',  titleTextStyle: {color: '#333'}},
                    vAxis: {minValue: 0}
                };

                var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
                chart.draw(data, options);
            }
            // new Chart(document.getElementById("bar-chart"), {
            //     type: 'bar',
            //     data: {
            //         labels: $scope.yearDT,
            //         datasets: [
            //             {
            //                 label: "Tổng doanh thu",
            //                 backgroundColor: ["#3e95cd", "#0000FF","#8e5ea2","#3cba9f","#e8c3b9","#c45850","#FF00CC","#33FF33","#AAAAAA","#00CCFF","#FFFF33","#9900FF"],
            //                 data: $scope.TotalYear,
            //                 width : "1px",
            //                 height: "1px"
            //             }
            //         ]
            //     },
            //     options: {
            //         legend: { display: false },
            //         title: {
            //             display: true,
            //             text: ' '
            //         }
            //     }
            // });

            // google.charts.load('current', {packages: ['corechart', 'line']});
            // google.charts.setOnLoadCallback(drawBackgroundColor);
            //
            // function drawBackgroundColor() {
            //     var data = new google.visualization.DataTable();
            //     data.addColumn('number', 'X');
            //     data.addColumn('number', 'Dogs1');
            //
            //     data.addRows($scope.TotalInvoiceYear);
            //
            //     var options = {
            //         hAxis: {
            //             title: 'Time'
            //         },
            //         vAxis: {
            //             title: 'Popularity'
            //         },
            //         backgroundColor: '#f1f8e9'
            //     };
            //
            //     var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
            //     chart.draw(data, options);
            // }

            // var options = {
            //     type: 'line',
            //     data: {
            //         labels: $scope.yearDT,
            //         datasets: [
            //             {
            //                 label: '# of Votes',
            //                 data: $scope.TotalYear,
            //                 borderWidth: 1
            //             }
            //         ]
            //     },
            //     options: {
            //         scales: {
            //             yAxes: [{
            //                 ticks: {
            //                     reverse: false
            //                 }
            //             }]
            //         }
            //     }
            // }
            // var ctx = document.getElementById('chartJSContainer').getContext('2d');
            // new Chart(ctx, options);

        });

    }
    // tổng số tài khoản khách hàng đã đăng kí của từng tháng theo năm

    $scope.QuantityUser = [];
    $scope.year_user = [];
    $scope.count = []
    if($scope.year != null) {
        $http.get("../statistical/quantityuseryear/"+$scope.year).then(function(response) {
            $scope.QuantityUser = response.data;
            for(var i = 0; i < $scope.QuantityUser.length; i++){
                if($scope.year_user.length < $scope.QuantityUser.length) {
                    $scope.quantityIndex =  $scope.QuantityUser[i];
                    $scope.year_user.push(angular.copy($scope.quantityIndex[0]));
                    $scope.count.push(angular.copy($scope.quantityIndex[1]));
                }
            }
            new Chartist.Line('#chart4', {
                labels: $scope.year_user,
                series: [
                    $scope.count,
                ]
            }, {
                fullWidth: true,
                chartPadding: {
                    right: 40
                }
            });
        });

    }
    // thống kê top sản phẩm bán chạy, yêu thích và top khách hàng
    $scope.topproduct = [];
    $scope.topwishlish= [];
    $scope.topuser = [];
    // alert($scope.year_top);
    if($scope.year_top != null){
        if($scope.year_top.length == 4){
            //thống kê theo năm
            $http.get("../statistical/topproductbyyear/"+$scope.year_top).then(function(response) {
                $scope.topproduct = response.data;
                $scope.product_name = [];
                $scope.product_total = [];
                $scope.topproduct_chart = [];
                $scope.topproduct_chart.push(['Task', 'Hours per Day']);
                // $scope.char_pro = [];
                for(var i = 0; i < $scope.topproduct.length; i++){
                    if($scope.topproduct_chart.length <= $scope.topproduct.length) {
                    //đưa dữ liệu vào mảng để đưa vào biễu đồ
                        $scope.toppro_index =  $scope.topproduct[i];
                        // $scope.product_name = $scope.toppro_index[0];
                        // $scope.product_total = $scope.toppro_index[2];
                        $scope.topproduct_chart.push([$scope.toppro_index[0],$scope.toppro_index[2]]);
                        // $scope.product_name.push(angular.copy($scope.toppro_index[0]));
                        // $scope.product_total.push(angular.copy($scope.toppro_index[2]));
                        // $scope.char_pro_index = [$scope.toppro_index[0],$scope.toppro_index[2]];
                        // $scope.test = $scope.aa;
                        // $scope.char_pro.push(angular.copy($scope.char_pro_index));

                    }

                }
                //biểu đồ thống kê top 10 sản phẩm bán chạy nhất
                google.charts.load("current", {packages:["corechart"]});
                google.charts.setOnLoadCallback(drawChart);
                function drawChart() {
                    var data = google.visualization.arrayToDataTable($scope.topproduct_chart);

                    var options = {
                        title: 'My Daily Activities',
                        pieHole: 0.4,
                    };

                    var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
                    chart.draw(data, options);
                }

                // new Chart(document.getElementById("pie-chart"), {
                //     type: 'pie',
                //     data: {
                //         labels:  $scope.product_name,
                //         datasets: [{
                //             label: "Population (millions)",
                //             backgroundColor: ["#3e95cd", "#0000FF","#8e5ea2","#3cba9f","#e8c3b9","#c45850","#FF00CC","#33FF33","#AAAAAA","#00CCFF"],
                //             data: $scope.product_total
                //         }]
                //     },
                //     options: {
                //         title: {
                //             display: true,
                //             text: 'Top sản phẩm bán ra nhiều nhất '
                //         }
                //     }
                // });




            });
        // thống kê top 10 sản phẩm được yêu thích nhất
            $http.get("../statistical/topwishlishbyyear/"+$scope.year_top).then(function(response) {
                $scope.topwishlish = response.data;
                $scope.char_wishlish = [];
                $scope.char_wishlish.push(['Task', 'Hours per Day']);
                for(var i = 0; i < $scope.topwishlish.length; i++){
                    //đưa dữ liệu vào mảng để đưa lên biểu đồ
                    if($scope.char_wishlish.length <=  $scope.topwishlish.length) {
                        $scope.char_wishlish.push(angular.copy( $scope.topwishlish[i]));
                        // $scope.name.push(angular.copy($scope.user_index[0]));
                        // $scope.total_bill.push(angular.copy($scope.user_index[1]));
                    }
                }

                //biểu đồ top 10 sản phẩm yêu thích nhất
                google.charts.load('current', {'packages':['corechart']});
                google.charts.setOnLoadCallback(drawChart);

                function drawChart() {

                    var data = google.visualization.arrayToDataTable(

                        $scope.char_wishlish
                    );

                    var options = {
                        title: 'Top sản phẩm đươc yêu thích nhất'
                    };

                    var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                    chart.draw(data, options);
                }

            });

            //top 10 khách hàng mua sắm nhiều nhất
            $http.get("../statistical/topuserbyyear/"+$scope.year_top).then(function(response) {
                $scope.topuser = response.data;
                $scope.name = [];
                $scope.total_bill = [];
                for(var i = 0; i < $scope.topuser.length; i++){
                    // đưa dữ liệu vào mãng để đưa vào biểu đồ
                    if($scope.name.length < $scope.topuser.length) {
                        $scope.user_index =  $scope.topuser[i];
                        $scope.name.push(angular.copy($scope.user_index[0]));
                        $scope.total_bill.push(angular.copy($scope.user_index[1]));
                    }
                }
                // new Chartist.Bar('#chart6', {
                //     labels: $scope.name,
                //     series:  $scope.total_bill
                // }, {
                //     distributeSeries: true,
                //     height: 500
                // });

        //biểu đồ thống kê top 10 khách hàng
                google.charts.load('current', {packages: ['corechart']});
                google.charts.setOnLoadCallback(drawChart);

                function drawChart() {
                    // Define the chart to be drawn.
                    var data = new google.visualization.DataTable();
                    data.addColumn('string', 'Element');
                    data.addColumn('number', 'Tổng tiền');
                    data.addRows( $scope.topuser);

                    // Instantiate and draw the chart.
                    var chart = new google.visualization.ColumnChart(document.getElementById('barChart'));
                    chart.draw(data, null);
                }
            });
        }else{
            if($scope.year_top.length = 7){
                // thống kê top sản phẩm bán chạy, sản phẩm yêu thích nhất, và top người dủng theo tháng

                //thống kê top 10 sản phẩm bán chạy nhất
                $http.get("../statistical/topproductbymonthyear/"+$scope.year_top).then(function(response) {
                    $scope.topproduct = response.data;
                    $scope.product_name = [];
                    $scope.product_total = [];
                    $scope.topproduct_chart = [];
                    $scope.topproduct_chart.push(['Task', 'Hours per Day']);
                    // $scope.char_pro = [];
                    for(var i = 0; i < $scope.topproduct.length; i++){
                        // đưa dữ liệu vào mảng để đưa vào biểu đồ
                        if($scope.topproduct_chart.length <= $scope.topproduct.length) {

                            $scope.toppro_index =  $scope.topproduct[i];
                            // $scope.product_name = $scope.toppro_index[0];
                            // $scope.product_total = $scope.toppro_index[2];
                            $scope.topproduct_chart.push([$scope.toppro_index[0],$scope.toppro_index[2]]);
                            // $scope.product_name.push(angular.copy($scope.toppro_index[0]));
                            // $scope.product_total.push(angular.copy($scope.toppro_index[2]));
                            // $scope.char_pro_index = [$scope.toppro_index[0],$scope.toppro_index[2]];
                            // $scope.test = $scope.aa;
                            // $scope.char_pro.push(angular.copy($scope.char_pro_index));

                        }

                    }
                    //biểu đồ thống kê top sản phẩm bán chạy
                    google.charts.load("current", {packages:["corechart"]});
                    google.charts.setOnLoadCallback(drawChart);
                    function drawChart() {
                        var data = google.visualization.arrayToDataTable($scope.topproduct_chart);

                        var options = {
                            title: 'My Daily Activities',
                            pieHole: 0.4,
                        };

                        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
                        chart.draw(data, options);
                    }


                });
                //thống kê top 10 sản phẩm được yêu thích nhất
                $http.get("../statistical/topwishlishbymonthyear/"+$scope.year_top).then(function(response) {
                    $scope.topwishlish = response.data;
                    $scope.char_wishlish = [];
                    $scope.char_wishlish.push(['Task', 'Hours per Day']);
                    for(var i = 0; i < $scope.topwishlish.length; i++){
                        //đưa dữ liệu vào mảng để đưa vào biểu đồ
                        if($scope.char_wishlish.length <=  $scope.topwishlish.length) {
                            $scope.char_wishlish.push(angular.copy( $scope.topwishlish[i]));
                            // $scope.name.push(angular.copy($scope.user_index[0]));
                            // $scope.total_bill.push(angular.copy($scope.user_index[1]));
                        }
                    }

                    //biểu đồ top 10 sản phẩm được yêu thích nhất
                    google.charts.load('current', {'packages':['corechart']});
                    google.charts.setOnLoadCallback(drawChart);

                    function drawChart() {

                        var data = google.visualization.arrayToDataTable(

                            $scope.char_wishlish
                        );

                        var options = {
                            title: 'Top sản phẩm đươc yêu thích nhất'
                        };

                        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                        chart.draw(data, options);
                    }

                });

                // thống kê top 10 khách hàng mua sắm nhiều nhất
                $http.get("../statistical/topuserbymonthyear/"+$scope.year_top).then(function(response) {
                    $scope.topuser = response.data;
                    $scope.name = [];
                    $scope.total_bill = [];
                    //đưa dữ liệu vào mảng để đưa lên biểu đồ
                    for(var i = 0; i < $scope.topuser.length; i++){
                        if($scope.name.length < $scope.topuser.length) {
                            $scope.user_index =  $scope.topuser[i];
                            $scope.name.push(angular.copy($scope.user_index[0]));
                            $scope.total_bill.push(angular.copy($scope.user_index[1]));
                        }
                    }
                    // new Chartist.Bar('#chart6', {
                    //     labels: $scope.name,
                    //     series:  $scope.total_bill
                    // }, {
                    //     distributeSeries: true,
                    //     height: 500
                    // });

                    // biểu đồ top 10 khách hàng
                    google.charts.load('current', {packages: ['corechart']});
                    google.charts.setOnLoadCallback(drawChart);

                    function drawChart() {
                        // Define the chart to be drawn.
                        var data = new google.visualization.DataTable();
                        data.addColumn('string', 'Element');
                        data.addColumn('number', 'Tổng tiền');
                        data.addRows( $scope.topuser);

                        // Instantiate and draw the chart.
                        var chart = new google.visualization.ColumnChart(document.getElementById('barChart'));
                        chart.draw(data, null);
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