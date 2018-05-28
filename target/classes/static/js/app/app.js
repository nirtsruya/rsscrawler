var rssCrawlerApp = angular.module('rssCrawlerApp', []);

rssCrawlerApp.service('PostService', function ($http) {
this.listPosts = function () {
    return $http.get('/posts');
}
});

rssCrawlerApp.controller('PostController', function ($scope, PostService, $timeout) {
   $scope.reload = function () {
       PostService.listPosts().
           success(function (data) {
             $scope.posts = data;
         });

       $timeout(function(){
         $scope.reload();
       },3000)
     };
     $scope.reload();
});