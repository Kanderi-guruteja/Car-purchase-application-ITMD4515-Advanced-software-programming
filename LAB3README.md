gkanderi LAB3 README.md file

Using Lab2 POJO and refined for using in this Lab3

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/7da68fe5-6435-4a67-bf9b-c424e6117825)

City.jsp:

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/2396ea53-1eba-433d-b681-04db10bf514e)

Initially i took 5 parameters to validate and ended up with some errors at the end so removed 2 parameters population and District.You will see 5 parameters in the validation sets violation constraints but while injecting to the database i removed two parameters.

Validation sets:

Filling data to acheive DO post:

 ![Filling details to get do post](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/046a76bc-15f1-449a-af39-f5cba2d40fe1)
 
Obtained data in Do post:

![Info in do post payara ](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/8ccd73d6-4a3f-4c2e-bdda-fda4bb2918d6)



![validation sets](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/b93bc5f7-cc3e-431e-a4e2-52e09883e511)

Violation Constraints :

Before:

![violation constraints](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/133af141-8827-44e5-b6a0-9c43705404d2)


After Violation:

![image](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/949f92bc-d35c-4c59-9e27-47587fe66e07)


Connection to DB and adding a City to DB:


Adding data in Web page confirmation:

![Dataconfirmation1](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/cf64b2a9-7db4-49a2-bb7f-d86df363305f)

Confirmation in Data Base:

![Confirmation in DB](https://github.com/itmd4515/itmd4515-s24-fp-Kanderi-guruteja/assets/105558277/4c0a2af7-519a-448f-93ff-4b79ed52daa9)

Question and answers:

Understandings:

1. Your understanding of the difference between the forward and redirect operations.
   
 ANS: Understanding the difference between forward and redirect operations is crucial in web development. With a forward operation, the request is internally directed within the server, keeping the client unaware of the change, and maintaining the same URL in the browser. On the other hand, a redirect operation sends a new URL to the client's browser, triggering a new request. This results in a visible change in the browser's address bar.

2.How would you be validating user submissions without the Bean Validation API standard?

ANS: In the absence of the Bean Validation API standard, user submissions can still be validated using custom validation logic written within the application code. This involves manually checking each submitted field against specific validation criteria, such as ensuring no null values, proper data types, and adherence to predefined rules. Custom validation methods tailored to different data types can be created to handle validation requirements effectively.

3.How do you think this approach would scale to a real application with 100's of entities? 

ANS: As the application scales to handle hundreds of entities, implementing custom validation without the Bean Validation API may become challenging. With numerous entities, each potentially having different validation rules, managing custom validation logic for each entity can lead to code duplication and increased complexity. Maintaining consistency and ensuring thorough validation across the entire application can become more difficult as the complexity grows.

4.Why didn't we need to include any additional dependencies (i.e. Bean Validation, JDBC) in this project? 

ANS: The project did not require additional dependencies such as Bean Validation or JDBC because it utilized built-in features provided by the Java EE platform and the application server (Payara Server). The Java EE platform offers servlets, JSP, and JSTL for web development, while Payara Server provides JDBC connection pooling and data source management without additional dependencies. Therefore, external dependencies were not needed for basic web development and database access functionalities.
