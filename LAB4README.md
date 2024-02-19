Gkanderi-LAB4-ORM AND JPA

1. Explanation of Business domain:
I have choosen to work with Car inventory management system.
This Domain involves various aspecsts of purchase, sale, maintenance, and inventory storage.
Car inventory management systems are essential for businesses like rental agencies, and automotive service centers to efficiently handle their inventory, streamline operations, and provide better customer service. By focusing on this domain, we can demonstrate practical database operations and testing methodologies using Java Persistence API (JPA) and JUnit, while we can learn various topics in advanced Programming.

2.Additional Entities and Relationships we can build in this final project:
While the primary focus is on managing the rental of cars, incorporating additional entities can enhance the functionality and realism of the car rental management system. Some potential entities include:

Customer: 
Represents individuals or organizations renting cars from the rental service. Customer entities may have attributes such as name, contact information,and rental history.

Reservation: 
Records reservations made by customers to rent specific cars for specific dates and times. Each reservation includes details like the rental period, pickup/drop-off locations, and reservation status.

Car Category:
Represents categories or types of cars available for rental, such as economy, midsize, or luxury. Car category entities can store details like the category name, description, and rental rates associated with each category.

Test Cases:

Create operation:

Creating two entities audi and merc.


Code snippet for creating a new entity:
Code snippet for creating two entities.


![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/7d19219c-700b-4073-9021-cab452a582c3)

Two entities Audi and merc were created successfully as shown in snap.

DB Snippet of the create entity:

Dates for both cars mrc and audi were set to 2022-12-10

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/e580dd26-2f6c-4537-8bfc-e53d4cded9fe)




Read Operation:
Read entity details:
ID: 1
Name: bmw
Buy Date: 2022-12-10
Type: Petrol

The above entity has been read successfully and shown in the console.

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/292effa2-b90e-4bcd-89df-b9f2d5de5dac)




Update Operation:

Date for the merc car has been changed from 2022-12-10 to 2023-10-01.


![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/3e74f23a-b80b-419d-8345-cef811bbb7ac)




Delete Operation:

One record has been deleted which is AUDI:



![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/2e28ecbd-aa17-48f8-9077-aa3317c23f13)


Additional Requirements for Graduates:
Created a second JUnit class for bean Validation named: CarValidationTest


Snap of bean validation succesws messages from print statements:

Code snippet:



![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/c9674ee7-1b32-46f6-a17a-8b099adba4e7)



Console message:

The snap shows all 6 test cases has been executed and passed the validations.



![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/278b5879-5b89-418a-b95c-dbfad7b258e6)











