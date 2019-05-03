# Simple_SMS_Application
This application is made for sending and receiving SMS using Ideamart simulator.  To simulate the sending and receiving the message you can download the ideamart simulator from [here](http://www.ideamart.lk/web/idea-pro/tutorials/start-up-the-simulator/)  

## Prerequisites
* Java 8.x
* MySQL 8.x
* Maven 3.x

## Required Configurations
* Database script is in data file, configure database before executing the application.
* Add following DNS to `/etc/hosts` file.
````
    127.0.0.1       db.mysql.passport
    127.0.0.1       core.passport.service
````

## How to Build and Deploy
* Build the project from top-level.
````
    mvn clean install
```` 
* Go inside `target/Simple_SMS_Application` and execute the application using following command
````
    ./bin/Simple_SMS_Application console
````