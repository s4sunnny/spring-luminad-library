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

# Version

1. Java version - 11
2. Spring version - 2.6.1
3. Angular version - 13.2.6

# How Authentication/Authorization works

So as this projects has integrated token based authentication.
so how it works is ->

1. As this doesnt consist of Registration module so it directly starts from thenuser login module.
2. so when ever user hits the url ie, http://localhost:4200 a login page get showed up.
3. wherein user need to input the valid username and password.
4. after which userlogin api gets hit in the backend. wherein it checks first by calling loadByUsername method ie, whether user exists or not.
5. if user doesnt exists it will return an error saying unauthorized else it will return user object whereing we are providing UserAuthority to it and casting it to custom made UserSession which stores Current user object.
6. After this an authenticate method is being called wherein it validated the username and try to authenticate user by using Authentication manager.
7. if user password gets validated then it will generate token by calling a method named generateToken from jwtToken util.
8. so heres how token is been generated in generateToken method it just requires the UserDetails that needs to be passed.
9. After which a doGenerateToken method is being called internally. wherein a predefined method is being used to generate token for example Jwts.builder() method is used.
10. By using Jwts.builder() method we need to pass the claim that will consists of key value pair of names after which we need to pass subject that will consist of username and then the issued date and token expired date that also need to passed.
11. after which we need to sign it with the secret key and a signature algorithm that we can store it globally.
12. so here's how our token generation will look like - Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
13. once our Token got generated our method will return the JWT token with message and status code in response.


So here is how our Authentication mechanism works

before all this we need to define and inject all the configuration globally in Spring configuration
1. firstly  we need to define the Entry point where our api will get hit first. i.e, AuthenticationEntryPoint interface needs to be implemented first and it will check always check the api which is been requested whether it requires Authentication or not 
2. if it requires Authentication then it will forward the request to JwtRequestFilter wherein it tries to get Authorization token from request header.
3. If the token is null then it will throw an exception 401 else if will validate the token which is retrieved from the Request header.
4. if the token is valid then it will forward the request to userService call loadByUsername method wherein the same process will happen again as said from line 59.
5. For Authenticating user we need to inject AuthenticationMAnager globally
6. And even to vaidating users password we also need to inject the BCryptPasswordEncoder globally so that users password will try to match and store the password in encrypted format.


As we use Angular as the fornt-end technologies we need to integrate CORS plicy wherein spring will allow requests from any machine by default.
