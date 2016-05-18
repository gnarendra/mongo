'use strict';
 
App.factory('UserService', ['$http', '$q', function($http, $q){
 
    return {
    	
    fetchAllUsers: function() {
    	 return $http.get('/tasks')
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while fetching users');
                        return $q.reject(errResponse);
                    }
            );
        },
    
   deleteUser: function(id){
        return $http.get('/deleteTask?id='+id)
        .then(
                function(response){
                    return response.data;
                }, 
                function(errResponse){
                    console.error('Error while deleting user');
                    return $q.reject(errResponse);
                }
        );
    },
   
      createUser: function(user){
            return $http.post('/createTask?taskName='+user.taskName)
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while creating user');
                        return $q.reject(errResponse);
                    }
            );
        },
      
       updateUser: function(user, id){
            return $http.post('/editTask?id='+id+"&taskName="+user.taskName)
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while updating user');
                        return $q.reject(errResponse);
                    }
            );
        }
       

         
    };
 
}]);