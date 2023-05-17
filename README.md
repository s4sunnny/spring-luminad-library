# spring-luminad-library

This is Java Spring Boot based project which is used to manage Library books. It consist of Java(programming language), Spring Boot(framework),
JPA(Spring Data JPA), JWT(JSON Web Token)(Token Based Authentication), MySql(Database). 

This project is can be used to manage Library books. It can store Books details such as --

1. Book Id
2. Title
3. Author
4. Publication date
5. IBSN number
6. Number of pages

# API Usage

1. getBooks - Use to get list of books details - any user can access this api
2. getBookById - Use to get a book by providing book id to it - any user can access
3. addBook - Use to add new book to the table - only Admin user has the rights 
4. updateBookById - use to update specific book on the basis of book id - only Admin user has the rights 
5. deleteBookById - Use to delete book on the basis of provided book id - only Admin user has the rights 

# Access rights

As of now only minimal access rights has been added.

only 2 user have the rights one is Admin user abd other is Other user.

# Security

Currently low level Security is been applied.
Additional Security can be implemented to it as per the requirement. 

# How to Run

To use this project you first need to [Download](https://github.com/sunny12121/angular-luminad-library) and setup the angular based project that is been used for the frontend part. 
i.e, for the UI part after which you can use this spring project

CORS has been configured with the default configuration.

only you need to take pull of this Spring based project in any of the IDE for example STS.
After which you just need to run this project as run as Spring boot app.

#
