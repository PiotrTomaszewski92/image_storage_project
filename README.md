# Image Storage Project

Project is intended to upload images to external server (Cloudinary). To implement I used:
* Spring Boot, WEB, Security
* Java 11
* Remotemysql - remote MySql database
* Cloudinary API to upload images
* Vaadin

###Project structure

- configuration
    - ```CloudinaryConfig.java```
        - [unpublic] Java class with configuration to access Cloudinary API. This implements ```public static Map<String,String> getConfigMap()``` static method, which has configuration like: 
        ```
        ObjectUtils.asMap(
                        "cloud_name",   "...name of your cloud...",
                        "api_key",      "...your api key...",
                        "api_secret",   "...your api secret..."
                        )
        ```
    - ```WebSecurityConfig.java```
        - Java class with security configuration to authentication and authorisation User. Also, class has endpoints authorisation for specific group.
        When user is getting or setting from / to database, I use PasswordEncoder to encode password using BCrypt algorithm.
- controller
    - ```TestApi.java```
        - Class with ```@RestController``` annotation and endpoints to test login and show specify information for specify group of users.
- gui
    - ``UploadGui.java``
        - Class which implement GUI to shof TextField and Button to type image URL and send it to 'backend'. When image will add to Server Api, this page will show message with http address of image and exact image.
- model
    - ``User.java``
        - Entity class which mapping information of users which can have access to website. This class also implements UserDetails Interface, with methods related to authentication during login.
- repository
    - ``UserRepo.java``
        - Interface which extends JpaRepository for User Model. Inside, is declared method to find user by username.
- service
    - ``ImageUploaderService.java``
        - Service, which make connection to Cloudinary API and can send image to their server. 
    - ``UserDetailsServiceImpl``
        - Service class to communicate between repository and login process. This implements UserDetailsService interface with method ``UserDetailsService``, where return UserDetails after call database query.
            
- DemospringbootImageUploaderApplication.java - Class to run Spring application


### How to start

1. You can clone / download code of this repository. 
2. Make account on _remotemysql.com_ to make remote database. 
3. Type URL, Login and Password, from your remote database, to properties file with ``spring.datasource.*`` prefix.
4. Also, you can make connection in your IDE with Database section
5. This project automatically create and insert users to table in this database ```[WebSecurityConfig.configure(HttpSecurity http)]```.
6. To check access you can call ``http://localhost:8080/test2`` and type login and password (for USER and ADMIN role). Check, is it ok?
7. Call ``http://localhost:8080/uploadImage``,later login as an ADMIN role , in the end type to TextField area your address of image from your computer. Press 'upload' button. It should return address of images on Cloudinary server with exact uploaded image.

### What is next?

- Implements endpoint for user to show uploaded images.
- Tests project
- Implemens CSS to make prettier view for users.  
