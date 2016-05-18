'use strict';
 
App.factory('UserService', ['$http', '$q', function($http, $q){
 
    return {
    	
    fetchAllUsers: function() {
    	 return $http.get('/person/personlist')
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
        return $http.get('/person/deletePerson?id='+id)
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
            return $http.post('/person/addPerson?firstName='+user.firstName+'&lastName='+user.lastName)
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
            return $http.post('/person/editPerson?id='+id+"&firstName="+user.firstName+"&lastName="+user.lastName)
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