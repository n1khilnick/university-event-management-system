# University Event Management System

## Built With
* `Java 17`
* `Maven 4.0.0`
* `Spring Boot 3.0.5`
*  `IntelliJ IDEA 2023.1 (Community Edition)`


## Data Flow

### 1. Model:
       1. Student Entity
* Created `Students` entity class along with data studentId, firstName, lastName, location, age, enum department and added validations on them.
* Used @Table and @Entity annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like @Data, @NoArgsConstructor, @AllArgsConstructor getters and setters for those object generate automatically.

       2. Events Entity
* Created `Events` entity class along with data eventId, eventName, eventLocation, date, salary, startTime, endTime and added validations on them.
* Used @Table and @Entity annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like @Data, @NoArgsConstructor, @AllArgsConstructor getters and setters for those object generate automatically.



### 2. Controller:
      2.1 Student Entity
* Created `StudentsController` class in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation @GetMapping , @PostMapping , @PutMapping , @DeleteMapping to map the HTTP web requests to the specific handler methods.
* Used @Valid annotations to trigger validations while inserting data.

      2.2 Student Entity
* Created `StudentsController` class in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation @GetMapping , @PostMapping , @PutMapping , @DeleteMapping to map the HTTP web requests to the specific handler methods.
* Used @Valid annotations to trigger validations while inserting data.

#### API Reference:
 
>Student's API References

* Add Students:
```*.sh-session
  http://localhost:8080/students/saveStudent
```

* Get all Students:
```*.sh-session
   http://localhost:8080/students/getAllStudents
```

* Get Student By ID:
```*.sh-session
  http://localhost:8080/students/{studentId}
```

* Update Student's Department By ID:
```*.sh-session
    http://localhost:8080/students/update/{studentId}/{department}}
```

* Delete Jobs by ID
```*.sh-session
   http://localhost:8080/students/delete/{studentId}
```

>Event's API References:

* Add Events:
```*.sh-session
  http://localhost:8080/events/createEvents
```

* Get all Events:
```*.sh-session
   http://localhost:8080/events/all
```

* Get Events(s) By Date:
```*.sh-session
  http://localhost:8080/events/{date}
```

* Update Event's Location By ID:
```*.sh-session
    http://localhost:8080/events/update/{eventId}/{eventLocation}
```

* Delete Event(s) by ID
```*.sh-session
   http://localhost:8080/events"/delete/{eventId}
```


### 3. Service:
    3.1 Student's
* Created `StudentService` class in which provide some business functionalities of every handler methods.
* Used **@Service** annotation to indicate that a class belongs to the service layer.
* Used @Transactional annotation to separate transaction management code from the code for business logic.
  
      3.2 Events's
* Created `EventService` class in which provide some business functionalities of every handler methods.
* Used **@Service** annotation to indicate that a class belongs to the service layer.
* Used @Transactional annotation to separate transaction management code from the code for business logic.


### 4. Repository:
    4.1 Student's
* Created `StudentDao` interface class that extends CrudRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used `Iterable<Students>` to manage the data of Users by performing CRUD operations.
* Used **@Repository** annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
* Used @Modifying annotation wrote named parameters query using @Query annotation to insert, update, or delete an entity.

      4.2 Event's
* Created `EventDao` interface class that extends CrudRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used `Iterable <Events>` to manage the data of Users by performing CRUD operations.
* Used **@Repository** annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
* Used @Modifying annotation wrote named parameters query using @Query annotation to insert, update, or delete an entity.


## Data Structure Used
Used `Iterable<Object>` to store the User and Event type objects.

## Project Summary
* In this project I performed CRUD operation on Student's and Events's Entities and validated these.
* Used interface CrudRepository class for generic CRUD inbuilt operations like save,saveAll,updateById, etc.
* Used our own custom finder methods and wrote operations using custom queries.