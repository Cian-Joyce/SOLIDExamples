/*
* Last edited by Cian Joyce 23/03/2020
* A class to handle backend functions of GUI such as calling validate and store methods.
* */
package ie.gmit;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    //Handles incoming JSON requests that work on User resource/entity
    UserStorageHandler storageHandler;
        //Create a new user
        public String createUser(String userJson) throws IOException {
            ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(userJson, User.class);
            UserValidator validator = new UserValidator();  //creating instance of user validator class

            //run validate method from the validator class passing it users details for validation
            if(!validator.isValidUser(user))
            {
                return "ERROR";
            }
            storageHandler = new UserStorageHandler();  //crate an instance of the storage handler class
            storageHandler.storeUser(user);             //call storeUser method and pass user to be stored
            return "SUCCESS";
        }
 }

