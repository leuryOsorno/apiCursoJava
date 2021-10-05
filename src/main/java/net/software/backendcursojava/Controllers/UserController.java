package net.software.backendcursojava.Controllers;

import org.springframework.web.bind.annotation.RestController;

import net.software.backendcursojava.models.request.UserDetailRequestModel;
import net.software.backendcursojava.models.responses.UserRest;
import net.software.backendcursojava.services.UserServiceInterface;
import net.software.backendcursojava.shared.dto.UserDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users") //localhost:8080/users

public class UserController {

    @Autowired
    UserServiceInterface userService;


    @GetMapping
    public String getUser(){
        return "Obteniendo usuarios";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails){
        UserRest userToReturn = new UserRest();
        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO createdUser = userService.createUser(userDTO);

        BeanUtils.copyProperties(createdUser, userToReturn);
        
        return userToReturn;

    }
    
}
