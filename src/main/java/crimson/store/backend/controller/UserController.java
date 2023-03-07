package crimson.store.backend.controller;

import crimson.store.backend.entity.Users;
import crimson.store.backend.request.UserLoginRequest;
import crimson.store.backend.request.UserRequest;
import crimson.store.backend.response.UserResponse;
import crimson.store.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/api/v1")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/user")
    public ResponseEntity addUser(@RequestBody UserRequest userRequest){
        UserResponse userResponse = userService.addUser(userRequest);
        return new ResponseEntity(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity getAllUsers(){
        List<UserResponse> users =  userService.getAllUsers();
        return new ResponseEntity(users,HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserLoginRequest userLoginRequest){
        String login = userService.loginUser(userLoginRequest);
        return new ResponseEntity(login,HttpStatus.OK);

    }
}
