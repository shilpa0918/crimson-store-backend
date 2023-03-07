package crimson.store.backend.service;

import crimson.store.backend.entity.Users;
import crimson.store.backend.repo.UsersRepo;
import crimson.store.backend.request.UserLoginRequest;
import crimson.store.backend.request.UserRequest;
import crimson.store.backend.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UsersRepo usersRepo;

    public UserResponse addUser(UserRequest userRequest) {

        Users user = new Users();
        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setContactNo(userRequest.getContactNo());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        Users addedUser = usersRepo.saveAndFlush(user);
        return ConvertedToUserDto(addedUser);
    }

    private UserResponse ConvertedToUserDto(Users userRequest) {
        UserResponse user = new UserResponse();
        user.setEmail(userRequest.getEmail());
        user.setContactNo(userRequest.getContactNo());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setUserName(userRequest.getUserName());
        return user;
    }

    public List<UserResponse> getAllUsers() {
        List<Users> users = usersRepo.findAll();
        List<UserResponse> userResponses = users.stream().map(user -> {
            UserResponse userResponse = new UserResponse();
            userResponse.setEmail(user.getEmail());
            userResponse.setContactNo(user.getContactNo());
            userResponse.setName(user.getName());
            userResponse.setPassword(user.getPassword());
            userResponse.setUserName(user.getUserName());
            return userResponse;
        }).collect(Collectors.toList());
        return userResponses;
    }

    public String loginUser(UserLoginRequest userLoginRequest) {

        Users users = usersRepo.findByUserName(userLoginRequest.getUserName());
        if (userLoginRequest.getUserName().equalsIgnoreCase(users.getUserName()) && userLoginRequest.getPassword().equalsIgnoreCase(users.getPassword())) {
            return "User logged in successfully!!";
        } else
            return "Please enter proper username & password!!";
    }
}
