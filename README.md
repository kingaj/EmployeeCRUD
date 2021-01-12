# Employee CRUD 
this is project include springboot, restful service, logger with mysql connection

# Prerequisites 
- install mysql
- need to change in application.properties file for mysql connection

# Table Info 

CREATE TABLE `managementdb`.`tbl_employee` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(255) NULL,
  `lastName` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `age` INT NULL,
  `gender` VARCHAR(45) NULL,
  `address` VARCHAR(3000) NULL,
  PRIMARY KEY (`id`));


# Rest Api include


for get all employee (Request GET)

 - http://localhost:8080/employees

 add image

for save employee (Request POST)

 - http://localhost:8080/employee

 - Body Request : 
 	{
	"firstName": "Vijay",
	"lastName": "Shah",
	"email": "vijay.shah1@gmail.com",
	"age": 25,
	"gender": "male",
	"address": "Unknown"
	}

	add image

for update employee (Request PUT)

 - http://localhost:8080/employee

 - Body Request : 
 	{
 	"id":4
	"firstName": "Vijay",
	"lastName": "Shah",
	"email": "vijay.shah1@gmail.com",
	"age": 25,
	"gender": "male",
	"address": "Unknown"
	}

	add image

for delete employee (Request DELETE)

http://localhost:8080/employee/{employee id} // without curly braces
