## Project-Data-structures-and-Algorithms
#A program applies cryptographic hashing to password verification. 

When you use some web service and enter your credentials to log in, it won’t send your password in plain-text through the network to the server to verify if the credentials are correct or not, because in that case message could be intercepted and then someone will know your password. Instead, a hash value of your password is computed on the client-side and then sent to the server which then compares that hash value with the hash value of the stored password. And if those are equal, you get authenticated. Special cryptographic hash functions are used for this purpose. It means that it is next to impossible to find another string that has the same hash value as your password. So you are secure. Nobody can actually construct a different string that has the same hash value as your password and then log in to your system, even if he intercepted the message with the hash value of your password going to the server. Today, most systems store hashed values of your password within their databases so that when you authenticate, the system has a way to validate your identity against an encrypted version of your password. 

![image](https://github.com/sangvpm0212/Project-Data-structures-and-Algorithms/assets/146159626/c75246e1-2f8f-4b0e-a89d-5c1194975001)

For additional security, some systems (Linux-based ones, for instance), add a salt, which is a 32-character string, to the end of the password before it’s hashed. This step prevents two of the same hashes from occurring as a result of two people having the same password, like “Pa$$word123.” By adding a unique salt to each, it’s impossible for the two hash values to be the same. The salting of passwords also makes them much harder to crack, which is valuable in the event of a data breach.

![image](https://github.com/sangvpm0212/Project-Data-structures-and-Algorithms/assets/146159626/700d1e06-7bc0-43f6-8241-e6cc4b911ab6)

***Purpose***

The primary purpose of this project is to create a simple password verification system that utilizes cryptographic hashing to ensure secure password storage and authentication. The system provides functionality for both user registration and login, applying secure practices such as salting and hashing passwords.


***Components***

The project consists of three main components:

  1.	LoginPanel: Handles user authentication by verifying entered credentials against stored hashed passwords.
  
  2.	RegisterPanel: Manages user registration, including generating salts, hashing passwords, and storing the credentials.
  
  3.	PasswordVerifier: The main application class that integrates both the registration and login panels into a user interface.


***Key Features***
  1.	Secure Password Storage:

    	o	Passwords are not stored in plain text. Instead, they are hashed using SHA-256.

    	o	Each password is salted before hashing to prevent attacks such as rainbow table attacks.
  3.	User Interface:

    	o	Uses Java Swing to create a graphical user interface (GUI).

    	o	Provides a tabbed pane for easy navigation between registration and login.
  5.	Input Validation:

    	o	Checks for empty username or password fields during both registration and login.

    	o	Prevents registration of duplicate usernames.


***Functionality***
  1.	Registration:

    	o	User inputs a username and password.

    	o	System checks if the username already exists.

    	o	A salt is generated and concatenated with the password.

    	o	The concatenated string is hashed using SHA-256.

    	o	The username, along with the salt and hashed password, is stored.
  3.	Login:

    	o	User inputs a username and password.

    	o	System retrieves the stored salt and hashed password for the given username.

    	o	The entered password is concatenated with the retrieved salt and hashed.

    	o	The system compares the newly hashed password with the stored hashed password to verify credentials.


***Code Structure***
  1.	LoginPanel:

    	o	Contains UI elements for username and password input, and a login button.

    	o	Validates input fields.

    	o	Retrieves stored credentials and verifies the entered password.
  3.	RegisterPanel:

    	o	Contains UI elements for username and password input, and a register button.

    	o	Validates input fields.

    	o	Generates a salt, hashes the password, and stores the credentials.
  5.	PasswordVerifier:

    	o	Sets up the main window with a tabbed pane containing the RegisterPanel and LoginPanel.

    	o	Launches the application.

     
***Security Practices***

  
  •	Salting: Adds random data to the password before hashing to ensure that identical passwords do not produce identical hashes.
  
  •	Hashing: Uses SHA-256, a cryptographic hash function, to convert the salted password into a fixed-size string that represents the password securely.
  
  •	Input Validation: Ensures that all input fields are properly filled and checks for the uniqueness of usernames during registration.


***Example Usage***
  1.	Registering a User:

  o	The user enters a username and a password.
    
  o	If the username is unique, the system generates a salt and hashes the password.
    
  o	The system stores the username along with the salt and hashed password.
    
  o	A success message is displayed to the user.

  2.	Logging in a User:
 
  o	The user enters a username and password.

  o	The system retrieves the stored salt and hashed password for the given username.
  
  o	The system hashes the entered password with the retrieved salt and compares it with the stored hash.

  o	If the hashes match, the user is successfully logged in; otherwise, an error message is displayed.


***Enhancements***

  Potential enhancements to the project could include:
  
  •	Implementing password complexity requirements.

  •	Adding functionality to handle password recovery.

  •	Enhancing the user interface for better user experience.

  •	Using more advanced password hashing algorithms like bcrypt or Argon2 for improved security.

  

**This project demonstrates fundamental concepts in cryptographic hashing, secure password storage, and basic user authentication mechanisms, providing a solid foundation for more advanced security** 

