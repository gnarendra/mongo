
## About the App

  The purpose of this app is to demonstrate the usage of Spring BOOT framework along with PostgreSQL, in a cloud native way. 
  
  Through this app, we try to illustrate the PaaS specific behaviors, like, handling of VCAP services, etc. A developer using this app, can use this starter kit app as a reference, and he can proceed to develop his application on top of this, thus, making things easy for the developer.

  This is an application which does Album Management functionality. User can add a album, which will be added to his Album list. User can read the list of his Album’s, edit any of the albums in the Album list. User can delete any of his albums in the Album list.
  
# About the Framework - Spring BOOT

  Spring Boot makes it very easy to create Spring-powered application with a minimum of work. An application created with Spring Boot can be largely auto-configured with some sensible defaults, and among its many other features, the application requires no XML configuration
  
# About the DB - PostgreSQL

 Postgres supports flexible datatypes, functions to perform a logic outside of the standard SQL (string manipulation and conversions), choices of languages, and custom functions. PostgreSQL is an open source object-relational database system. PostgreSQL runs on all major operating systems, including Linux, UNIX (AIX, BSD, HP-UX, SGI IRIX, Mac OS X, Solaris, Tru64), and Windows. It supports text, images, sounds, and video, and includes programming interfaces for C / C++ , Java , Perl , Python , Ruby, Tcl and Open Database Connectivity (ODBC). PostgreSQL supports a large part of the SQL standard.

# Application Build

  This application uses Maven as the build tool.
  
# Dependency Management

  This application uses Maven to manage the dependent libraries. Maven’s pom.xml specifies the dependent libraries. 
 
# Prerequisite for enhancing the code locally
  
  * IDE like Eclipse
  * JDK should be installed 
  * CloudFoundry Eclipse Plugin or suitable IDE plugin
  * DB service instance should be created 
  * Maven setup 

# High level steps for building the application

  Go the directory where pom.xml is placed
  * Run the below commands:
            mvn clean
            mvn install
  * The application will be packaged as a war/jar file 

# High level steps for deploying the application in PaaS
    
## Using Eclipse: 
  - Install cloud foundry plugin in.
  - Login into your pivotal(api.run.pivotal.io)/bluemix(api.ng.bluemix.net) account
  - Drag and drop app to push an app into CF
  - Select and bind a service to your app 
  - Click finish button to complete your deployment
  
## Using Command line tool: 
  - Install the Cloud Foundry command line tool

  - For Pivotal CF login follow the below CLI command :
```sh
cf login -a api.run.pivotal.io
```
  - For IBM Bluemix CF login follow the below CLI command :
```sh
$ cf login -a api.ng.bluemix.net
```

- Push the app :
```sh
$ cf push <APPNAME> --no-start
```
 - Create a DB service :

```sh
$ cf create-service <SERVICE> <PLAN> <SERVICE_INSTANCE>
```
 - Bind the service to the app :

```sh
$ cf bind-service <YOUR-APP> <YOUR-SERVICE-INSTANCE>
```
 - Restage the the app :

```sh
$ cf restage <APPNAME>
```
# Unit test case execution

  Junit test cases have been written for this app, and it is placed inside the /src/test/java package. 
  Using Eclipse and STS:
  Right click on the test, you will get a option as Run as Junit Test. Select the option to run it. 
  
# Code Analysis
  Code analysis tools like PMD, Findbugs can be run on the code. Simple way, is to, add these plugins to the IDE, and then generate the report from the IDE.

# Package Description

  The App has the below prominent layers:
  Controller: Acting as a routing layer to receive incoming requests
  Service: Acting as a layer to handle the business logic
  Repositories: Acting as a layer to handle database connection
  Domain: A POJO object to hold the domain data

  
# VCAP Parsing for DB connection details
 - JpaRepository provided by Spring handles the VCAP parsing for DB connection details, of MySQL and Postgresql
 - MongoRepository provided by MongoDB handles the VCAP parsing for DB connection details, of MongoDB
 - Spring Boot usage in collaboration with the above Repository classes, abstracts the DB connection details parsing from the developer, thus reducing considerable effort for the developer

