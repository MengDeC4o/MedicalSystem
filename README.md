# MedicalSystem
Software Engineering

This is a hospital Queueing system that mainly used for the queuing in hospital.
To run this program:
1. Start Database: run the sql file bokuno_database.sql in your mysql terminal.   
   Here's [a guide to run the sql file](https://sebhastian.com/mysql-running-sql-file/).
2. Change Password of mySql Database in "src/main/resources/application.properties".

```properties
      spring.datasource.username=root // your password username  
      spring.datasource.password=123456 // your password
```


3. Match this project's mySql version with your local mySql version in ./pom.xml

```xml
   	<dependency>
   		<groupId>mysql</groupId>
   		<artifactId>mysql-connector-java</artifactId>
   		<version>8.0.11</version>
   		<!--This version should match your local version-->
   	</dependency>
```



4. Start Backend: in the same directory of "bokuno_database.sql", run `mvn clean spring-boot:run` in the terminal.
5. Clone Frontend: the frontend is in a [different git repository](https://github.com/albertosarus23/my-app2).
6. Start Frontend: run `npm install` first. Then run `npm start`
7. now go to [frontend link](http://localhost:3000/) to see the working webpage.
