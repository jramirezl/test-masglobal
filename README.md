# MasGlobal test

Employees API query APP

## Getting Started

Swagger will guide the input parameters for the services

To run the project open the console and use:

```mvn clean install```

and then 
```mvn spring-boot:run```

* [Index Swagger](http://localhost:8080/swagger-ui.htm)
* [Index Eemployees Page](http://localhost:8080/employees-view/home)

### Prerequisites

* java 8 
* maven


### Considerations
- Mocked database on the repository layer
- Each Time
- The project is going to run on the defaults configurtion: `localhost:8080`

### Features

- REST API with the url prefix `employees-api` and the view pages with the url `employees-view`

- Data access layer that consumes the following API (that you can test through swagger) as your data repository.
- Business Logic layer so you can retrieve the employees’ information including a calculated Annual Salary following these rules:
    - Create your DTO (Data Transfer Object) Classes depending on the type of Contract that a given employee has (Hourly or Monthly).
    - Make use of a simple Factory Method to create the concrete classes so you can calculate the salary depending on the type of contract.
    - Use the builder pattern, lambdas, functional interfaces or Streams to simplify your algorithm.
- Employees can have to 2 types of Contracts: Hourly Salary Contract and Monthly Salary Contract.
    - For Hourly Salary Employees the Annual Salary is:
        - 120 * HourlySalary * 12
    - For Monthly Salary Employees the Annual Salary is:
        - MonthtlySalary * 12
- REST “WEB SERVICE”/API that returns information for a given employee by it’s ID or multiple employees using JSON

The view contains a textbox, so the user could type the id of an employee.
- The view contains a "Get Employees" button.
- If the textbox is empty, when the Get Employees button is clicked, retrieve the information for all the employees including the calculated Annual Salaries by calling your API.
- If the textbox has the id of a given employee, retrieve only the information for that employee including the calculated Annual Salary by calling your API.
- Information is displayed in a table that can be manually styled or using Datatable library.


### Bonus Points
- Test created for the service `EmployeeService` located on the class `EmployeeServiceTest`
- Big-O methods documented for `com.masglobalconsulting.javatest.service.EmployeesService.getEmployeeList()`
- Used Springboot to creat teh REst API WS - with swagger. MVC framework with utilis to create the Service layer
and the IoC and DI  pattern applied to wire and compose classes easily thinking in the Unit testing and mocking classes


### Future Improvements
- Add validations for invalid data
- Improve page styling
- Add liquibase and H2 to have a DB persistence layer

## Deployment

run ```mvn install``` and  to run t 
and then 
```mvn spring-boot:run```

### Running tests

to run test open the terminal on the project folder and run 
``mvn test``

## Built With

* [SpringBoot](https://spring.io/projects/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [thymeleaf.org](https://www.thymeleaf.org/) - MVC View templates management
* [JQuery](https://jquery.com/) - JS on the page
* [Datatable](https://datatables.net/) - Datatable plugin for jquery.
* [Bootstrap](https://getbootstrap.com/) - CSS for styling the website
* [popper](https://popper.js.org/) - Tooltip utils
* [projectlombok](https://projectlombok.org/) - Usefull annotations for Objects
* [webjars](https://www.webjars.org/) - JS libraries on maven
* [springfox-swagger-ui](https://github.com/Netflix/Hystrix) - API documentation



## Authors

* **Juan Pablo Ramirez L** - *Initial work* 

