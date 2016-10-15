var app = angular.module('carApp', ['ngRoute']);

app.controller('viewCarController', function ($scope, carList, $routeParams, $location) {

    $scope.deleteCar = function (id) {
        carList.deleteCar(id).success(function () {
            $location.path('/list');

        });
    };
    $scope.title = "Cars Demo App";
    $scope.predicate = "year";
    $scope.reverse = false;
    $scope.cars = [];
    $scope.id = $routeParams.id;

    carList.getAll().success(function (data) {
        $scope.cars = data;

    });



});

app.controller('addCarController', function ($scope, carList, $location) {

    $scope.save = function () {
        carList.addCar($scope.newCar);
        $location.path('/list');
    };


});
app.controller('deleteCarController', function ($scope, carList, $location, $routeParams) {

    $scope.id = $routeParams.id;
    carList.deleteCar($scope.id).success(function () {

    });

});



app.controller('editCarController', function ($scope, carList, $routeParams, $location) {
    $scope.id = $routeParams.id;
    $scope.newCar = null;
    carList.getCar($scope.id).success(function (data) {
        $scope.newCar = data;



    });
    $scope.save = function () {
        carList.addCar($scope.newCar);
        $location.path('/list');

    };

});


app.config(function ($routeProvider) {
    $routeProvider
            .when("/edit/:id", {
                templateUrl: "templates/addCar.html",
                controller: "editCarController"
            })
            .when("/list", {
                templateUrl: "templates/allCars.html",
                controller: "viewCarController"
            })
            .when("/delete/:id", {
                templateUrl: "templates/allCars.html",
                controller: "viewCarController"
            })
            .when("/add", {
                templateUrl: "templates/addCar.html",
                controller: "addCarController"
            })

            .otherwise({
                redirectTo: "/list"
            });
});



app.factory('carList', function ($http, $window) {
    return{
        getAll: function () {
            return $http.get('api/car');

        },
        getCar: function (id) {
            return $http.get('api/car/' + id);

        },
        addCar: function (newCar) {
            $http.post('api/car', newCar);

        },
        deleteCar: function (id) {
            return $http.delete('api/car/' + id);

        }


    };


});
