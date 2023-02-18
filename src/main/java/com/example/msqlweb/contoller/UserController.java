package com.example.msqlweb.contoller;

import com.example.msqlweb.model.User;
import com.example.msqlweb.repository.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.msqlweb.exception.UserNotFoundException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {


    @Autowired
//    The @Autowired annotation provides more
//    fine-grained control over where and how autowiring should be accomplished.
//    The @Autowired annotation can be used to autowire bean on the
//    setter method just like @Required annotation, constructor,
//    a property or methods with arbitrary names and/or multiple arguments.
    private UserRepository userRepository;
    @PostMapping("/user")
    //for reference for this method https://www.javatpoint.com/spring-boot-annotations
    User newUser(@RequestBody User newUser)
    //When we annotate a method parameter with @RequestBody,
    // the Spring framework binds the incoming HTTP request body to that parameter.
    {
        return userRepository.save(newUser);
    }

@GetMapping("/users")
    List<User> getAUsers(){
        return  userRepository.findAll();//seach all data in database

}
@GetMapping("/user/{id}")
User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
}
@PutMapping("/user/{id}")
  User updateUser( @RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                return userRepository.save(user);
                }).orElseThrow(()-> new UserNotFoundException(id));
    }
@DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if (!userRepository.existsById(id)){
           throw new UserNotFoundException(id);
        }
userRepository.deleteById(id);
        return "User with id "+ id+" id deleted ";

}




}




