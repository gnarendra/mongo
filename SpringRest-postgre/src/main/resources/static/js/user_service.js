'use strict';
 
App.factory('UserService', ['$http', '$q', function($http, $q){
 
    return {
    	
    fetchAllUsers: function() {
    	 return $http.get('http://rest-postgresql.mybluemix.net/albums')
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
        return $http.get('http://rest-postgresql.mybluemix.net/deletealbum?id='+id)
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
            return $http.post('http://rest-postgresql.mybluemix.net/addAlbum?title='+user.title+'&artist='+user.artist+'&releaseYear='+user.releaseYear)
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
            return $http.post('http://rest-postgresql.mybluemix.net/editAlbum?id='+id+"&title="+user.title+"&artist="+user.artist+"&releaseYear="+user.releaseYear)
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