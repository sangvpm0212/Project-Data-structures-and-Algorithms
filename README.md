## Project-Data-structures-and-Algorithms
#A program applies cryptographic hashing to password verification. 

When you use some web service and enter your credentials to log in, it won’t send your password in plain-text through the network to the server to verify if the credentials are correct or not, because in that case message could be intercepted and then someone will know your password. Instead, a hash value of your password is computed on the client-side and then sent to the server which then compares that hash value with the hash value of the stored password. And if those are equal, you get authenticated. Special cryptographic hash functions are used for this purpose. It means that it is next to impossible to find another string that has the same hash value as your password. So you are secure. Nobody can actually construct a different string that has the same hash value as your password and then log in to your system, even if he intercepted the message with the hash value of your password going to the server.

Today, most systems store hashed values of your password within their databases so that when you authenticate, the system has a way to validate your identity against an encrypted version of your password. 

For additional security, some systems (Linux-based ones, for instance), add a salt, which is a 32-character string, to the end of the password before it’s hashed. This step prevents two of the same hashes from occurring as a result of two people having the same password, like “Pa$$word123.” By adding a unique salt to each, it’s impossible for the two hash values to be the same. The salting of passwords also makes them much harder to crack, which is valuable in the event of a data breach.

![image](https://github.com/sangvpm0212/Project-Data-structures-and-Algorithms/assets/146159626/ecc5120b-5b5b-41af-b680-82a81a3c6f00)
